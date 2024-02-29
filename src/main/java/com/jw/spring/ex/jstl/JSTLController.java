package com.jw.spring.ex.jstl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/jstl")
@Controller
public class JSTLController {
	
	@GetMapping("/ex01")
	public String ex01() {
		return "jstl/ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(Model model) {
		
		// 과일 이름 록록 리스트
		List<String> fruitList = new ArrayList<>();
		fruitList.add("사과");
		fruitList.add("귤");
		fruitList.add("바나나");
		model.addAttribute("fruitList", fruitList);
		
		List<Map<String, Object>> memberList = new ArrayList<>();
		// 이름, 나이, 취미
		Map<String, Object> memberMap1 = new HashMap<>();
		memberMap1.put("name", "유재석");
		memberMap1.put("age", 52);
		memberMap1.put("hobby", "진행");
		Map<String, Object> memberMap2 = new HashMap<>();
		memberMap2.put("name", "조세호");
		memberMap2.put("age", 43);
		memberMap2.put("hobby", "쇼핑");
		
		memberList.add(memberMap1);
		memberList.add(memberMap2);
		
		model.addAttribute("memberList", memberList);
		
		return "jstl/ex02";
	}
	
	@GetMapping("/ex03")
	public String ex03(Model model) {
		
		Date now = new Date();
		model.addAttribute("now", now);
		
		return "jstl/ex03";
	}
	
	@GetMapping("/ex04")
	public String exo4() {
		return "jstl/ex04";
	}
}
