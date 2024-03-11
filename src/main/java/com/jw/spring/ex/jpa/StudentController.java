package com.jw.spring.ex.jpa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jw.spring.ex.jpa.domain.Student;

@Controller
public class StudentController {
	
	@GetMapping("/lombok/test")
	@ResponseBody
	public Student lombokTest() {
//		Entity 클래스에 @Getter, @Setter 어노테이션 추가 시 getter, setter 메소드들이 자동으로 추가됨
//		Student student = new Student();
//		student.setName("홍길동");
//		student.setDreamJob("개발자");
//		student.setPhoneNumber("010-1234-5677");
		
//		Entity 클래스에 @AllArgsConstructor 어노테이션 추가 시 자동으로 모든 필드를 채울 수 있는 생성자 생성됨
//		Student student = new Student(1, "홍길동", "010-1234-5678", "hong@gmail.com", "개발자", new Date(), new Date());
		
		// builder 패턴
		// 데이터를 저장하기 위한 목적의 클래스. 객체 생성에서 명료하고 명확하게 표현하는 방법
		// Entity 클래스에 @Builder 어노테이션 필요
		Student student = Student.builder()
						.name("홍길동")
						.email("hong@gmail.com")
						.dreamJob("개발자")
						.phoneNumber("010-1234-5678")
						.build();
		return student;
	}
}
