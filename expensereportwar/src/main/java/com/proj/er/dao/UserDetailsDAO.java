package com.proj.er.dao;

import java.util.List;

import com.proj.er.model.UserDetails;

public interface UserDetailsDAO {
	
	public UserDetails addUserDetails(UserDetails user);
    public void updateUserDetails(UserDetails user);
    public List<UserDetails> listUserDetails();
    public UserDetails getUserDetailsById(int id);
    public void removeUserDetails(int id);

}
