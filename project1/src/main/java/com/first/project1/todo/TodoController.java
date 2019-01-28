package com.first.project1.todo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.management.RuntimeErrorException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class TodoController {

	@Autowired
	private TodoService service;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateformat, false) );
	}



	@RequestMapping(value = "/listtodos", method = RequestMethod.GET)
	public String showLoginPage(  ModelMap model) {
		String user= retriveuser();
		model.addAttribute("to", service.retrieveTodos(user));
		return "listtodos";
	}



	public String retriveuser() {
		Object principal=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal  instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}
		return((UserDetails)principal).getUsername().toString();
	}
	@RequestMapping(value = "/addtodo", method = RequestMethod.GET)
	public String showaddtodoPage(  ModelMap model) {
	model.addAttribute("todo", new Todo(0,"in28Minutes","",new Date(),false));
		return "addtodo";
	}
	@RequestMapping(value="/addtodo",method=RequestMethod.POST)
	public String addtodo(@Valid Todo todo,BindingResult result ) {
		if (result.hasErrors()){
			return "addtodo";
		}
		service.addTodo("umanga",todo.getDesc(), new Date(), false);
	return "redirect:listtodos";
}
	@RequestMapping(value="/deletetodo", method=RequestMethod.GET)
	public String deletetodo(@RequestParam int id) {
		service.deleteTodo(id);
		return "redirect:listtodos";
	}
	@RequestMapping(value="/updatetodo", method=RequestMethod.GET)
	public String updatetodo(@RequestParam int id, ModelMap map) {
		Todo todo=service.retrivetodo(id);
		map.addAttribute("todo", todo);
		return "addtodo";
	
			}
	@RequestMapping(value="/updatetodo",method=RequestMethod.POST)
	public String updateupdatetodo(@Valid Todo todo,BindingResult result ) {
		if (result.hasErrors()){
			return "addtodo";
		}
		service.updatetodo(todo);
		todo.setUser(retriveuser());
	return "redirect:listtodos";
}
	@RequestMapping(value="/ifanyerror", method=RequestMethod.GET)
	public String ifanyerror() {
		throw new	RuntimeErrorException( null);
//return "listtodos";		
	}
}
