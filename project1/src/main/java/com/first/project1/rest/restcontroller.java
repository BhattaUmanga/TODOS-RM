package com.first.project1.rest;
 
import java.awt.List;

import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.first.project1.todo.Todo;
import com.first.project1.todo.TodoService;
@RestController
public class restcontroller {

	@Autowired
TodoService service;

	@RequestMapping(value = "/restlist", method = RequestMethod.GET)
public java.util.List<Todo> listAllTodos() {
	java.util.List<Todo> users = service.retrieveTodos("umanga");
	return users;
}

	@RequestMapping(value = "/restlist/{id}", method = RequestMethod.GET)
	public Todo selectedid(@PathVariable int id) {
		
		return service.retrivetodo(id);
	}
}
