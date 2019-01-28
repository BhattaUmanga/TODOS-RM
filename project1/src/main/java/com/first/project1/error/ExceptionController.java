package com.first.project1.error;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ControllerAdvice
@EnableWebMvc
public class ExceptionController {
	Log logger=LogFactory.getLog(Exception.class);
@ExceptionHandler(value=Exception.class)
public String exception(HttpServletRequest request, Exception exception) {
	logger.error("Request: " + request.getRequestURL() + " raised " + exception);
	return "error";
}

}