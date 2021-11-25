package com.homet.service;

import java.util.List;

import com.homet.model.Mealkit;
import com.homet.model.Orders;
import com.homet.model.SetMenu;

public interface MealkitService {
	 List<Mealkit> getByCategory(String category);
	 Mealkit getByIdx(int idx);
	 void insertOrder(Orders order);
	 List<Orders> getOrderByNickname(String nickname);
	 List<SetMenu> getSetByCategory(String category);
	 List<Orders> orderList(String orderList);
}
