package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.AddMarksBean;

@Repository
public class AddMarksDao {
	@Autowired
	JdbcTemplate stmt;

	// addMarks into Result Table
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
				String updateCMarks = "UPDATE RESULT SET INTERNAL_C=?, EXTERNAL_C=?, PRACTICAL_C=? WHERE ENROLLMENT_NUMBER=?";
				stmt.update(updateCMarks, add.getInternal_C(), add.getExternal_C(), add.getPractical_C(),
						enrollmentNumber);
			} else if (subject.equals("JAVA")) {
				String updateJavaMarks = "UPDATE RESULT SET INTERNAL_JAVA=?, EXTERNAL_JAVA=?, PRACTICAL_JAVA=? WHERE ENROLLMENT_NUMBER=?";
				stmt.update(updateJavaMarks, add.getInternal_Java(), add.getExternal_Java(), add.getPractical_Java(),
						enrollmentNumber);
			} else if (subject.equals("PYTHON")) {
				String updatePythonMarks = "UPDATE RESULT SET INTERNAL_PYTHON=?, EXTERNAL_PYTHON=?, PRACTICAL_PYTHON=? WHERE ENROLLMENT_NUMBER=?";
				stmt.update(updatePythonMarks, add.getInternal_Python(), add.getExternal_Python(),
						add.getPractical_Python(), enrollmentNumber);
			} else if (subject.equals("MATHS")) {
				String updateMathsMarks = "UPDATE RESULT SET INTERNAL_MATHS=?, EXTERNAL_MATHS=? WHERE ENROLLMENT_NUMBER=?";
				stmt.update(updateMathsMarks, add.getInternal_Maths(), add.getExternal_Maths(), enrollmentNumber);
			}

		} else {

			// Insert marks
			if (subject.equals("C")) {
				String insertCMarks = "INSERT INTO RESULT (ENROLLMENT_NUMBER,FIRSTNAME,INTERNAL_C,EXTERNAL_C,PRACTICAL_C) VALUES (?,?,?,?,?)";
				stmt.update(insertCMarks, enrollmentNumber, firstName, add.getInternal_C(), add.getExternal_C(),
						add.getPractical_C());
			} else if (subject.equals("JAVA")) {
				String insertJavaMarks = "INSERT INTO RESULT (ENROLLMENT_NUMBER,FIRSTNAME,INTERNAL_JAVA,EXTERNAL_JAVA,PRACTICAL_JAVA) VALUES (?,?,?,?,?)";
				stmt.update(insertJavaMarks, enrollmentNumber, firstName, add.getInternal_Java(),
						add.getExternal_Java(), add.getPractical_Java());

			} else if (subject.equals("PYTHON")) {
				String insertPythonMarks = "INSERT INTO RESULT (ENROLLMENT_NUMBER,FIRSTNAME,INTERNAL_PYTHON,EXTERNAL_PYTHON,PRACTICAL_PYTHON) VALUES (?,?,?,?,?)";
				stmt.update(insertPythonMarks, enrollmentNumber, firstName, add.getInternal_Python(),
						add.getExternal_Python(), add.getPractical_Python());
			}
			// add marks for Maths
			else if (subject.equals("MATHS")) {
				String insertMathsMarks = "INSERT INTO RESULT (ENROLLMENT_NUMBER,FIRSTNAME,INTERNAL_MATHS,EXTERNAL_MATHS) VALUES (?,?,?,?)";
				stmt.update(insertMathsMarks, enrollmentNumber, firstName, add.getInternal_Maths(),
						add.getExternal_Maths());
			}

		}
	}

	public List<AddMarksBean> getMarks(Integer studentEnrollment) {
		System.out.println("getMarks called .....");
		List<AddMarksBean> studentMarks = stmt.query(
				"SELECT ENROLLMENT_NUMBER,FIRSTNAME , COALESCE(internal_C, -1) AS internal_C,COALESCE(internal_Java, -1) AS internal_Java,COALESCE(internal_Python, -1) AS internal_Python,COALESCE(internal_Maths, -1) AS internal_Maths,COALESCE(external_C, -1) AS external_C,COALESCE(external_Java, -1) AS external_Java,COALESCE(external_Python, -1) AS external_Python,COALESCE(external_Maths, -1) AS external_Maths,COALESCE(practical_C, -1) AS practical_C,COALESCE(practical_Java, -1) AS practical_Java,COALESCE(practical_Python, -1) AS practical_Python,COALESCE(total_C, 0) AS total_C,COALESCE(total_Java, 0) AS total_Java,COALESCE(total_Python, 0) AS total_Python,COALESCE(total_Maths, 0) AS total_Maths FROM result WHERE enrollment_Number = ?",
				new BeanPropertyRowMapper<AddMarksBean>(AddMarksBean.class), studentEnrollment);
		return studentMarks;
	}

	public void deleteStudent(Integer enrollmentNumber) {
		stmt.update("DELETE FROM result WHERE Enrollment_Number =?", enrollmentNumber);
	}

	public String getSubjectFromEnrollment(Integer facultyEnrollment) {
		String subject = stmt.queryForObject("SELECT subjectRoleId FROM USERS WHERE ENROLLMENT_NUMBER = ?",
				String.class, new Object[] { facultyEnrollment });
		System.out.println(subject);
		return subject;
	}

	public List<AddMarksBean> getStudentsForResult() {

		return stmt.query("select * from result where total is not null ", new BeanPropertyRowMapper<AddMarksBean>(AddMarksBean.class));
	}
	public void updateResultStatus() {
		stmt.update("UPDATE RESULT SET CHECKDOWNLOAD=1 WHERE TOTAL IS NOT NULL ");
	}
	
	public List<AddMarksBean> getResult(Integer studentEnrollment) {

		return stmt.query("select * from result where Enrollment_Number =? ", new BeanPropertyRowMapper<AddMarksBean>(AddMarksBean.class),studentEnrollment);
	}
	
}
