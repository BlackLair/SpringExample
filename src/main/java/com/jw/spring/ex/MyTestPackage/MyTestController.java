package com.jw.spring.ex.MyTestPackage;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyTestController {
	@GetMapping("/jstl/function/test")
	public String functionTest(Model model) {
		
		
		return "/jstl/MyEx";
	}
}
