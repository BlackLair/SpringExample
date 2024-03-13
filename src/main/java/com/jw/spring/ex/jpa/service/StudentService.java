package com.jw.spring.ex.jpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jw.spring.ex.jpa.domain.Student;
import com.jw.spring.ex.jpa.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	public Student addStudent(String name, String phoneNumber, String email, String dreamJob) {
		Student student = Student.builder()
		.name(name)
		.phoneNumber(phoneNumber)
		.email(email)
		.dreamJob(dreamJob).build();
									
		studentRepository.save(student);
		return student;
	}

	// 전달된 id와 일치하는 학생 정보 중 장래희망을 전달받은 값으로 수정
	public Student updateStudent(int id, String dreamJob) {
		// 1. update 대상 행을 조회
		// 2. 조회를 통해 얻은 객체의 특정 값을 수정
		// 3. 수정된 객체를 저장
		
		// Optional : null일 수 있는 값을 처리하기 위한 클래스
		// NullPointerException 방지, null에 대한 처리 기능 포함
		// null이 리턴될 수 있는 메소드의 리턴 타입으로 많이 사용됨
		Optional<Student> optionalStudent = studentRepository.findById(id);
		
		// optionalStudent가 null이 아니면 원본을, null이면 매개변수를 원래 클래스 형으로 반환한다. ( 현재 코드에선 null일때 null 반환 )
		Student student = optionalStudent.orElse(null); 
		
		// Setter 없이 Builder를 통해 값 수정하기
		// Entity 클래스에 @Builder 어노테이션에 toBuilder 옵션 true로 설정해야 함
		student = student.toBuilder()
		.dreamJob(dreamJob)
		.build();
		
		// primary key가 있는 객체를 save 메소드에 전달하면 update가 이루어짐
		studentRepository.save(student);
		
		return student;
	}
	
	public void deleteStudent(int id) {
		// id 기반 삭제
//		studentRepository.deleteById(id);
		
		// 삭제 대상 행 조회
		// 객체 기반으로 삭제
		// 삭제 성공/실패 여부에 따른 추가 처리 가능
		Optional<Student> optionalStudent = studentRepository.findById(id);
		Student student = optionalStudent.orElse(null);
		studentRepository.delete(student);
	}
}
