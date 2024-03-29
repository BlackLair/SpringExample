package com.jw.spring.ex.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jw.spring.ex.jpa.domain.Student;
import com.jw.spring.ex.jpa.repository.StudentRepository;
import com.jw.spring.ex.jpa.service.StudentService;

@RequestMapping("/jpa/student")
@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	
	// 실전에선 절대 Controller 내에서 Repository를 사용하지 말 것!!
	@Autowired
	private StudentRepository studentRepository;
	
	// 학생 정보 저장
	@GetMapping("/create")
	@ResponseBody
	public Student createStudent(){
		String name = "고주몽";
		String phoneNumber = "010-5858-1515";
		String email = "jumong@gmail.com";
		String dreamJob = "개발자";
		
		Student student = studentService.addStudent(name, phoneNumber, email, dreamJob);
		return student;
	} 
	
	@GetMapping("/update")
	@ResponseBody
	public Student updateStudent() {
		// id가 8인 학생정보의 장래 희망을 강사로 수정
		Student student = studentService.updateStudent(3, "선생님");
		return student;
	}
	
	@GetMapping("/delete")
	@ResponseBody
	public String deleteStudent() {
		// id가 10인 행 삭제
		studentService.deleteStudent(10);
		return "삭제 완료";
	}
	
	@GetMapping("/read")
	@ResponseBody
	public List<Student> readStudent() {
		// 전체 행 조회
		List<Student> studentList = null;
//		studentList = studentRepository.findAll();
//		studentList = studentRepository.findTop2ByOrderByIdDesc();
//		studentList = studentRepository.findByName("조세호");
		
//		List<String> nameList = new ArrayList<>();
//		nameList.add("유재석");
//		nameList.add("조세호");
//		studentList = studentRepository.findByNameIn(nameList);
		
//		studentList = studentRepository.findByEmailContaining("naver");
		
//		studentList = studentRepository.findByIdBetweenOrderByIdDesc(2, 3);
		studentList = studentRepository.findByNativeQuery("선생님");
		return studentList;
	}
	
	
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
