package spring.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.controllers.WelcomeController;
import model.FinalDelete;
import model.PersonDao;
import spring.controllers.LoginBean;
import spring.controllers.CreateRem;
import model.createRemDao;

@Controller


public class ReminderController {
	FinalDelete finaldelete	 = new FinalDelete();;
	public DriverManagerDataSource initialiseDataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/USER");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
	}@GetMapping("/CreateExistingReminder")
	public String createExisting(Model model,HttpSession session) {
		model.addAttribute("purpose","someuser");
		System.out.println(session.getAttribute("userName") + "logged in");
		return "createExistingReminder";
	}
	@GetMapping("/CreateReminder")
	public String create(Model model,HttpSession session) {
		model.addAttribute("purpose","someuser");
		System.out.println(session.getAttribute("userName") + "logged in");
		return "createReminder";
	}
	@GetMapping("/EditReminder")
	public String edit(Model model,@RequestParam("getId") int getId,HttpSession session) {
		String username=session.getAttribute("userName").toString();
		if(username!=""){
		DriverManagerDataSource dataSource = initialiseDataSource();
		System.out.println("editting reminder nwo");
		createRemDao allRems = new createRemDao();
		CreateRem Reminder =  new CreateRem();
		allRems.setDataSource(dataSource);
		Reminder=allRems.select(username,getId).get(0);
		if(Reminder !=null){
			System.out.println("got it");
			model.addAttribute("Reminder", Reminder);
			session.setAttribute("reminderobjtoedit", Reminder);
			}
		else
			model.addAttribute("Reminder", null);
		return "editReminder";
		}
		else{
		return "redirect:/welcome";	
		}
		}
		

	@PostMapping("/EditReminder")
	public String editSubmit(Model model,@ModelAttribute("CreateRem") CreateRem editRem,HttpSession session) {
		CreateRem temp = (CreateRem) session.getAttribute("reminderobjtoedit");
		editRem.setID(temp.getID());
		DriverManagerDataSource dataSource = initialiseDataSource();
		createRemDao allRems = new createRemDao();
		allRems.setDataSource(dataSource);
		allRems.update(editRem);
	return "redirect:/welcome";
	}
	@GetMapping("/DeleteReminder")
	public String delete(Model model,@RequestParam("getId") int getId,HttpSession session) {
		String username=session.getAttribute("userName").toString();
		DriverManagerDataSource dataSource = initialiseDataSource();
		createRemDao allRems = new createRemDao();
		CreateRem Reminder;
		allRems.setDataSource(dataSource);
		Reminder=allRems.select(username,getId).get(0);
		finaldelete.performDelete(Reminder);
		System.out.println("pushed reminder to stack with id"+ Reminder.getID());
		allRems.delete(username,getId);
		return "redirect:/welcome"; 
	
	}
	@PostMapping("/CreateReminder")
	public String Remindersubmit(Model model, @ModelAttribute("CreateRem") CreateRem createRem,HttpSession session) {
		if (createRem != null ) {
			createRemDao dao = new createRemDao();
			DriverManagerDataSource dataSource = initialiseDataSource();
			dao.setDataSource(dataSource);
	        createRem.setOwner(session.getAttribute("userName").toString());
	        System.out.println(createRem.getTitle());
	        dao.create(createRem);
	    }
		return "redirect:/welcome";
		}
	@GetMapping("/UndoDelete")
	public String undoDelete(Model model, HttpSession session) {
		System.out.println("undo delete");
			createRemDao dao = new createRemDao();
			DriverManagerDataSource dataSource = initialiseDataSource();
			dao.setDataSource(dataSource);
	        CreateRem createRem = finaldelete.undo();
	        System.out.println(createRem.getTitle());
	        dao.create(createRem);
	    return "redirect:/welcome";
		}
	@PostMapping("/CreateExistingReminder")
	public String createExistingReminder(Model model, @ModelAttribute("CreateRem") CreateRem createRem,HttpSession session) {
		if (createRem != null ) {
			createRemDao dao = new createRemDao();
			DriverManagerDataSource dataSource = initialiseDataSource();
			dao.setDataSource(dataSource);
	        createRem.setOwner(session.getAttribute("userName").toString());
	        System.out.println(createRem.getTitle());
	        dao.create(createRem);
	    }
		return "redirect:/welcome";
	}	
}
