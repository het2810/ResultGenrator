package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AddMarksDao {
	@Autowired
	JdbcTemplate stmt;
	 public void addMarks(Integer enrollmentNumber) {
		 //aage kaam baki hai ......
	 }
}
