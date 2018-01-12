package com.proj.er;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.proj.er.model.UserDetails;
import com.proj.er.service.UserDetailsService;

@Controller
public class UserController {

	private UserDetailsService userDetailsService;

	@Autowired(required = true)
	@Qualifier(value = "userDetailsService")
	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@RequestMapping(value = "/userDetails", method = RequestMethod.GET)
	public String listUserDetails(Model model) {
		model.addAttribute("userDetails", new UserDetails());
		model.addAttribute("listUserDetails", this.userDetailsService.listUserDetails());
		return "userDetails";
	}

	// For add and update User Details both
	@RequestMapping(value = "/userDetails/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("userDetails") UserDetails user) {
		if (user.getUserId() == null) {
			// new User, add it
			this.userDetailsService.addUserDetails(user);
		} else {
			// existing User, call update
			this.userDetailsService.updateUserDetails(user);
		}
		return "redirect:/userDetails";
	}
	
	@RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") int id) {
        this.userDetailsService.removeUserDetails(id);
        return "redirect:/userDetails";
    }
	
	@RequestMapping("/edit/{id}")
    public String editUserDetails(@PathVariable("id") int id, Model model) {
        model.addAttribute("userDetails", this.userDetailsService.getUserDetailsById(id));
        model.addAttribute("listUserDetails", this.userDetailsService.listUserDetails());
        return "userDetails";
    }

}
