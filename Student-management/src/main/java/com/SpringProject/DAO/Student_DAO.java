package com.SpringProject.DAO;

import java.util.List;

import com.SpringProject.API.Student;

public interface Student_DAO {
	
	List<Student> loadStudent();
	void saveStudent(Student student);
	Student getStudent(int id);
	void update(Student student);
	void delete(int id);

}
