package com.SpringProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.SpringProject.API.Student;
import com.SpringProject.API.StudentDTO;
import com.SpringProject.DAO.StudentDAOImpl;
import com.SpringProject.DAO.Student_DAO;

@Controller
public class StudentController {
	@Autowired
	 private Student_DAO studentdata;
	
	@GetMapping("/showStudent")
	public String showStdentList(Model model)
	{
		List<Student> loadStudent = studentdata.loadStudent();
		model.addAttribute("students", loadStudent);
		return "student-list";
	}
	@GetMapping("/showAddStudentPage")
	public String addStudent(Model model)
	{
		StudentDTO studentDTO = new StudentDTO();
		model.addAttribute("student", studentDTO);
		return "add-student";
	}
}

