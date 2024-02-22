package com.jw.spring.ex.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jw.spring.ex.mybatis.domain.Review;
import com.jw.spring.ex.mybatis.service.ReviewService;

@RequestMapping("/mybatis/review")
@Controller
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	
	@RequestMapping("/")
	@ResponseBody
	public Review review(@RequestParam("id") int id) {
		Review review = reviewService.getReview(id);
		return review;
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public String createReview() {
		//4, 치즈피자, 홍길동, 4.6
		//int count = reviewService.addReview(4, "치즈피자", "홍길동", 4.6, null);
		
		Review review = new Review();
		review.setStoreId(2);
		review.setMenu("뿌링클");
		review.setUserName("이순신");
		review.setPoint(4.3);
		review.setReview("역시 뿌링클은 진리");
		int count = reviewService.addReviewByObject(review);
		return "수행 결과 : " + count;
	}
}
