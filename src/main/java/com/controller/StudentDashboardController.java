package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bean.AddMarksBean;
import com.dao.AddMarksDao;

@Controller
public class StudentDashboardController {
	
	@Autowired 
	AddMarksDao addMarksDao;
	
	
	
	@GetMapping("/viewResult")
	public String viewResult(HttpSession session,Model model) {
		Integer enrollment = (Integer) session.getAttribute("enrollmentNumber");	
		List<AddMarksBean> result = addMarksDao.getResult(enrollment);
		model.addAttribute("result",result);
		return "ViewResult";
	}
	
}
