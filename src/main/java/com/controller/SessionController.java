package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bean.UserBean;
import com.constants.Role;
import com.dao.AddMarksDao;
import com.dao.UserDao;

import java.util.List;

import javax.servlet.http.HttpSession;
import com.util.*;

@Controller
public class SessionController {

	@Autowired
	UserDao userDao;

	@GetMapping("/")
	public String onStart() {
		return "Login";
	}

	@GetMapping("/login")
	public String login() {
		return "Login";
	}

	@GetMapping("/loginAsStudentOrFaculty")
	public String loginAsStudentOrFaculty() {
		return "LoginAsStudentOrFaculty";
	}

	@GetMapping("/studentDashboard")
	public String studentDashboard(HttpSession session, Model model) {
		// Check if the user is logged in by checking the session attribute
		Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
		if (loggedIn == null) {
			// User is not logged in - redirect to the login page
			return "LoginAsStudentOrFaculty";
		}

		// User is logged in - add a message to the model
		model.addAttribute("message", "Welcome to the dashboard!");

		// Display the dashboard page
		return "StudentDashboard";
	}

	@GetMapping("/facultyDashboard")
	public String facultyDashboard(HttpSession session, Model model) {
		// Check if the user is logged in by checking the session attribute
		Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
		if (loggedIn == null) {
			// User is not logged in - redirect to the login page
			return "LoginAsStudentOrFaculty";
		}

		// User is logged in - add a message to the model
		model.addAttribute("message", "Welcome to the dashboard!");

		// Display the dashboard page
		return "FacultyDashboard";
	}

	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		// Check if the user is logged in by checking the session attribute
		Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
		if (loggedIn == null) {
			// User is not logged in - redirect to the login page
			return "login";
		}

		// User is logged in - add a message to the model
		// Display the dashboard page
		return "Dashboard";
	}

	@PostMapping("/login")
	public String doLogin(@RequestParam String email, @RequestParam String password, HttpSession session,
			RedirectAttributes redirectAttributes, Model model) {
		// Check if the email and password match the admin account in the database
		if (email.equals("admin@gmail.com") && password.equals("admin")) {
			// Set a session attribute to mark the user as logged in
			session.setAttribute("loggedIn", true);
			model.addAttribute("message", "Welcome to the dashboard!");
			// Redirect to the dashboard
			return "Dashboard";
		} else {
			// Invalid login credentials - add an error message to the flash attributes
			redirectAttributes.addFlashAttribute("error", "Invalid email or password");

			// Redirect back to the login page
			return "Login";
		}
	}

	@PostMapping("/loginAsStudentOrFaculty")
	public String loginAsStudentOrFaculty(UserBean userBean, Model model, HttpSession session) {
		UserBean user = userDao.getUserByEmail(userBean.getEmail());
		if (user != null) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			if (passwordEncoder.matches(userBean.getPassword(), user.getPassword())) {
				// User credentials are valid, so redirect to the dashboard or home page
				session.setAttribute("currentUser", user);
				session.setAttribute("loggedIn", true);
				session.setAttribute("enrollmentNumber", user.getEnrollmentNumber());
				int role = user.getRole();
				if (role == Role.STUDENT.getValue()) {
					return "StudentDashboard";
				} else if (role == Role.FACULTY.getValue()) {
					return "FacultyDashboard";
				} else {
					// Handle invalid role
					model.addAttribute("error", "Invalid user role.");
					return "LoginAsStudentOrFaculty";
				}
			} else {
				// Password is invalid, so display an error message and ask the user to try
				// again
				model.addAttribute("error", "Invalid email or password.");
				return "LoginAsStudentOrFaculty";
			}
		} else {
			// User does not exist, so display an error message and ask the user to try
			// again
			model.addAttribute("error", "Invalid email or password.");
			return "LoginAsStudentOrFaculty";
		}
	}

}
