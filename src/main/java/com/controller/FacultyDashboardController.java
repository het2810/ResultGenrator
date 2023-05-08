package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.AddMarksBean;
import com.bean.UserBean;
import com.dao.AddMarksDao;
import com.dao.UserDao;

@Controller
public class FacultyDashboardController {

	@Autowired
	UserDao userDao;
	
	@Autowired
	JdbcTemplate stmt;

	@Autowired
	AddMarksDao addMarksDao;

	@Autowired
	UserBean users;

	@RequestMapping(value = "/addMarks", method = { RequestMethod.GET })
	public String addMarksView(@ModelAttribute("AddMarksBean") AddMarksBean add,
			@RequestParam("enrollmentNumber") Integer Enrollment_Number, HttpSession session,Model model) {
		Integer enrollment = (Integer) session.getAttribute("enrollmentNumber");
		System.out.println(enrollment);
		String subject = addMarksDao.getSubjectFromEnrollment(enrollment);
		System.out.println(subject);
		model.addAttribute("subject", subject);
		return "AddMarks";
	}

	@RequestMapping(value = "/addMarks", method = { RequestMethod.POST })
	public String addMarks(@ModelAttribute("AddMarksBean") AddMarksBean add, HttpSession session, Model model) {
		Integer enrollment = (Integer) session.getAttribute("enrollmentNumber");
		System.out.println(enrollment);
		addMarksDao.addMarks(add, add.getEnrollmentNumber(), enrollment);
		System.out.println("addMarks");
		return "redirect:/listStudentForMarks";
	}
	
	@RequestMapping(value = "/updateMarks", method = { RequestMethod.GET })
	public String updateMarks(@ModelAttribute("AddMarksBean") AddMarksBean add,
			@RequestParam("enrollmentNumber") Integer Enrollment_Number, HttpSession session,Model model) {
		Integer enrollment = (Integer) session.getAttribute("enrollmentNumber");
		System.out.println(enrollment);
		String subject = addMarksDao.getSubjectFromEnrollment(enrollment);
		System.out.println(subject);
		model.addAttribute("subject", subject);
		return "AddMarks";
	}

	
	@GetMapping("/listStudentForMarks")
	public String addMarks(Model md) {
		List<AddMarksBean> users = userDao.getStudentResult();
		md.addAttribute("users", users);
		return "ListStudentForMarks";
	}
	
	
	
}
