//package com.ems.controller;
//
//import java.sql.SQLException;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.ems.entity.Role;
//import com.ems.entity.User;
//import com.ems.service.UserService;
//
//@Controller
//public class RoleRedirectController {
//     @Autowired
//	UserService  userService;
//
//     @Autowired
//     PasswordEncoder passwordEncoder;
//     
//	@PostMapping("/login")
//	public String login(@RequestParam String email,
//	                    @RequestParam String password,
//	                    HttpSession session,
//	                    Model model) throws SQLException {
//		System.out.println(email);
//		System.out.println(password);
//	    User user = userService.login(email, password);
//	    System.out.println(user);
//	    if(user == null) {
//	        model.addAttribute("error", "Invalid Email or Password");
//	        return "login";
//	    }
//
//	    session.setAttribute("loggedInUser", user);
//
//	    if(user.getRole().equals(Role.ROLE_ADMIN) && passwordEncoder.matches(password, user.getPassword())) {
//	        return "redirect:/admin";
//	    } else if(user.getRole().equals(Role.ROLE_EMPLOYEE) && passwordEncoder.matches(password, user.getPassword())) {
//	        return "redirect:/employee";
//	    } else if(user.getRole().equals(Role.ROLE_CLIENT) && passwordEncoder.matches(password, user.getPassword())) {
//	        return "redirect:/client";
//	    } else {
//	        model.addAttribute("error", "Role not recognized");
//	        return "login";
//	    }
//	}
//
//	
//	
//}
