package com.jw.spring.ex.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jw.spring.ex.jsp.domain.User;
import com.jw.spring.ex.jsp.service.UserService;

@RequestMapping("/jsp/user")
@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	// 이름, 생년월일, 이메일, 자기소개
	
	// Get
	// Post : 보안상 예민한 파라미터가 포함되거나 데이터가 길어 주소로 표현이 어려운 경우
	@PostMapping("/create")
	public String createUser(
			@RequestParam("name") String name
			, @RequestParam("birthday") String birthday
			, @RequestParam("email") String email
			, @RequestParam("introduce") String introduce
			, Model model){
//		int count = userService.addUser(name, birthday, email, introduce);
		User user = new User();
		user.setName(name);
		user.setYyyymmdd(birthday);
		user.setEmail(email);
		user.setIntroduce(introduce);
		
		int count = userService.addUserByObject(user);
		
		model.addAttribute("result", user);
		model.addAttribute("title", "사용자 정보");
		return "jsp/userInfo";
//		return "삽입 결과 : " + user.getId();	
	}
	
	@GetMapping("/input")
	public String inputUser() {
		return "jsp/userInput";
	}
	
	@GetMapping("/info")
	public String userInfo(Model model) {
		
		//가장 최근에 등록된 사용자
		User user = userService.getLastUser();
		model.addAttribute("result", user);
		model.addAttribute("title", "사용자 정보");
		return "jsp/userInfo";
	}
}
