package com.example.SecurityAuthPractice.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SecurityAuthPractice.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	public Optional<Student> findByEmail(String email);

}
