package com.SpringProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.SpringProject.API.Student;
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
		Student student = new Student();
		model.addAttribute("student", student);
		return "add-student";
	}
	
	@PostMapping("/saveStudent")
	public String save_student(Student student)
	{
		System.out.println(student);
		//studentdata.saveStudent(student);
		if(student.getId()==0)
		{
			studentdata.saveStudent(student);
		}
		else
		{
			studentdata.update(student);
		}
		return "redirect:/showStudent";
	}
	
	@GetMapping("/updateStudent")
	public String updateStudent(@RequestParam("userId") int id ,Model model)
	{
		Student student = new Student();
		model.addAttribute("student", student);
		System.out.println(id);
		Student theStudent= studentdata.getStudent(id);
		System.out.println(theStudent);
		
		model.addAttribute("student", theStudent);
		
		return "add-student";
	}
	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("userId") int id ,Model model)
	{
		Student student = new Student();
		model.addAttribute("student", student);
	
		studentdata.delete(id);
		
		return "redirect:/showStudent";
	}

}

