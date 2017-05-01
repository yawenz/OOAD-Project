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
	public String edit(Model model,@RequestParam("getId") int getId,HttpSession session) {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/user");
        dataSource.setUsername("root");
        dataSource.setPassword("1989zyw");
        
		String username=session.getAttribute("userName").toString();
		createRemDao allRems = new createRemDao();
		CreateRem Reminder =  new CreateRem();
		allRems.setDataSource(dataSource);
		Reminder=allRems.select(username,getId).get(0);
		System.out.println("came here to edit");
		if(Reminder !=null)
		model.addAttribute("Reminder", Reminder);
		else
		model.addAttribute("Reminder", null);
		
		return "editReminder";
	}
	@PostMapping("/EditReminder")
	public String editSubmit(Model model,HttpSession session) {
		System.out.println("redirected to edit");
	return "redirect:/welcome";
	}
	@GetMapping("/DeleteReminder")
	public String delete(Model model) {
		model.addAttribute("purpose", "Delete");
		return "deleteReminder";
	}
	/*
	@GetMapping("/CreateGroup")
	public String group(Model model) {
		model.addAttribute("purpose", "Create");
		return "createGroup";
	} */
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
	        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/user");
	        dataSource.setUsername("root");
	        dataSource.setPassword("1989zyw");
	        dao.setDataSource(dataSource);
	        createRem.setOwner(session.getAttribute("userName").toString());
	        System.out.println(session.getAttribute("userName").toString());
	        dao.create(createRem);
	    }
		return "redirect:/welcome";
		}
	
}
