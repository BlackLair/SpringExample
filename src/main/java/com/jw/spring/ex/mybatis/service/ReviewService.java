package com.jw.spring.ex.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jw.spring.ex.mybatis.domain.Review;
import com.jw.spring.ex.mybatis.repository.ReviewRepository;

@Service
public class ReviewService {
	@Autowired
	private ReviewRepository reviewRepository;
	
	public Review getReview(int id){
		Review review = reviewRepository.selectReview(id);
		return review;
	}
	
	public int addReview(
			int storeId
			, String menu
			, String userName
			, double point
			, String review) {
		int count = reviewRepository.insertReview(storeId, menu, userName, point, review);
		return count;
		
	}
	
	public int addReviewByObject(Review review) {
		int count = reviewRepository.insertReviewByObject(review);
		return count;
	}
	
	@Transactional
	public void updateDoublePoint(int id, double point){
		Review review = reviewRepository.selectReview(id);
		double current = review.getPoint();

		reviewRepository.updatePoint(id, current);

	}
}
