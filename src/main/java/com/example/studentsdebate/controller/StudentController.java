package com.example.studentsdebate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.*;

import com.example.studentsdebate.entity.Students;
import com.example.studentsdebate.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	
	
	@RequestMapping("/list")
	public String listStudents(Model model)
	{
		List<Students> students = studentService.findAll();
		
		model.addAttribute("Students", students);
		
		return "list-students";	
	}
	
	
	@RequestMapping("/showFormForAdd")
	public String shorFormforAdd(Model model) {
		Students student = new Students();
		model.addAttribute("Student",student);
		
		return "Student-form";
	}
	
	
	@RequestMapping("/showFormforUpdate")
	public String formForUpdate(Model model, @RequestParam("studentId") int id) {
		Students students = studentService.findById(id);
		model.addAttribute("Student",students);
		
		return "Student-form";
	}
	
	
	@PostMapping("/save")
	public String saveStudent(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("department") String department,
			@RequestParam("country") String country) {
		System.out.println(id);
		Students student;
		
		if(id!=0) {
			student = studentService.findById(id);
			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setCountry(country);
			student.setDepartment(department); 
		}
		else {
			student = new Students(firstName, lastName, department, country);
		}
		
		studentService.save(student);
		
		
		return "redirect:/students/list";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int theId) {
		studentService.deleteById(theId);
		return "redirect:/students/list";

	}


	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {
		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", "You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;
	}
	
	
	
}
