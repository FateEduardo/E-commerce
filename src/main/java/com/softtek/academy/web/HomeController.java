package com.softtek.academy.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public String adminHome() {
		return "adminHome";
	}
	@RequestMapping(value = "/redirect", method = RequestMethod.GET)
	public String redirect() {
		logger.info("si entro");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		final String role=auth.getAuthorities().toString();
		logger.info(role);
		System.err.println(role);
		if(role.equals("admin")){
			return "redirect:/admin/home";
					
		}
		return "redirect:/admin/home";
	}
	@SuppressWarnings("null")
	@RequestMapping(value = "/userName", method = RequestMethod.GET)
	public ResponseEntity<?>  logName() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null){
			final String role=auth.getName();
			if(role==null &&role.isEmpty()){
				return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<String>(role, HttpStatus.OK);
		}
		return  new ResponseEntity<String>("", HttpStatus.OK);
		
	}
}