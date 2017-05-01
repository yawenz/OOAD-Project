package spring.controllers;

import java.security.acl.Group;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.GroupDao;
import model.PersonDao;
import model.UserGroup;
import model.createRemDao;
import spring.controllers.ReminderController;

@Controller
public class GroupController {
	@GetMapping("/CreateGroup")
	public String create(Model model,HttpSession session) {
		model.addAttribute("purpose","someuser");
		System.out.println(session.getAttribute("userName") + "logged in");
		return "createGroup";
	}
	//createGroup: insert group, insert usergroup, then redirect to groupReminderSelect.jsp
	@PostMapping("/CreateGroup")
	public String createSubmit(Model model, @ModelAttribute("UserGroup") UserGroup userGroup, HttpSession session) {
		System.out.println("in createSubmit");
		if(userGroup != null) {
			ReminderController rem = new ReminderController();
			DriverManagerDataSource dataSource = rem.initialiseDataSource();
			GroupDao dao=new GroupDao();
			dao.setDataSource(dataSource);
			//insert Group
			System.out.println("to create group");
			int groupid=dao.createGroup(userGroup.getGroupName(), userGroup.getGroupDescription());
			session.setAttribute("group_id", Integer.toString(groupid));
			System.out.println("after insert to Groups table");
			//insert UserGroup
			List<String> userNames=new ArrayList<String>();
			userNames.add(session.getAttribute("userName").toString());
			PersonDao dao2=new PersonDao();
			//. check if GroupMember1 exists as an account
			dao2.setDataSource(dataSource);
			if (!dao2.check_userexist(userGroup.getGroupMember1())){
				System.out.println("GroupMember1 not exist!");
				model.addAttribute("error_message", "Error: group member is not an account!");
				model.addAttribute("return_page", "/LifeWisely/CreateGroup");
				return("showError");
			}	
			userNames.add(userGroup.getGroupMember1());
			dao.createUserGroup(groupid, userNames);
			System.out.println("after insert to UserGroup table");
			//redirect
			return("groupReminderSelection");
		}
		return("createGroup");
	}
	@GetMapping("listMyRemindersAndSelectForGroup")
	public String listMyRemindersAndSelectForGroup(Model model, HttpSession session){
		ReminderController rem = new ReminderController();
		DriverManagerDataSource dataSource = rem.initialiseDataSource();
        
		String username=session.getAttribute("userName").toString();
		createRemDao allRems = new createRemDao();
		List<CreateRem> allReminders =  new ArrayList<CreateRem>();
		allRems.setDataSource(dataSource);
		allReminders=allRems.selectAll(username);
		System.out.println(allReminders.size());
		if(allReminders.size()!=0)
			model.addAttribute("allReminders", allReminders);
		else
			model.addAttribute("allReminders", null);
		return "listMyRemindersAndSelectForGroup";
	}
	//after create Groups/UserGroup, select individual reminder as group reminder
	@GetMapping("AddAsGroupReminder")
	public String addAsGroupReminder(Model model,@RequestParam("getId") int getId,HttpSession session) {
		ReminderController rem = new ReminderController();
		DriverManagerDataSource dataSource = rem.initialiseDataSource();
        
        String username=session.getAttribute("userName").toString();
        GroupDao dao = new GroupDao();
        dao.setDataSource(dataSource);
        System.out.println("to bind");
        System.out.println(session.getAttribute("group_id").toString());
        System.out.println(Integer.parseInt(session.getAttribute("group_id").toString()));
        System.out.println(getId);
        dao.bindGroupReminder(Integer.parseInt(session.getAttribute("group_id").toString()), getId);
		return("redirect:/welcome");
	}
	@GetMapping("createReminderForGroup")
	public String createReminderForGroup(Model model, HttpSession session){
		model.addAttribute("purpose","someuser");
		System.out.println(session.getAttribute("userName") + "logged in");
		return "createReminderForGroup";
	}
	@PostMapping("createReminderForGroup")
	public String createReminderForGroupSubmit(Model model, @ModelAttribute("createReminderForGroup") CreateRem rem, HttpSession session){
		if (rem != null ) {
			createRemDao dao = new createRemDao();
			ReminderController reminderController = new ReminderController();
			DriverManagerDataSource dataSource = reminderController.initialiseDataSource();
	        dao.setDataSource(dataSource);
	        //rem.setOwner(session.getAttribute("userName").toString());
	        System.out.println(session.getAttribute("userName").toString());
	        int reminder_id=dao.createAndGetId(rem);
	        GroupDao dao2=new GroupDao();
	        dao2.setDataSource(dataSource);
	        dao2.bindGroupReminder(Integer.parseInt(session.getAttribute("group_id").toString()), reminder_id);
	        return "redirect:/welcome";
	    } else{
	    	return "redirect:/createReminderForGroup";
	    }
	}
	@GetMapping("LeaveGroup")
	public String userLeaveGroup(Model model,@RequestParam("getId") int getId,HttpSession session) {
		ReminderController rem = new ReminderController();
		DriverManagerDataSource dataSource = rem.initialiseDataSource();
		
        String username=session.getAttribute("userName").toString();
        GroupDao dao = new GroupDao();
        dao.setDataSource(dataSource);
        System.out.println("before userLeaveGroup");
        dao.userLeaveGroup(username, getId);
        System.out.println("after userLeaveGroup");
        return("redirect:/welcome");
	}
	
}
