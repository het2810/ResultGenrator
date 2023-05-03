package com.dao;

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
		System.out.println(firstName);
		System.out.println(subject);
		System.out.println(add.getExternal_C());
		if (subject != null) {
			// addMarks for subject C
			if (subject.equals("C")) {
				String insertCMarks = "INSERT INTO RESULT (ENROLLMENT_NUMBER,FIRSTNAME,INTERNAL_C,EXTERNAL_C,PRACTICAL_C,total_C) VALUES (?,?,?,?,?,?)";
				stmt.update(insertCMarks, enrollmentNumber, firstName, add.getInternal_C(),
						add.getExternal_C(), add.getPractical_C(),
						(add.getPractical_C() + add.getExternal_C() + add.getInternal_C()));
			}
			// add marks for subject Java
			else if (subject.equals("JAVA")) {
				String insertJavaMarks = "INSERT INTO RESULT (ENROLLMENT_NUMBER,FIRSTNAME,INTERNAL_JAVA,EXTERNAL_JAVA,PRACTICAL_JAVA,total_JAVA) VALUES (?,?,?,?,?,?)";
				stmt.update(insertJavaMarks, enrollmentNumber, firstName, add.getInternal_Java(),
						add.getExternal_Java(), add.getPractical_Java(),
						(add.getPractical_Java() + add.getExternal_Java() + add.getInternal_Java()));

			}
			// add marks for python
			else if (subject.equals("PYTHON")) {
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
