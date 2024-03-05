package com.jw.spring.ex.MyTestPackage;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@RequestMapping("/redirectTest")
@Controller
public class MyTestController {
	@GetMapping("/home")
	public String redirectTest(Model model) {
		return "/test/redirectTest";
	}
	
	@GetMapping("/byResponseEntity")
	public ResponseEntity<Object> redirectByResponseEntity() throws URISyntaxException {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(new URI("http://localhost:8080/redirectTest/destination"));
		return new ResponseEntity<>(httpHeaders, HttpStatus.PERMANENT_REDIRECT);
	}
	
	@GetMapping("/byPrefix")
	public String redirectByPrefix() {
		return "redirect:/redirectTest/destination";
	}
	
	@GetMapping("/byRedirectView")
	public RedirectView redirectByRedirectView() {
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("http://localhost:8080/redirectTest/destination");
		return redirectView;
	}
	
	@GetMapping("/destination")
	public String destination() {
		return "/test/destination";
	}
}
