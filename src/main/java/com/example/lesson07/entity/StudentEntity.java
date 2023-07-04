package com.example.lesson07.entity;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity // 이 클래스는 Entity라고 명시
@Table(name = "new_student") // 테이블명과 클래스명이 동일하면 생략 가능
@Getter // Getter
@Builder(toBuilder = true) // Setter 대용, toBuilder=true: 기존 객체에 일부 필드값만 변경 가능
@NoArgsConstructor // 파라미터가 없는 기본 생성자
@AllArgsConstructor // 모든 필드를 인자값으로 받는 생성자
@ToString // toString override 값 예쁘게 출력
public class StudentEntity {
	@Id // 이 필드는 pk라고 알려주는 어노테이션
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
	private int id;
	private String name;
	
	@Column(name = "phoneNumber") // CamelCase 필드인 경우 반드시 명시
	private String phoneNumber;
	
	private String email;
	
	private String dreamjob;
	
	@UpdateTimestamp // createdAt이 null이면 현재시간을 자동으로 입력
	@Column(name = "createdAt", updatable = false) // updatable=false 업데이트시 시간 갱신 안함
	private ZonedDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name = "updatedAt")
	private ZonedDateTime updatedAt;
}
