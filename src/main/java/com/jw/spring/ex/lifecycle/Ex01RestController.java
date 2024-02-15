package com.jw.spring.ex.lifecycle;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller + @ResponseBody : 해당 클래스 내 모든 메소드들에 @ResponseBody 어노테이션이 적용되는 것과 같은 효과
public class Ex01RestController {
	// 직접 만든 클래스 객체 리턴
	@RequestMapping("/lifecycle/ex01/3")
	public Person objectResponse() {
		Person me = new Person("홍길동", 28);
		return me;
	}
}
