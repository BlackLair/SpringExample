package com.jw.spring.ex.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jw.spring.ex.db.domain.UsedGoods;
import com.jw.spring.ex.db.service.UsedGoodsService;

// request, response에 대한 처리
@Controller
public class UsedGoodsController {
	@Autowired
	private UsedGoodsService usedGoodsService;
	
	@RequestMapping("/db/usedgoods/list")
	@ResponseBody
	public List<UsedGoods> usedGoodsList() {
		// 중고물품 게시글 리스트 얻어오기
		List<UsedGoods> usedGoodsList = usedGoodsService.getUsedGoodsList();
		
		return usedGoodsList;
		
	}
}
