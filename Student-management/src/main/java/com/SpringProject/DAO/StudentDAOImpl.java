package com.SpringProject.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.SpringProject.API.Student;
import com.SpringProject.rowmapper.StudentRowMapper;

@Repository
public class StudentDAOImpl implements Student_DAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public List<Student> loadStudent() {
		
		//List<Student> studentList = new ArrayList<Student>();	
		
		String sql ="SELECT * FROM `spring-project`.`student-database`";
		List<Student> theListOfStudent = jdbcTemplate.query(sql, new StudentRowMapper());
		
		  return theListOfStudent;
	}

}
