package spring.controllers;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.PersonDao;
import spring.controllers.LoginBean;
import spring.controllers.User;


@Controller

public class WelcomeController {
	@GetMapping("/welcome")
	public String welcome(Model model) {
		model.addAttribute("firstName", "first");
		return "welcomeMessage";
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
        dataSource.setUrl("jdbc:mysql://localhost/USER");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        // Inject the datasource into the dao
        dao.setDataSource(dataSource);

        dao.create(userForm.getUsername(), userForm.getPassword());
        /*System.out.println("came till here" + userForm.getUsername() + " " + userForm.getPassword());
        
        Session session = this.sessionFactory.getCurrentSession();
		session.persist(user);
		System.out.println("Person saved successfully, Person Details="+user);*/
        return "redirect:/login";
    }

	@RequestMapping(method = RequestMethod.POST)
	public String submit(Model model, @ModelAttribute("loginBean") LoginBean loginBean) {
		if (loginBean != null && loginBean.getUserName() != null & loginBean.getPassword() != null) {
			PersonDao dao = new PersonDao();
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	        dataSource.setUrl("jdbc:mysql://localhost/USER");
	        dataSource.setUsername("root");
	        dataSource.setPassword("root");
	        // Inject the datasource into the dao
	        dao.setDataSource(dataSource);
	        if(dao.checkuser(loginBean.getUserName(), loginBean.getPassword())){
			//if (loginBean.getUserName().equals("chandra") && loginBean.getPassword().equals("chandra123")) {
				model.addAttribute("msg", loginBean.getUserName());
				return "success";
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
