package com.jw.spring.ex.ajax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jw.spring.ex.jsp.domain.User;
import com.jw.spring.ex.jsp.service.UserService;

@Controller
public class NewUserController {
	@Autowired
	UserService userService;
	
	@GetMapping("/ajax/user/list")
	public String userList(Model model) {
		List<User> userList = userService.getUserList();
		model.addAttribute("userList", userList);
		return "/ajax/user/list";
	}
	
	
}
