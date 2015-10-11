package org.skeleton.mvc.service;

import javax.validation.Valid;

import org.skeleton.core.validator.TestValidator;
import org.skeleton.mvc.entity.Users;
import org.skeleton.mvc.repository.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value="/users")
public class UserService {
	
	@Autowired
	TestValidator testValidator;
	
	final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	protected void initBinder(WebDataBinder binder) {
	    binder.setValidator(testValidator);
	}
	
	/**
	 * /create  --> Create a new user and save it in the database.
	 * 
	 * @param email User's email
	 * @param name User's name
	 * @return A string describing if the user is succesfully created or not.
	 */
	@RequestMapping(value="create", method = RequestMethod.POST, produces="application/json", consumes="application/json")
	@ResponseBody
	public String create(@Valid  @RequestBody Users user) {
		try {
			logger.info("create method runs ::  userId: {}, firstName : {}, lastName : {}, email : {}, password : {}", 
					user.getUserId(), user.getFirstSurname(), user.getSecondSurname(), user.getEmail(), user.getPassword());	
			userDao.save(user);
		}
		catch (Exception ex) {
			return "Error creating the user: " + ex.toString();
		}
		return "User succesfully created! (id = " + user.getEmail() + ")";
	}

	/**
	 * /delete  --> Delete the user having the passed id.
	 * 
	 * @param id The id of the user to delete
	 * @return A string describing if the user is succesfully deleted or not.
	 */
	@RequestMapping("delete")
	@ResponseBody
	public String delete(@RequestBody String email) {
		try {
			logger.info("delete method runs :: email: {}", email);
			Users user = new Users(email);
			userDao.delete(user);
		}
		catch (Exception ex) {
			return "Error deleting the user:" + ex.toString();
		}
		return "User succesfully deleted!";
	}


	/**
	 * /update  --> Update the email and the name for the user in the database 
	 * having the passed id.
	 * 
	 * @param id The id for the user to update.
	 * @param email The new email.
	 * @param name The new name.
	 * @return A string describing if the user is succesfully updated or not.
	 */
	@RequestMapping("update")
	@ResponseBody
	public String updateUser(@RequestBody Users user) {
		try {
			userDao.save(user);
		}
		catch (Exception ex) {
			return "Error updating the user: " + ex.toString();
		}
		return "User succesfully updated!";
	}

	// ------------------------
	// PRIVATE FIELDS
	// ------------------------

	@Autowired
	private UserDao userDao;

} // class UserController