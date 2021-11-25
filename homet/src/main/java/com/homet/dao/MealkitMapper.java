package com.homet.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.homet.model.Mealkit;
import com.homet.model.Orders;
import com.homet.model.SetMenu;

@Mapper	//어노테이션 쓰려면 mybatis 3.0 이상이어야 함.
public interface MealkitMapper {
	 List<Mealkit> getByCategory(String category);
	 Mealkit getByIdx(int midx);
	 void insertOrder(Orders order);
	 List<Orders> getOrderByNickname(String nickname);
	 List<SetMenu> getSetByCategory(String category);
	 List<Orders> orderList(String orderList);
}
