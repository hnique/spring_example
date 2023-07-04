package com.example.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson07.entity.StudentEntity;

@RestController
@RequestMapping("/lesson07/ex01")
public class Lesson07Ex01RestController {
	
	@Autowired
	private StudentBO studentBO;
	
	// CUD (create update delete)
	
	// C:create
	@GetMapping("/1")
	public StudentEntity create() {
		String name = "신보람";
		String phoneNumber = "010-1111-2222";
		String email = "sbr@kakao.com";
		String dreamjob = "개발자";
		
		StudentEntity student = studentBO.addStudent(name, phoneNumber, email, dreamjob);
		return student; // @ResponseBody + return 객체 => JSON
	}
	
	// U:update
	@GetMapping("/2")
	public StudentEntity update() {
		// id가 4번인 dreamjob 변경 => "디자이너"
		StudentEntity student = studentBO.updateStudentDreamjobById(4, "디자이너");
		return student;
	}
}
