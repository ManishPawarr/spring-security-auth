package com.example.SecurityAuthPractice.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.SecurityAuthPractice.Entity.Student;
import com.example.SecurityAuthPractice.Repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repo;

	@Autowired
	private PasswordEncoder encoder;

	public String addStudent(Student student) {
		student.setPassword(encoder.encode(student.getPassword()));
		repo.save(student);
		return "Student Added Successfully";
	}

	public List<Student> getAllStudents() {
		return repo.findAll();
	}
	
	public Optional<Student> getIdStudent(long id) {
		return repo.findById(id);
	}
}
