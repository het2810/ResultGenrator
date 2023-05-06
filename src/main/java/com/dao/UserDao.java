package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.bean.AddMarksBean;
import com.bean.UserBean;
import com.constants.Role;

import com.util.EnrollmentAlreadyExistsException;

@Repository
public class UserDao {
	@Autowired
	JdbcTemplate stmt;

	public void insertStudent(UserBean sb) throws EnrollmentAlreadyExistsException {
	    String selectStudentQuery = "SELECT Enrollment_Number FROM users WHERE Enrollment_Number=?";
	    List<String> enrollmentNumbers = stmt.queryForList(selectStudentQuery, String.class, sb.getEnrollmentNumber());
	    if (!enrollmentNumbers.isEmpty()) {
	        throw new EnrollmentAlreadyExistsException();
	    }
	    String insertStudent = "INSERT INTO users (Enrollment_Number, Role, firstName, Email, Password) VALUES (?, ?, ?, ?, ?)";
	    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String hashPassword = passwordEncoder.encode((sb.getPassword()));
	    stmt.update(insertStudent, sb.getEnrollmentNumber(), Role.STUDENT.getValue(), sb.getFirstName(), sb.getEmail(), hashPassword);
	}

	public void deleteStudent(Integer enrollmentNumber) {
		stmt.update("DELETE FROM USERS WHERE Enrollment_Number =?",enrollmentNumber);
	}
	
	public void deleteFaculty(Integer enrollmentNumber) {
		stmt.update("DELETE FROM USERS WHERE Enrollment_Number =?",enrollmentNumber);
	}
	
	public void insertFaculty(UserBean sb) throws EnrollmentAlreadyExistsException{
		String selectStudentQuery = "SELECT Enrollment_Number FROM users WHERE Enrollment_Number=?";
	    List<String> enrollmentNumbers = stmt.queryForList(selectStudentQuery, String.class, sb.getEnrollmentNumber());
	    if (!enrollmentNumbers.isEmpty()) {
	        throw new EnrollmentAlreadyExistsException();
	    }
		String insertFaculty = "INSERT INTO users (Enrollment_Number, Role, firstName, Email, Password,subjectRoleId) VALUES (?, ?, ?, ?, ?,?)";
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String hashPassword = passwordEncoder.encode((sb.getPassword()));	
		stmt.update(insertFaculty,sb.getEnrollmentNumber(),Role.FACULTY.getValue(),sb.getFirstName(),sb.getEmail(),hashPassword,sb.getSubjectRoleId());		
	}
	
	public List<UserBean> getStudents (){
		
		return stmt.query("select * from users where Role = 2",new BeanPropertyRowMapper<UserBean>(UserBean.class));
	}
	
public List<AddMarksBean> getStudentResult (){
		
//		return stmt.query("select u.firstName,u.enrollment_number, r.* from users u , result r  where r.enrollment_number = u.enrollment_number",new BeanPropertyRowMapper<AddMarksBean>(AddMarksBean.class));
	return stmt.query("select u.firstName,u.enrollment_number,r.internal_c,r.internal_java,r.internal_python,r.internal_maths from users u left join  result r  on u.enrollment_number = r.enrollment_number where u.role = 2",new BeanPropertyRowMapper<AddMarksBean>(AddMarksBean.class));

}
	public List<UserBean> getFaculties (){
		
		return stmt.query("select * from users where Role = 3",new BeanPropertyRowMapper<UserBean>(UserBean.class));
	}
	
	public UserBean getUserByEmail(String email) {
		String selectUserByEmailQuery = "select * from users where email=?";
		List<UserBean> users = stmt.query(selectUserByEmailQuery, new BeanPropertyRowMapper<UserBean>(UserBean.class), email);
		if (users.isEmpty()) {
			return null;
		} else {
			return users.get(0);
		}
	}
	
	

}
