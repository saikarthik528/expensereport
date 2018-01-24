package com.proj.er.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proj.er.dao.UserDetailsDAO;
import com.proj.er.model.UserDetails;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserDetailsDAO userDetailsDAO;
	
	public void setUserDetailsDAO(UserDetailsDAO userDetailsDAO) {
		this.userDetailsDAO = userDetailsDAO;
	}

	@Transactional
	public UserDetails addUserDetails(UserDetails user) {
		return this.userDetailsDAO.addUserDetails(user);
	}

	@Transactional
	public void updateUserDetails(UserDetails user) {
		this.userDetailsDAO.updateUserDetails(user);
	}

	@Transactional
	public List<UserDetails> listUserDetails() {
		return this.userDetailsDAO.listUserDetails();
	}

	@Transactional
	public UserDetails getUserDetailsById(int id) {
		return this.userDetailsDAO.getUserDetailsById(id);
	}

	@Transactional
	public void removeUserDetails(int id) {
		this.userDetailsDAO.removeUserDetails(id);
	}

}
