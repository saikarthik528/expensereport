package com.proj.er.service;

import java.util.List;

import com.proj.er.model.UserDetails;

public interface UserDetailsService {

	public void addUserDetails(UserDetails user);
    public void updateUserDetails(UserDetails user);
    public List<UserDetails> listUserDetails();
    public UserDetails getUserDetailsById(int id);
    public void removeUserDetails(int id);
	
}
