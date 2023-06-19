package com.example.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson02.dao.UsedGoodsMapper;
import com.example.lesson02.domain.UsedGoods;

@Service // Spring Bean
public class UsedGoodsBO {
	// field
	@Autowired // Dependency Inject (DI) => 의존성 주입 => Spring bean
	private UsedGoodsMapper usedGoodsMapper; // = null 생략 가능
	
	// input: X
	// output: List<UsedGoods> -> 컨트롤러한테 돌려준다.
	public List<UsedGoods> getUsedGoodsList() {
		List<UsedGoods> usedGoodsList = usedGoodsMapper.selectUsedGoodsList();
		return usedGoodsList;
	}
}
