package com.jw.spring.ex.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jw.spring.ex.jpa.domain.Student;
													// <Entity 클래스, primary key 타입>
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
}
