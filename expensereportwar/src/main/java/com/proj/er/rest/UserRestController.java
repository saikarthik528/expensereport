package com.proj.er.rest;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.proj.er.model.UserDetails;
import com.proj.er.rest.entity.UserDetailsRestEntity;
import com.proj.er.service.UserDetailsService;

@Controller
public class UserRestController {

	private static final Logger logger = LoggerFactory.getLogger(UserRestController.class);

	private UserDetailsService userDetailsService;

	@Autowired(required = true)
	@Qualifier(value = "userDetailsService")
	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@RequestMapping(value = RestConstants.GET_USER, method = RequestMethod.GET)
	public @ResponseBody UserDetailsRestEntity getEmployee(@PathVariable("userId") int userId) {
		logger.info("User Details of ID = " + userId);
		return new UserDetailsRestEntity(this.userDetailsService.getUserDetailsById(userId));
	}
	
	@RequestMapping(value = RestConstants.CREATE_USER, method = RequestMethod.POST)
	public @ResponseBody UserDetailsRestEntity createUser(@RequestBody UserDetailsRestEntity userDetail) {
		logger.info("Start createUser.");
		UserDetails user = userDetail.convertToRoot();
		user.setCreatedOn(new Date());
		UserDetails persistedUser = userDetailsService.addUserDetails(user);
		return new UserDetailsRestEntity(persistedUser);
	}
	
	@RequestMapping(value = RestConstants.DELETE_USER, method = RequestMethod.DELETE)
	public @ResponseBody String deleteEmployee(@PathVariable("userId") int userId) {
		logger.info("Start deleteUser.");
		userDetailsService.removeUserDetails(userId);
		return "Delete Successful : " + userId;
	}
	
	@RequestMapping(value = RestConstants.UPDATE_USER, method = RequestMethod.PUT)
	public @ResponseBody UserDetailsRestEntity updateEmployee(@RequestBody UserDetailsRestEntity userDetail) {
		logger.info("Start updateUser.");
		UserDetails storedUser = userDetailsService.getUserDetailsById(userDetail.getUserId());
		storedUser.updateFields(userDetail.convertToRoot());
		userDetailsService.updateUserDetails(storedUser);
		return new UserDetailsRestEntity(userDetailsService.getUserDetailsById(storedUser.getUserId()));
	}
	
}
