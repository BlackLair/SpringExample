package com.jw.spring.ex.mybatis.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jw.spring.ex.mybatis.domain.Review;

@Mapper
public interface ReviewRepository {
	public Review selectReview(@Param("id") int id);
	
	public int insertReview(
			@Param("storeId") int storeId
			, @Param("menu") String menu
			, @Param("userName") String userName
			, @Param("point") double point
			, @Param("review") String review);
	public int insertReviewByObject(Review review);
	
	public int updatePoint(@Param("id")int id, @Param("point") double point);
	public int doublePoint(@Param("id")int id);

}
