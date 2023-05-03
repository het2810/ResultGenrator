package com.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.AddMarksBean;
import com.bean.UserBean;
import com.mysql.cj.Session;

@Repository
public class AddMarksDao {
	@Autowired
	JdbcTemplate stmt;

	public void addMarks(AddMarksBean add, Integer enrollmentNumber, Integer facultyEnrollment) {
	    System.out.println("----" + enrollmentNumber);
	    System.out.println(facultyEnrollment);
	    String firstName = stmt.queryForObject("SELECT FIRSTNAME FROM USERS WHERE ENROLLMENT_NUMBER = ?", String.class,
	            new Object[] { enrollmentNumber });
	    String subject = stmt.queryForObject("SELECT subjectRoleId FROM USERS WHERE ENROLLMENT_NUMBER = ?",
	            String.class, new Object[] { facultyEnrollment });
	    // check if student is already exist in the table or not
	    String selectStudentQuery = "SELECT Enrollment_Number FROM RESULT WHERE Enrollment_Number=?";
	    List<String> studentExist = stmt.queryForList(selectStudentQuery, String.class, enrollmentNumber);
	  
	    System.out.println(studentExist);
	    if (!studentExist.isEmpty()) {
	        
	    	// Update marks
	    	if (subject.equals("C")) {
	            String updateCMarks = "UPDATE RESULT SET INTERNAL_C=?, EXTERNAL_C=?, PRACTICAL_C=?, TOTAL_C=? WHERE ENROLLMENT_NUMBER=?";
	            stmt.update(updateCMarks, add.getInternal_C(), add.getExternal_C(), add.getPractical_C(),
	                    (add.getPractical_C() + add.getExternal_C() + add.getInternal_C()), enrollmentNumber);
	        } else if (subject.equals("JAVA")) {
	            String updateJavaMarks = "UPDATE RESULT SET INTERNAL_JAVA=?, EXTERNAL_JAVA=?, PRACTICAL_JAVA=?, TOTAL_JAVA=? WHERE ENROLLMENT_NUMBER=?";
	            stmt.update(updateJavaMarks, add.getInternal_Java(), add.getExternal_Java(), add.getPractical_Java(),
	                    (add.getPractical_Java() + add.getExternal_Java() + add.getInternal_Java()), enrollmentNumber);
	        } else if (subject.equals("PYTHON")) {
	            String updatePythonMarks = "UPDATE RESULT SET INTERNAL_PYTHON=?, EXTERNAL_PYTHON=?, PRACTICAL_PYTHON=?, TOTAL_PYTHON=? WHERE ENROLLMENT_NUMBER=?";
	            stmt.update(updatePythonMarks, add.getInternal_Python(), add.getExternal_Python(), add.getPractical_Python(),
	                    (add.getPractical_Python() + add.getExternal_Python() + add.getInternal_Python()), enrollmentNumber);
	        } else if (subject.equals("MATHS")) {
	            String updateMathsMarks = "UPDATE RESULT SET INTERNAL_MATHS=?, EXTERNAL_MATHS=?, TOTAL_MATHS=? WHERE ENROLLMENT_NUMBER=?";
	            stmt.update(updateMathsMarks, add.getInternal_Maths(), add.getExternal_Maths(),
	                    (add.getExternal_Maths() + add.getInternal_Maths()), enrollmentNumber);
	        }
	        
	    } else {
	    	
	    	// Insert marks
	    	if (subject.equals("C")) {
	            String insertCMarks = "INSERT INTO RESULT (ENROLLMENT_NUMBER,FIRSTNAME,INTERNAL_C,EXTERNAL_C,PRACTICAL_C,total_C) VALUES (?,?,?,?,?,?)";
	            stmt.update(insertCMarks, enrollmentNumber, firstName, add.getInternal_C(),
	                    add.getExternal_C(), add.getPractical_C(),
	                    (add.getPractical_C() + add.getExternal_C() + add.getInternal_C()));
	        } else if (subject.equals("JAVA")) {
	            String insertJavaMarks = "INSERT INTO RESULT (ENROLLMENT_NUMBER,FIRSTNAME,INTERNAL_JAVA,EXTERNAL_JAVA,PRACTICAL_JAVA,total_JAVA) VALUES (?,?,?,?,?,?)";
	            stmt.update(insertJavaMarks, enrollmentNumber, firstName, add.getInternal_Java(),
	                    add.getExternal_Java(), add.getPractical_Java(),
	                    (add.getPractical_Java() + add.getExternal_Java() + add.getInternal_Java()));

	        } else if (subject.equals("PYTHON")) {
	        	String insertPythonMarks = "INSERT INTO RESULT (ENROLLMENT_NUMBER,FIRSTNAME,INTERNAL_PYTHON,EXTERNAL_PYTHON,PRACTICAL_PYTHON,total_PYTHON) VALUES (?,?,?,?,?,?)";
				stmt.update(insertPythonMarks, enrollmentNumber, firstName, add.getInternal_Python(),
						add.getExternal_Python(), add.getPractical_Python(),
						(add.getPractical_Python() + add.getExternal_Python() + add.getInternal_Python()));
			}
	     // add marks for Maths
	     	else if (subject.equals("MATHS")) {
	   			String insertMathsMarks = "INSERT INTO RESULT (ENROLLMENT_NUMBER,FIRSTNAME,INTERNAL_MATHS,EXTERNAL_JAVA,total_MATHS) VALUES (?,?,?,?,?)";
	   			stmt.update(insertMathsMarks, enrollmentNumber, firstName, add.getInternal_Maths(),
	     		add.getExternal_Maths(), (add.getExternal_Maths() + add.getInternal_Maths()));
	     	}
	    	
	    	
	        
	   }
	}


	public String getSubjectFromEnrollment(Integer facultyEnrollment) {
		String subject = stmt.queryForObject("SELECT subjectRoleId FROM USERS WHERE ENROLLMENT_NUMBER = ?",
				String.class, new Object[] { facultyEnrollment });
		System.out.println(subject);
		return subject;
	}
}
