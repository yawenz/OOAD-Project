package spring.controllers;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

import model.PersonDao;
import model.UserGroup;
import model.createRemDao;
import model.removeUserDao;
import model.removeUser;
import spring.controllers.*;

import java.util.ArrayList;
import java.util.List;

import spring.controllers.WelcomeController;

@Controller
public class adminController {
	
	//SUSPEND USER
    @RequestMapping(value = "/suspendUser", method = RequestMethod.GET)
    public String suspend(Model model) {
         model.addAttribute("msg", "Suspend an existing user account");
         return "suspendUser";
    }
	@RequestMapping(value = "/suspendUser", method = RequestMethod.POST, params={"suspendUser"})
    public String suspend(Model model, @ModelAttribute("removeUser") removeUser rmUser,HttpSession session) {
		System.out.println("here"+rmUser.getUsername());
    	if (rmUser != null && rmUser.getUsername() != null) {
	    	removeUserDao dao = new removeUserDao();
	    	ReminderController rc = new ReminderController();
	        DriverManagerDataSource dataSource = rc.initialiseDataSource();
	        dao.setDataSource(dataSource);
	        if(dao.checkuser(rmUser.getUsername())) {
	        	dao.suspend(rmUser.getUsername());
	        	model.addAttribute("success", "User account has been suspended");
	        	return "adminMenu";
	        } else {
                model.addAttribute("error", "No such user found");
                return "suspendUser";
            }
        } else {
            model.addAttribute("error", "Please enter Details");
            return "suspendUser";
        }
	}
	@RequestMapping(value = "/suspendUser", method = RequestMethod.POST, params={"revokeUser"})
    public String revoke(Model model, @ModelAttribute("removeUser") removeUser rmUser,HttpSession session) {
		System.out.println("here"+rmUser.getUsername());
    	if (rmUser != null && rmUser.getUsername() != null) {
	    	removeUserDao dao = new removeUserDao();
	    	ReminderController rc = new ReminderController();
	        DriverManagerDataSource dataSource = rc.initialiseDataSource();
	        dao.setDataSource(dataSource);
	        if(dao.checkuser(rmUser.getUsername())) {
	        	dao.revoke(rmUser.getUsername());
	        	model.addAttribute("success", "Suspended user account has been revoked successfully");
	        	return "adminMenu";
	        } else {
                model.addAttribute("error", "No such user found");
                return "suspendUser";
            }
        } else {
            model.addAttribute("error", "Please enter Details");
            return "suspendUser";
        }
	}
    
	
	//DELETE USER
    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public String delete(Model model) {
        model.addAttribute("msg", "Delete an existing User");
        return "deleteUser";
    }
	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public String delete(Model model, @ModelAttribute("removeUser") removeUser rmUser,HttpSession session) {
		System.out.println("here"+rmUser.getUsername());
    	if (rmUser != null && rmUser.getUsername() != null) {
	    	removeUserDao dao = new removeUserDao();
	    	ReminderController rc = new ReminderController();
	        DriverManagerDataSource dataSource = rc.initialiseDataSource();
	        dao.setDataSource(dataSource);
	        if(dao.checkuser(rmUser.getUsername())) {
	        	dao.delete(rmUser.getUsername());
	        	model.addAttribute("success", "User account deleted successfully");
	        	return "adminMenu";
	        } else {
                model.addAttribute("error", "No such user found");
                return "deleteUser";
            }
        } else {
            model.addAttribute("error", "Please enter Details");
            return "deleteUser";
        }
	}
  	
	
	//USER LOG
    @RequestMapping(value = "/userLog", method = RequestMethod.GET)
    public String userLog(Model model) {
        model.addAttribute("msg", "Generate User Specific Log");
        return "userLog";
    }
	@RequestMapping(value = "/userLog", method = RequestMethod.POST)
    public String userLog(Model model, @ModelAttribute("removeUser") removeUser rmUser,HttpSession session) {
		System.out.println("here"+rmUser.getUsername());
    	if (rmUser != null && rmUser.getUsername() != null) {
	    	removeUserDao dao = new removeUserDao();
	    	ReminderController rc = new ReminderController();
	        DriverManagerDataSource dataSource = rc.initialiseDataSource();
	        dao.setDataSource(dataSource);
    		
	        if(dao.checkuser(rmUser.getUsername())) {
	        	System.out.println("About to get reminder info");
	        	String username = rmUser.getUsername();
	    		CreateRem Reminder =  new CreateRem();
	    		List<CreateRem> allReminders =  new ArrayList<CreateRem>();
	    		dao.setDataSource(dataSource);
	    		allReminders = dao.userLogUser(username);
				if(allReminders.size()!=0) {
					model.addAttribute("allReminders", allReminders);
				}
				else {
					model.addAttribute("allReminders", null);
				}
	    		return "userLogDisplay";
	    	} else {
	                model.addAttribute("error", "No such user found");
	                return "userLog"; 
		    }
    	}  else {
	            model.addAttribute("error", "Please enter Details");
	            return "userLog";
	    }
    }


	@RequestMapping(value = "/systemLog", method = RequestMethod.GET)
    public String systemLog(Model model, @ModelAttribute("removeUser") removeUser rmUser,HttpSession session) {
		   	removeUserDao dao = new removeUserDao();
	    	ReminderController rc = new ReminderController();
	        DriverManagerDataSource dataSource = rc.initialiseDataSource();
	        dao.setDataSource(dataSource);
	        CreateRem Reminder =  new CreateRem();
	    	List<CreateRem> syslog =  new ArrayList<CreateRem>();
	    	dao.setDataSource(dataSource);
	    	syslog = dao.systemLogUser();
			if(syslog.size()!=0) {
					model.addAttribute("syslog", syslog);
				}
			else {
					model.addAttribute("syslog", null);
			}
	    	return "systemLog";
	  } 
    
}
