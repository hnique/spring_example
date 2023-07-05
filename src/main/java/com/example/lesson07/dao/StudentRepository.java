package com.example.lesson07.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.lesson07.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
	// Spring Data JPA
	// save(객체); 메소드가 내장되어있음
	
	// findById(id); 메소드가 내장되어있음
	
	// delete(객체);
}
