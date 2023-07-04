package com.example.lesson04.bo;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.dao.StudentMapper;
import com.example.lesson04.domain.Student;
import com.example.lesson07.dao.StudentRepository;
import com.example.lesson07.entity.StudentEntity;

@Service
public class StudentBO {
	@Autowired
	private StudentMapper studentMapper;
	
	@Autowired
	private StudentRepository studentRepository;

	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	}
	
	public Student getStudentById(int id) {
		return studentMapper.selectStudentById(id);
	}
	
	public StudentEntity addStudent(String name, String phoneNumber, String email, String dreamjob) {
		StudentEntity student = studentRepository.save(
					StudentEntity.builder()
					.name(name)
					.phoneNumber(phoneNumber)
					.email(email)
					.dreamjob(dreamjob)
					.createdAt(ZonedDateTime.now()) // @UpdatedTimestamp 생략가능
					.build()
				);
		return student;
	}
	
	// input:  id, dreamjob
	// output: StudentEntity
	public StudentEntity updateStudentDreamjobById(int id, String dreamjob) {
		// 기존 데이터 조회(id로)
		StudentEntity student = studentRepository.findById(id).orElse(null);
		
		// entity 변경(dreamjob) => save
		if (student != null) {
			student = student.toBuilder() // toBuilder(): 기존값 유지하고 일부만 변경
				.dreamjob(dreamjob)
				.build();
			
			student = studentRepository.save(student); // update
		}
		return student;
	}
}
