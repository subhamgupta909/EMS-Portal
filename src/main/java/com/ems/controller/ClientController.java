package com.ems.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ems.entity.Project;
import com.ems.entity.User;
import com.ems.service.ProjectService;
import com.ems.service.UserService;

@Controller
public class ClientController {

	@Autowired
	UserService userService;
	@Autowired
	ProjectService projectService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
	}

	@GetMapping("/client")
	public String viewClientDashboard() {

		return "client_dashboard";
	}

	@GetMapping("/client/details")
	public String viewClientDetails(Authentication authentication, Model model) {
		String email = authentication.getName();
		if (email != null) {
			User client = userService.findUserByEmail(email);
			model.addAttribute("clientDetails", client);

		}
		return "client_details";
	}

	@GetMapping("/client/projects")
	public String viewClientProjects(Authentication authentication, Model model) {
		String email = authentication.getName();

		if (email != null) {
			User user = userService.findUserByEmail(email);
			List<Project> projects = projectService.getAllProjectsByClientId(user.getUserId());
			model.addAttribute("projects", projects);
		}
		return "clientDashboard_projects";
	}

	@GetMapping("/client/employees")
	public String viewClientEmployees(Authentication authentication, Model model) {
		String email = authentication.getName();

		if (email != null) {
			User user = userService.findUserByEmail(email);

			List<Project> projects = projectService.getAllProjectsByClientId(user.getUserId());
			model.addAttribute("projects", projects);
		}
		return "client_employees";
	}

//	@GetMapping("/client/logout")
//	public String logout(HttpSession session, Model model) {
//		session.invalidate();
//		model.addAttribute("successMsg", "Logout successful!");
//		return "login";
//	}

}
