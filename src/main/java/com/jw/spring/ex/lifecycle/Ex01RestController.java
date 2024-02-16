package com.jw.spring.ex.lifecycle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller + @ResponseBody : 해당 클래스 내 모든 메소드들에 @ResponseBody 어노테이션이 적용되는 것과 같은 효과
@RequestMapping("/lifecycle/ex01")
public class Ex01RestController {
	// 직접 만든 클래스 객체 리턴
	@RequestMapping("/3")
	public Person objectResponse() {
		Person me = new Person("홍길동", 28);
		return me;
	}
	
	@RequestMapping("/4")
	public ResponseEntity<Person> entityResponse() {
		Person me = new Person("강감찬", 44);
		
		// HTTP status code
		// 200 OK : 정상적인 상태
		// 404 Not Found : 페이지가 없음 (URL Path 확인)
		// 405 Method Not Allow : 메소드가 일치하지 않음 (Get, Post 메소드 확인)
		// 400 Bad Request : 요청이 잘못됨 (파라미터 확인)
		// 500 Internal Server Error : 서버 에러
		
		// 개발자가 직접 HTTP Status code를 지정하여 Response를 처리
		ResponseEntity<Person> entity = new ResponseEntity<>(me, HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	}
}
