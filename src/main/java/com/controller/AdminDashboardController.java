package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.AddMarksBean;
import com.bean.UserBean;
import com.dao.AddMarksDao;
import com.dao.UserDao;
import com.util.EnrollmentAlreadyExistsException;

@Controller
public class AdminDashboardController {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	AddMarksDao addMarksDao;
	
	@GetMapping("/addStudent")
	public String addStudent() {
		return "AddStudent";
	}


	@GetMapping("/addFaculty")
	public String addFaculty() {
		return "AddFaculty";
	}

	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("enrollmentNumber") Integer Enrollment_Number) {
		userDao.deleteStudent(Enrollment_Number);
		addMarksDao.deleteStudent(Enrollment_Number);
		return "redirect:/listStudents";
	}

	@GetMapping("/deleteFaculty")
	public String deleteFaculty(@RequestParam("enrollmentNumber") Integer Enrollment_Number) {
		userDao.deleteFaculty(Enrollment_Number);
		return "redirect:/listFaculties";
	}
	
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("userBean") UserBean userBean, ModelMap model) {
		try {
			userDao.insertStudent(userBean);
			return "Dashboard";
		} catch (EnrollmentAlreadyExistsException e) {
			model.addAttribute("errorMessage", e.getMessage());
			return "AddStudent";
		}
	}

	@RequestMapping(value = "/addFaculty", method = RequestMethod.POST)
	public String addFaculty(@ModelAttribute("userBean") UserBean userBean, ModelMap model) {
		try {
			userDao.insertFaculty(userBean);
			return "Dashboard";
		} catch (EnrollmentAlreadyExistsException e) {
			model.addAttribute("errorMessage", e.getMessage());
			return "AddFaculty";
		}

	}
	
	@GetMapping("/viewMarks")
	public String viewMarks(@RequestParam("enrollmentNumber") Integer Enrollment_Number,Model model) {
		System.out.println("viewMarks called............");
		List<AddMarksBean> studentMarks = addMarksDao.getMarks(Enrollment_Number);
		model.addAttribute("student",studentMarks);
		return "viewMarks";
	}
	
	@GetMapping("/listStudents")
	public String listStudents(Model md) {
		List<UserBean> users = userDao.getStudents();
		md.addAttribute("users", users);
		return "ListStudents";
	}


	@GetMapping("/listFaculties")
	public String listFaculties(Model md) {
		List<UserBean> users = userDao.getFaculties();
		md.addAttribute("users", users);
		return "ListFaculties";
	}
	
	@GetMapping("/generateResult")
	public String generateResult(Model md) {
		List<AddMarksBean> studentForResult = addMarksDao.getStudentsForResult();
		md.addAttribute("students",studentForResult);
		addMarksDao.updateResultStatus();
		return "GenerateResult";
	}
	
	
}
