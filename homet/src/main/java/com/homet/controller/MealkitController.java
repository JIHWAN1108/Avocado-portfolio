package com.homet.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.homet.model.Mealkit;
import com.homet.model.Orders;
import com.homet.model.SetMenu;
import com.homet.model.User;
import com.homet.service.MealkitService;

@Controller
@RequestMapping("/mealkit")
public class MealkitController {
	
	@Autowired	//커스텀생성자 없으면 autowired
	MealkitService service;
	
	@RequestMapping(value={"/","/mealkithome"})
	public String mealkithome() {
		return "kit/mealkithome";
	}
	
	@RequestMapping(value = "/mealkit", method = RequestMethod.GET)
	public String makekit(Model model) {
		
		List<Mealkit> list = new ArrayList<Mealkit>();
		list = service.getByCategory("meat");// 인자랑 db테이블의 category랑 이름 같게하면 같은게 나옴
		model.addAttribute("list",list);	//여기서 list가 mealkit.html에서의 반복문의 ${list}와 같음.
		
		return "kit/mealkit";
	}
	
	@RequestMapping(value = "/mealkitset")
	public String mealkitSet(Model model) {
		
		List<SetMenu> setList = new ArrayList<SetMenu>();
		setList = service.getSetByCategory("set");	// 인자랑 db테이블의 category랑 이름 같게하면 같은게 나옴
		model.addAttribute("setList",setList);
		return "kit/mealkitset";
		
	}
	
	
	//11.17(21:20) 밀키트 BEST 추천 페이지 5개 (category=1,2,3,4,5)
	@RequestMapping(value = "/chooseSet",params = "category=1")
	public String setList1(Model model) {
		List<SetMenu> setList = new ArrayList<SetMenu>();
		setList = service.getSetByCategory("bulk");	// 인자랑 db테이블의 category랑 이름 같게하면 같은게 나옴
		model.addAttribute("setList",setList);
		return "kit/set1";
	}
	
	@RequestMapping(value = "/chooseSet",params = "category=2")
	public String setList2(Model model) {
		List<SetMenu> setList = new ArrayList<SetMenu>();
		setList = service.getSetByCategory("balance");	// 인자랑 db테이블의 category랑 이름 같게하면 같은게 나옴
		model.addAttribute("setList",setList);
		return "kit/set2";
	}
	
	@RequestMapping(value = "/chooseSet",params = "category=3")
	public String setList3(Model model) {
		List<SetMenu> setList = new ArrayList<SetMenu>();
		setList = service.getSetByCategory("bodyprofile");	// 인자랑 db테이블의 category랑 이름 같게하면 같은게 나옴
		model.addAttribute("setList",setList);
		return "kit/set3";
	}
	
	@RequestMapping(value = "/chooseSet",params = "category=4")
	public String setList4(Model model) {
		List<SetMenu> setList = new ArrayList<SetMenu>();
		setList = service.getSetByCategory("diet");	// 인자랑 db테이블의 category랑 이름 같게하면 같은게 나옴
		model.addAttribute("setList",setList);
		return "kit/set4";
	}
	
	@RequestMapping(value = "/chooseSet",params = "category=5")
	public String setList5(Model model) {
		List<SetMenu> setList = new ArrayList<SetMenu>();
		setList = service.getSetByCategory("salad");	// 인자랑 db테이블의 category랑 이름 같게하면 같은게 나옴
		model.addAttribute("setList",setList);
		return "kit/set5";
	}
	
	//11.20(20:30) 밀키트 추천페이지 detail가는 핸들러메소드. (detail에서 각 토큰으로 나눈 idx에 해당하는 이름, 가격 출력)
	// 추가 개선사항 -> detail 페이지와 이 메소드는 하나로 두고, 페이지에서 if문 사용해서 category별 제목 다르게 나오게 하기.
	@RequestMapping(value = "/chooseDetail")
	public String setDetail1(Model model, @RequestParam String idx_list, String setidx) {
		System.out.println(idx_list);
		System.out.println(setidx);
		List<Mealkit> meal_list = new ArrayList<Mealkit>();
		StringTokenizer token = new StringTokenizer(idx_list,"/");
		while(token.hasMoreTokens()) {
			Mealkit meal = service.getByIdx(Integer.parseInt(token.nextToken()));
			meal_list.add(meal);
		}
		model.addAttribute("setidx",setidx);
		model.addAttribute("meal_list",meal_list);
		return "kit/setdetail";
	}
	
	// 11.23 주문하기
	@RequestMapping(value="/orderList")
	public String order(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();		//로그인 한 id의 것만 보여주려고
		
		User user = (User)session.getAttribute("user");
		System.out.println(user);
		List<Orders> orderList = service.getOrderByNickname(user.getNickname());
		model.addAttribute("orderList",orderList);
		System.out.println(orderList);
		return "kit/shopping";
	}
	
}

