package com.first.project1.login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.first.project1.todo.TodoService;


@Controller
//@SessionAttributes("name")
public class WelcomeController {
//	@Autowired
//	private LoginService service;
	@RequestMapping(value = "/",method = RequestMethod.GET)
	
	public String showLoginPage(ModelMap map) {
		map.put("name", "umanga");
		return "welcome";
	}


}

