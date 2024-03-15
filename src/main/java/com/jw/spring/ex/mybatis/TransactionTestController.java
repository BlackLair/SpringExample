package com.jw.spring.ex.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jw.spring.ex.mybatis.domain.Review;
import com.jw.spring.ex.mybatis.service.ReviewService;

@Controller
public class TransactionTestController {
	@Autowired
	ReviewService reviewService;
	
	@GetMapping("/mybatis/tranjactionTest")
	@ResponseBody
	public Review transactionTest(){
		reviewService.updateDoublePoint(24, 0.1);
		return reviewService.getReview(24);
	}
}
