package com.jw.spring.ex.db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jw.spring.ex.db.domain.UsedGoods;
import com.jw.spring.ex.db.repository.UsedGoodsRepository;

// 로직(business)를 담당
@Service
public class UsedGoodsService {
	
	@Autowired
	private UsedGoodsRepository usedGoodsRepository;
	// Autowired : Spring 프레임워크가 자동으로 객체를 생성해서 주입시켜준다. 
	// 개발자는 객체 생성 없이 바로 이용하면 됨.
	// Autowired 어노테이션이 있다면 NullPointerException이 발생하지 않음
	
	// 중고물품 게시글 리스트를 리턴하는 기능
	public List<UsedGoods> getUsedGoodsList() {
		List<UsedGoods> usedGoodsList =  usedGoodsRepository.selectUsedGoodsList();
		return usedGoodsList;
	}
}
