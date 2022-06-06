package com.rajeshanthari.excepption;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

	private Log log = LogFactory.getLog(ExceptionController.class);
	
	@ExceptionHandler(Exception.class)
	public String handleerror(HttpServletRequest request, Exception ex) {
		log.error(ex);
		return "error";
	}
}
