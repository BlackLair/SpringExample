package com.jw.spring.ex.MyTestPackage;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyTestController {
	@GetMapping("/jstl/format/test")
	public String formatTest(Model model) {
		Date now = new Date();
		model.addAttribute("now", now);
		
		return "/jstl/MyEx";
	}
}
