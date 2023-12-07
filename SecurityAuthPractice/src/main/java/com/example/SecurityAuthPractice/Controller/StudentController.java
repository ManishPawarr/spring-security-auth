package com.example.SecurityAuthPractice.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SecurityAuthPractice.Entity.Student;
import com.example.SecurityAuthPractice.Service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping("/home")
	public String home() {
		return "This is home! Accessible to everyone!";
	}

	@PostMapping("/add")
	public String addStudent(@RequestBody Student student) {
		return service.addStudent(student);
	}

	@GetMapping("/student/getAll")
	@PreAuthorize("hasAuthority('role_admin')")
	public List<Student> getAllStudents() {
		return service.getAllStudents();
	}

	@GetMapping("/student/get/{id}")
	@PreAuthorize("hasAuthority('role_user')")
	public Optional<Student> getIdStudent(@PathVariable long id) {
		return service.getIdStudent(id);
	}
}
