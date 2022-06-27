package com.SpringProject.rowmapper;

import java.sql.ResultSet;
import com.SpringProject.API.Student;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;



public class StudentRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Student s = new Student();
		
		s.setId(rs.getInt("Id"));
		s.setName(rs.getString("Name"));
		s.setMobileNumber(rs.getLong("mobile_Number"));
		s.setLocation(rs.getString("Location"));
		
		return s;
	}

}
