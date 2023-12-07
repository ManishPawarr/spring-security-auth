package com.example.SecurityAuthPractice.Config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.SecurityAuthPractice.Entity.Student;
import com.example.SecurityAuthPractice.Repository.StudentRepository;

@Component
public class StudentDetailsUserDetailsService implements UserDetailsService {

	@Autowired
	private StudentRepository repo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Student> student = repo.findByEmail(email);
		return student.map(StudentDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with email " + email));
	}

}
