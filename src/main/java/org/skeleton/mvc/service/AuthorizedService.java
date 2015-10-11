package org.skeleton.mvc.service;

import org.skeleton.mvc.repository.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value="/messages")
@RequestMapping(value="/messages")
public class AuthorizedService {
	
	final Logger logger = LoggerFactory.getLogger(AuthorizedService.class);
	
	@RequestMapping(value="/test")
	@ResponseBody
	public String test() {
		return "You get the authorized resources";
	}

	// ------------------------
	// PRIVATE FIELDS
	// ------------------------

	@Autowired
	private UserDao userDao;

} // class UserController