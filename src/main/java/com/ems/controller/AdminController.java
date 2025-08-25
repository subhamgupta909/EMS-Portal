package com.ems.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
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

import com.ems.entity.ContactPerson;
import com.ems.entity.Project;
import com.ems.entity.Role;
import com.ems.entity.User;
import com.ems.service.ContactPersonService;
import com.ems.service.ProjectService;
import com.ems.service.UserService;
import com.ems.serviceImpl.NotificationProducer;

@Controller
public class AdminController {

	@Autowired
	UserService userService;
	@Autowired
	ProjectService projectService;
	
	@Autowired
	ContactPersonService  contactPersonService;
	@Autowired
	NotificationProducer notificationProducer;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
	}

//	@GetMapping("/dashboard")
//	public String showAdminDashboard() {
//		return "admin_dashboard";
//
//	}

	@GetMapping("/admin")
	public String viewAdminDashboard() {

		return "admin_dashboard";
	}

	@GetMapping("/admin/employee_module")
	public String getEmployeeModule() {

		return "employee_module";
	}

	@GetMapping("/admin/employee/add")
	public String addEmployeeForm(Model model) {
		model.addAttribute("employee", new User());
		System.out.println("addemployeeform");
		return "add_employee";
	}

	@PostMapping("/admin/employee/save")
	public String saveEmployee(@ModelAttribute("employee") User user, RedirectAttributes redirectAttributes) {
		// System.out.println("save");
		try {
			user.setRole(Role.ROLE_EMPLOYEE);
			userService.addUser(user);
			redirectAttributes.addFlashAttribute("successMessage", "Employee added successfully!");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("errorMessage", "Failed to add employee: " + e.getMessage());
		}

		return "redirect:/admin/employee_list";

	}

	@GetMapping("/admin/employee_list")
	public String findAllEmployees(Model model) {
		List<User> empList = userService.findAllUsers(Role.ROLE_EMPLOYEE);
		model.addAttribute("empList", empList);
		return "employee_list";
	}

	@GetMapping("/admin/employee/edit")
	public String showEditForm(@RequestParam("userId") String userId, Model model) {
		User user = userService.findUserById(userId);
		System.out.println(user.getUserId());
		model.addAttribute("employee", user);
		return "update_employee";

	}

	@PostMapping("/admin/employee/update")
	public String updateEmployee(@ModelAttribute("employee") User user, RedirectAttributes redirectAttributes) {
		user.setRole(Role.ROLE_EMPLOYEE);
		userService.updateUser(user);
		redirectAttributes.addFlashAttribute("successMessage", "Employee Updated Sucessfully");
		return "redirect:/admin/employee_list";

	}

	@GetMapping("/admin/employee/delete")
	public String deleteEmployee(@RequestParam("userId") String userId, RedirectAttributes redirectAttributes) {
		userService.deleteUserById(userId);
		redirectAttributes.addFlashAttribute("successMessage", "Employee Deleted Sucessfully");
		return "redirect:/admin/employee_list";

	}

	@GetMapping("/admin/employee/bench")
	public String findAllBenchEmployees(Model model) {
		List<User> empList = userService.findAllUsers(Role.ROLE_EMPLOYEE);
		List<User> empBenchList = new ArrayList<User>();
		for (User u : empList) {
			if (u.getProject() == null) {
				empBenchList.add(u);
			}
		}
		model.addAttribute("empBenchList", empBenchList);
		return "employeebench_list";
	}

	@GetMapping("/admin/employee/assign-project")
	public String showAssignProjectForm(Model model) {
		List<User> empList = userService.findAllUsers(Role.ROLE_EMPLOYEE);
		List<User> empBenchList = new ArrayList<User>();
		List<Project> projectList = projectService.getAllProjects();
		for (User u : empList) {
			if (u.getProject() == null) {
				empBenchList.add(u);
			}
		}
		model.addAttribute("empBenchList", empBenchList);
		model.addAttribute("projectList", projectList);
		return "assign_project";

	}

	@PostMapping("/admin/employee/assignproject")
	public String assignProjectToEmployee(@RequestParam("userId") String userId,
			@RequestParam("projectId") String projectId, Model model, RedirectAttributes redirectAttributes) {
		try {
			User emp = userService.findUserById(userId);
			Project project = projectService.getProjectById(projectId);
			emp.setProject(project);
			userService.updateUser(emp);
			notificationProducer.sendProjectAssignedTopic(emp, project);
			redirectAttributes.addFlashAttribute("successMessage", "Project assigned successfully!");

		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("errorMessage", "Failed to assign project: " + e.getMessage());

		}
		return "redirect:/admin/employee/assign-project";
	}

	@GetMapping("/admin/employee/release")
	public String showEmployeeProjectToRelease(Model model) {
		List<User> empList = userService.findAllUsers(Role.ROLE_EMPLOYEE);
		List<User> empProjectList = new ArrayList<User>();
		for (User u : empList) {
			if (u.getProject() != null) {
				empProjectList.add(u);
			}
		}
		model.addAttribute("empProjectList", empProjectList);
		return "release_list";

	}

	@PostMapping("/admin/employee/release-project")
	public String releaseEmployeeFromProject(@RequestParam("userId") String userId,
			@RequestParam("projectId") String projectId, RedirectAttributes redirectAttributes) {
		try {
			User emp = userService.findUserById(userId);
			if (emp != null && emp.getProject() != null && emp.getProject().getProjectId().equals(projectId)) {
				emp.setProject(null);
				userService.updateUser(emp);
				redirectAttributes.addFlashAttribute("successMessage", "Employee released successfully!");
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("errorMessage", "Failed to release employee: " + e.getMessage());
		}
		return "redirect:/admin/employee/release";
	}

	@GetMapping("/admin/search")
	public String searchEmployee(Model model) {
		return "searchEmployee_form";
	}

	@GetMapping("/admin/employee/search")
	public String searchEmployees(@RequestParam String criteria,
			@RequestParam(value = "empId", required = false) String empId,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "startDate", required = false, defaultValue = "") @DateTimeFormat(pattern = "yyyy-MM-dd") String startDateStr,
			@RequestParam(value = "endDate", required = false, defaultValue = "") @DateTimeFormat(pattern = "yyyy-MM-dd") String endDateStr,
			Model model) {
		List<User> empList = new ArrayList<>();

		switch (criteria) {
		case "empId":
			if (empId != null && !empId.isEmpty()) {
				User user = userService.findUserById(empId);
				if (user != null)
					empList.add(user);
			}
			break;

		case "email":
			if (email != null && !email.isEmpty()) {
				User user = userService.findUserByEmail(email);
				if (user != null)
					empList.add(user);
			}
			break;

		case "date":
			if (startDateStr != null && !startDateStr.isEmpty() && endDateStr != null && !endDateStr.isEmpty()) {
				try {
					Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDateStr);
					Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDateStr);
					empList = userService.findAllUsersByJoiningDateRange(startDate, endDate);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			break;
		}

		model.addAttribute("empList", empList);
		return "employee_list";
	}

	@RequestMapping("/admin/client_module")
	public String showDashboard() {
		return "client_module";
	}

	@GetMapping("/admin/client/add")
	public String addClientForm(Model model) {
		model.addAttribute("client", new User());
		System.out.println("addclientform");
		return "add_client";
	}

	@PostMapping("/admin/client/save")
	public String saveClient(@ModelAttribute("client") User user, RedirectAttributes redirectAttributes) {
		// System.out.println("save");
		try {
			user.setRole(Role.ROLE_CLIENT);
			userService.addUser(user);
			redirectAttributes.addFlashAttribute("successMessage", "Client added successfully!");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("errorMessage", "Failed to add client: " + e.getMessage());
		}

		return "redirect:/admin/client_list";

	}

	@GetMapping("/admin/client_list")
	public String findAllClients(Model model) {
		List<User> clientList = userService.findAllUsers(Role.ROLE_CLIENT);
		model.addAttribute("clientList", clientList);
		return "client_list";
	}

	@GetMapping("/admin/client/edit")
	public String showClientEditForm(@RequestParam("userId") String userId, Model model) {
		User user = userService.findUserById(userId);
		System.out.println(user.getUserId());
		model.addAttribute("client", user);
		return "update_client";

	}

	@PostMapping("/admin/client/update")
	public String updateClient(@ModelAttribute("client") User user, RedirectAttributes redirectAttributes) {
		user.setRole(Role.ROLE_CLIENT);
		userService.updateUser(user);
		redirectAttributes.addFlashAttribute("successMessage", "Client Updated Sucessfully");
		return "redirect:/admin/client_list";

	}

	@GetMapping("/admin/client/delete")
	public String deleteClient(@RequestParam("userId") String userId, RedirectAttributes redirectAttributes) {
		userService.deleteUserById(userId);
		redirectAttributes.addFlashAttribute("successMessage", "Client Deleted Sucessfully");
		return "redirect:/admin/client_list";

	}

	@GetMapping("/admin/client/search")
	public String searchClient(Model model) {
		return "searchClient_form";
	}

	@GetMapping("/admin/client/search-id")
	public String searchClientById(@RequestParam("userId") String userId, Model model,
			RedirectAttributes redirectAttributes) {
		List<User> clientList = new ArrayList<User>();
		try {
			User client = userService.findUserById(userId);
			if (client != null) {
				clientList.add(client);
				model.addAttribute("clientList", clientList);
				redirectAttributes.addFlashAttribute("successMessage", "Client Fetch Sucessfully");
			} else {
				model.addAttribute("errorMessage", "Client not found with ID: " + userId);
				return "client_list";

			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("errorMessage", "Client Not Found: " + e.getMessage());

		}
		return "client_list";
	}

	@GetMapping("/admin/client/searchProjects")
	public String searchClientProjects(@RequestParam("clientId") String clientId, Model model) {
		User client = userService.findUserById(clientId);
		if (client == null) {
			model.addAttribute("errorMessage", "Client not found with ID: " + clientId);
			return "searchClient_form";
		}

		List<Project> projectList = projectService.getAllProjectsByClientId(clientId);

		model.addAttribute("client", client);
		model.addAttribute("projectList", projectList);
		return "client_projects";
	}

	@RequestMapping("/admin/project_module")
	public String showProjectModule() {
		return "project_module";
	}

	@GetMapping("/admin/project/search")
	public String searchProject(Model model) {
		return "searchProject_form";
	}
    @GetMapping("/admin/project/search-id")
    public String searchProject(
            @RequestParam("projectId") String projectId,
            @RequestParam("action") String action,
            Model model) {

        Project project = projectService.getProjectById(projectId);

        if (project == null) {
            model.addAttribute("errorMessage", "Project not found with ID: " + projectId);
            return "searchProject_form";
        }

        model.addAttribute("projectId", projectId);

        switch (action) {
            case "viewProject":
                model.addAttribute("project", project);
                break;

            case "viewClient":
                User client = userService.findUserById(project.getClient().getUserId());
                model.addAttribute("client", client);
                break;

            case "viewEmployees":
                List<User> employees = userService.findAllEmployeesByProjectId(projectId);
                model.addAttribute("employeeList", employees);
                break;

            default:
                model.addAttribute("errorMessage", "Invalid action.");
                break;
        }

        return "searchProject_form";  
    }

	@GetMapping("/admin/project/add")
	public String addProjectForm(Model model) {
		List<User> clientList = userService.findAllUsers(Role.ROLE_CLIENT);
		model.addAttribute("client", new Project());
		model.addAttribute("clientList", clientList);
		System.out.println("addprojectform");
		return "add_project";
	}

	@PostMapping("/admin/project/save")
	public String saveProject(@ModelAttribute("project") Project project, @RequestParam("userId") String userId,
			RedirectAttributes redirectAttributes) {
		System.out.println("saveproject");
		try {
			User client = userService.findUserById(userId);
			project.setClient(client);
			projectService.addProject(project);
			redirectAttributes.addFlashAttribute("successMessage", "Project added successfully!");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("errorMessage", "Failed to add project: " + e.getMessage());
		}

		return "redirect:/admin/project_list";

	}

	@GetMapping("/admin/project_list")
	public String findAllProjects(Model model) {
		List<Project> projectList = projectService.getAllProjects();
		model.addAttribute("projectList", projectList);
		return "project_list";
	}

	@GetMapping("/admin/project/edit")
	public String showProjectEditForm(@RequestParam("projectId") String projectId, Model model) {
		Project project = projectService.getProjectById(projectId);
		System.out.println(project.getProjectId());
		model.addAttribute("project", project);
		return "update_project";

	}

	@PostMapping("/admin/project/update")
	public String updateProject(@ModelAttribute("project") Project project, RedirectAttributes redirectAttributes) {
		projectService.updateProject(project);
		redirectAttributes.addFlashAttribute("successMessage", "Project Updated Sucessfully");
		return "redirect:/admin/project_list";

	}

	@GetMapping("/admin/project/delete")
	public String deleteProject(@RequestParam("projectId") String projectId, RedirectAttributes redirectAttributes) {
		projectService.deleteProjectById(projectId);
		redirectAttributes.addFlashAttribute("successMessage", "Project Deleted Sucessfully");
		return "redirect:/admin/project_list";

	}
	@RequestMapping("/admin/contact_module")
	public String showContactModule() {
		return "contact_module";
	}

	@RequestMapping("/admin/contactperson/add")
	public String showContactPersonForm(Model model) {
		model.addAttribute("contactPerson", new ContactPerson());
		return "add_contact";
	}
	
	@PostMapping("/admin/contact-person/save")
	public String saveClient(@ModelAttribute("contactPerson") ContactPerson contactPerson, RedirectAttributes redirectAttributes) {
		// System.out.println("save");
		try {
			
			contactPersonService.addContactPerson(contactPerson);
			redirectAttributes.addFlashAttribute("successMessage", "Contact added successfully!");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("errorMessage", "Failed to add contact: " + e.getMessage());
		}

		return "redirect:/admin/contactPerson_list";

	}
	
	@GetMapping("/admin/contactPerson_list")
	public String findAllContacts(Model model) {
		List<ContactPerson> contactPersonList = contactPersonService.getAllContactPersons();
		model.addAttribute("contactPersonList", contactPersonList);
		return "contactPerson_list";
	}

	@GetMapping("/admin/contact/edit")
	public String showContactEditForm(@RequestParam("id") Integer id, Model model) {
		ContactPerson cp = contactPersonService.findContactPersonById(id);
		model.addAttribute("cp", cp);
		return "update_contact";

	}

	@PostMapping("/admin/contact/update")
	public String updateContact(@ModelAttribute("contactPerson") ContactPerson contactPerson, RedirectAttributes redirectAttributes) {
		contactPersonService.updateContactPerson(contactPerson);
		redirectAttributes.addFlashAttribute("successMessage", "Contact Updated Sucessfully");
		return "redirect:/admin/contactPerson_list";

	}

	@GetMapping("/admin/contact/delete")
	public String deleteContact(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes) {
        contactPersonService.deleteContactPerson(id);
		redirectAttributes.addFlashAttribute("successMessage", "Contact Deleted Sucessfully");
		return "redirect:/admin/contactPerson_list";

	}

	@GetMapping("/admin/contact-person/view")
	public String viewContact( RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("successMessage", "Contact Fetched Sucessfully");
		return "redirect:/admin/contactPerson_list";

	}
	@GetMapping("/admin/assign/contact")
	public String showContactForm( Model model,RedirectAttributes redirectAttributes) {
		List<User>  clientList=userService.findAllUsers(Role.ROLE_CLIENT);
		List<ContactPerson> contactPersonsList=contactPersonService.getAllContactPersons();
		model.addAttribute("clientList", clientList);
		model.addAttribute("contactPersonsList", contactPersonsList);
		return "assignContact_form";

	}
	
	@PostMapping("/admin/assign/save")
	public String assignContactPersonToClient(
	        @RequestParam("userId") String userId,
	        @RequestParam("id") Integer id,
	        RedirectAttributes redirectAttributes) {

	    try {
	        User client = userService.findUserById(userId);
	        ContactPerson contactPerson = contactPersonService.findContactPersonById(id);

	        if (client != null && contactPerson != null) {
	            contactPerson.setClient(client);

	            contactPersonService.updateContactPerson(contactPerson);

	            redirectAttributes.addFlashAttribute("success", " Contact Person assigned successfully!");
	        } else {
	            redirectAttributes.addFlashAttribute("error", " Invalid Client or Contact Person!");
	        }

	    } catch (Exception e) {
	        redirectAttributes.addFlashAttribute("error", " Something went wrong: " + e.getMessage());
	    }

	    return "redirect:/admin/assign/contact";  
	}

	@GetMapping("/admin/view/assign")
	public String viewAssignedContact(Model model) {
		
		return "view_contact";
	}
	
	@GetMapping("/admin/view/contact")
	public String viewClientContacts(@RequestParam("userId") String userId, Model model) {
	    List<ContactPerson> list = contactPersonService.findContactPersonsByClientId(userId);
	    model.addAttribute("contactPersons", list);
	    return "view_contact";
	}

//	@GetMapping("/admin/logout")
//    public String logout(HttpSession session,Model model) {
//        session.invalidate();
//        model.addAttribute("successMsg", "Logout successful!");
//        return "login";
//    }


	

}
