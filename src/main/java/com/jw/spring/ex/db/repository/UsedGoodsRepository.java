package com.jw.spring.ex.db.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jw.spring.ex.db.domain.UsedGoods;

@Mapper // 특정 Mapper와 연동됨을 명시
public interface UsedGoodsRepository {
	// 데이터베이스 접속 -> 쿼리 문자열 -> 쿼리 수행 -> 수행 결과 얻어옴 -> 얻어온 결과를 사용이 편리한 데이터로 변환
	// MyBatis Framework
	
	// used_goods 모든 행 조회 기능
	public List<UsedGoods> selectUsedGoodsList();
}
