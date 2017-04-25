package spring.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.controllers.WelcomeController;
import model.PersonDao;
import spring.controllers.LoginBean;
import spring.controllers.User;
import spring.controllers.CreateRem;
import model.createRemDao;

@Controller


public class ReminderController {
	
	@GetMapping("/CreateReminder")
	public String create(Model model,HttpSession session) {
		model.addAttribute("purpose","someuser");
		System.out.println(session.getAttribute("userName") + "logged in");
		return "createReminder";
	}
	@GetMapping("/EditReminder")
	public String edit(Model model) {
		model.addAttribute("purpose", "Edit");
		return "editReminder";
	}
	@GetMapping("/DeleteReminder")
	public String delete(Model model) {
		model.addAttribute("purpose", "Delete");
		return "deleteReminder";
	}
	@GetMapping("/CreateGroup")
	public String group(Model model) {
		model.addAttribute("purpose", "Create");
		return "createGroup";
	}
	/*
	@PostMapping("/CreateReminder")
	public String Remindersubmit(Model model, @ModelAttribute("createRem") CreateRem createRem) {
		if (createRem != null ) {
			System.out.println("Creating Reminder....with title "+ createRem.getName());
			createRemDao dao = new createRemDao();
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	        dataSource.setUrl("jdbc:mysql://localhost/USER");
	        dataSource.setUsername("root");
	        dataSource.setPassword("root");
	        // Inject the datasource into the dao
	        dao.setDataSource(dataSource);
	        dao.create(createRem);
	        	return "success";
			
		} else {
			model.addAttribute("error", "Oops! something went wrong");
			return "login";
		}
		
	} */
	@PostMapping("/CreateReminder")
	public String Remindersubmit(Model model, @ModelAttribute("CreateRem") CreateRem createRem,HttpSession session) {
		if (createRem != null ) {
			createRemDao dao = new createRemDao();
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	        dataSource.setUrl("jdbc:mysql://localhost/USER");
	        dataSource.setUsername("root");
	        dataSource.setPassword("root");
	        dao.setDataSource(dataSource);
	        createRem.setOwner(session.getAttribute("userName").toString());
	        System.out.println(session.getAttribute("userName").toString());
	        dao.create(createRem);
	    }
		return "success";
		}
	
}
