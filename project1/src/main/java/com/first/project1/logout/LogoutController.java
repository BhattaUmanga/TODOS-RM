package com.first.project1.logout;

import javax.resource.spi.work.SecurityContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogoutController {
	@RequestMapping(value="/logout", method=RequestMethod.GET)
public String logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth= SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null)
		{new SecurityContextLogoutHandler().logout(request, response, auth);
	request.getSession().invalidate();
		}
		
return("redirect:/");
	}
}