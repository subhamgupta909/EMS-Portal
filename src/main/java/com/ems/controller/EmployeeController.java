package com.ems.controller;

import java.net.Authenticator;
import java.text.SimpleDateFormat;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ems.entity.Project;
import com.ems.entity.User;
import com.ems.service.ProjectService;
import com.ems.service.UserService;

@Controller
public class EmployeeController {
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

	@GetMapping("/employee")
	public String viewEmployeeDashboard() {

		return "employee_dashboard";
	}

	@GetMapping("/employee/details")
	public String viewEmployeeDetails(Authentication authentication, Model model) {
		String email=authentication.getName();
		System.out.println(email);
		if (email != null) {
			User employee = userService.findUserByEmail(email);
			model.addAttribute("employee", employee);
			model.addAttribute("view", "details");

		}
		return "employee_dashboard";
	}

	@GetMapping("/employee/project")
	public String viewEmployeeProject(Authentication authentication, Model model) {
		String email=authentication.getName();
		System.out.println(email);
		if (email == null) {
			return "redirect:/login";
		}

		if (email != null) {
			User employee = userService.findUserByEmail(email);
            System.out.println(employee);
			model.addAttribute("employee", employee);
			Project project = projectService.getProjectByEmployeeId(employee.getUserId());
			//System.out.println(project);
			model.addAttribute("project", project);
			model.addAttribute("view", "project");

		}

		return "employee_dashboard";
	}
	
//	@GetMapping("/employee/logout")
//    public String logout(HttpSession session,Model model) {
//        session.invalidate();
//        model.addAttribute("successMsg", "Logout successful!");
//        return "login";
//    }

}
