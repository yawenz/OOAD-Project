package spring.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.CreateRemRowMapper;
import model.GroupDao;
import model.PersonDao;
import model.UserGroup;
import model.UserGroupResultExtractor;
import model.createRemDao;
import spring.controllers.LoginBean;
import spring.controllers.User;


@Controller

public class WelcomeController {
	public String logusername;
	@GetMapping("/welcome")
	public String welcome(Model model,HttpSession session) {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/user");
        dataSource.setUsername("root");
        dataSource.setPassword("1989zyw");
        
		String username=session.getAttribute("userName").toString();
		createRemDao allRems = new createRemDao();
		List<CreateRem> allReminders =  new ArrayList<CreateRem>();
		allRems.setDataSource(dataSource);
		allReminders=allRems.selectAll(username);
		System.out.println("came here to redirect");
		if(allReminders.size()!=0)
			model.addAttribute("allReminders", allReminders);
		else
			model.addAttribute("allReminders", null);
		//for group reminders
		System.out.println("111");
		GroupDao dao=new GroupDao();
		dao.setDataSource(dataSource);
		List <UserGroup> allGroupReminders=new ArrayList<UserGroup>();
		allGroupReminders=dao.selectAll(username);
		System.out.println("after selectAll usergroup");
		System.out.println(allGroupReminders.size());
		if(allGroupReminders.size()!=0)
			model.addAttribute("allGroupReminders", allGroupReminders);
		else
			model.addAttribute("allGroupReminders", null);
		return "success";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String init(Model model) {
		model.addAttribute("msg", "Please Enter Your Login Details");
		return "login";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        
        return "register";
    }
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("User") User userForm, Model model) {
    	PersonDao dao = new PersonDao();
        // Initialize the datasource, could /should be done of Spring
        // configuration
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/user");
        dataSource.setUsername("root");
        dataSource.setPassword("1989zyw");
        // Inject the datasource into the dao
        dao.setDataSource(dataSource);
        dao.create(userForm.getUsername(), userForm.getPassword());
        return "redirect:/login";
    }

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String submit(Model model, @ModelAttribute("loginBean") LoginBean loginBean,HttpSession session) {
		if (loginBean != null && loginBean.getUserName() != null & loginBean.getPassword() != null) {
			PersonDao dao = new PersonDao();
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/user");
	        dataSource.setUsername("root");
	        dataSource.setPassword("1989zyw");
	        // Inject the datasource into the dao
	        dao.setDataSource(dataSource);
	        if(dao.checkuser(loginBean.getUserName(), loginBean.getPassword())){
				model.addAttribute("UserName", loginBean.getUserName());
				model.asMap().put("UserName",loginBean.getUserName() );
				session.setAttribute("userName", loginBean.getUserName());
				createRemDao allRems = new createRemDao();
				List<CreateRem> allReminders =  new ArrayList<CreateRem>();
				allRems.setDataSource(dataSource);
				allReminders=allRems.selectAll(loginBean.getUserName());
				if(allReminders.size()!=0)
				model.addAttribute("allReminders", allReminders);
				else
					model.addAttribute("allReminders", null);
				return "redirect:/welcome";
			} else {
				model.addAttribute("error", "Invalid Details");
				return "login";
			}
		} else {
			model.addAttribute("error", "Please enter Details");
			return "login";
		}
	}
	
}
