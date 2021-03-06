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
		
		String sql ="SELECT * FROM `spring-project`.`student`";
		List<Student> theListOfStudent = jdbcTemplate.query(sql, new StudentRowMapper());
		
		  return theListOfStudent;
	}
	@Override
	public void saveStudent(Student student) {
		Object[] sqlparameters= {student.getName(),student.getMobileNumber(),student.getLocation()};
		
		String sqlQuerry ="insert into student(Name,Mobile_number,Location) values(?,?,?)";
		
		jdbcTemplate.update(sqlQuerry, sqlparameters);
		System.out.println("1 row inserted");
		
	}
	@Override
	public Student getStudent(int id) {
		
		String sql="SELECT * FROM STUDENT WHERE ID=?";
		Student student = jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);
		return student;
	}
	@Override
	public void update(Student student) {
		
		String sql="UPDATE STUDENT SET Name=?, Mobile_number=?, Location=? WHERE id=?	";
		jdbcTemplate.update(sql, student.getName(),student.getMobileNumber(),student.getLocation(),student.getId());
		System.out.println("1 record updated");
	}
	@Override
	public void delete(int id) {
		String sql="DELETE FROM STUDENT  WHERE id=?	";
		jdbcTemplate.update(sql, id);
		
		System.out.println("1 record deleted");
		
	}

}
