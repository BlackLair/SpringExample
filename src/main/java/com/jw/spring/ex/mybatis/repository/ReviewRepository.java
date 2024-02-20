package com.jw.spring.ex.mybatis.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jw.spring.ex.mybatis.domain.Review;

@Mapper
public interface ReviewRepository {
	public Review selectReview(@Param("id") int id);
}
