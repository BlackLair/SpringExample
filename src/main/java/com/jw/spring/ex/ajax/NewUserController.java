package com.jw.spring.ex.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jw.spring.ex.jsp.domain.User;
import com.jw.spring.ex.jsp.service.UserService;

@RequestMapping("/ajax/user")
@Controller
public class NewUserController {
	@Autowired
	UserService userService;
	
	@GetMapping("/list")
	public String userList(Model model) {
		List<User> userList = userService.getUserList();
		model.addAttribute("userList", userList);
		return "/ajax/user/list";
	}
	
	// 사용자 저장 API
	@GetMapping("/create")
	@ResponseBody
	public Map<String, String> createUser(
			@RequestParam("name") String name
			,@RequestParam("birthday") String birthday
			,@RequestParam("email") String email
			,@RequestParam("introduce") String introduce) {
		int count = userService.addUser(name, birthday, email, introduce);
		
		// response에 담을 데이터 (JSON 문자열)
		// 저장 성공 실패 여부
		// 성공 시 : {"result":"success"}
		// 실패 시 : {"result":"fail"}
		Map<String, String> resultMap = new HashMap<>();
		if(count == 1) {
			resultMap.put("result", "success");
		}else {
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
	
	@GetMapping("/input")
	public String inputUser() {
		return "/ajax/user/input";
	}
	
	// email 중복 여부 확인 API
	@GetMapping("/duplicated-email")
	@ResponseBody
	public Map<String, Boolean> isDuplicatedEmail(@RequestParam("email") String email) {
		boolean isDuplicated = userService.isDuplicatedEmail(email);
		
		// 중복됨 : {"isDuplicated":true}
		// 중복안됨 : {"isDuplicated:false}
		Map<String, Boolean> resultMap = new HashMap<>();
		resultMap.put("isDuplicated", isDuplicated);
		
		return resultMap;
	}
}
