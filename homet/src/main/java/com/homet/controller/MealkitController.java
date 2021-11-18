package com.homet.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.homet.model.Mealkit;
import com.homet.model.SetMenu;
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
	
	
	//11.17(21:20) 밀키트 BEST 추천 페이지 5개
	@RequestMapping(value = "/chooseSet",params = "category=1")
	public String setList1(Model model) {
		List<SetMenu> setList = new ArrayList<SetMenu>();
		setList = service.getSetByCategory("bulk");	// 인자랑 db테이블의 category랑 이름 같게하면 같은게 나옴
		System.out.println(setList);
		model.addAttribute("setList",setList);
		return "kit/set1.html";
	}
	
	@RequestMapping(value = "/chooseDetail",params = "category=1")
	public String setDetail1(Model model) {
		List<SetMenu> setList = new ArrayList<SetMenu>();
		setList = service.getSetByCategory("bulk");	// 인자랑 db테이블의 category랑 이름 같게하면 같은게 나옴
		System.out.println(setList);
		model.addAttribute("setList",setList);
		return "kit/set1detail.html";
	}
	
	
	@RequestMapping(value = "/chooseSet",params = "category=2")
	public String setList2(Model model) {
		List<SetMenu> setList = new ArrayList<SetMenu>();
		setList = service.getSetByCategory("balance");	// 인자랑 db테이블의 category랑 이름 같게하면 같은게 나옴
		model.addAttribute("setList",setList);
		return "kit/set2.html";
	}
	@RequestMapping(value = "/chooseDetail",params = "category=2")
	public String setDetail2(Model model) {
		List<SetMenu> setList = new ArrayList<SetMenu>();
		setList = service.getSetByCategory("balance");	// 인자랑 db테이블의 category랑 이름 같게하면 같은게 나옴
		System.out.println(setList);
		model.addAttribute("setList",setList);
		return "kit/set2detail.html";
	}
	
	@RequestMapping(value = "/chooseSet",params = "category=3")
	public String setList3(Model model) {
		List<SetMenu> setList = new ArrayList<SetMenu>();
		setList = service.getSetByCategory("bodyprofile");	// 인자랑 db테이블의 category랑 이름 같게하면 같은게 나옴
		model.addAttribute("setList",setList);
		return "kit/set3.html";
	}
	@RequestMapping(value = "/chooseDetail",params = "category=3")
	public String setDetail3(Model model) {
		List<SetMenu> setList = new ArrayList<SetMenu>();
		setList = service.getSetByCategory("bodyprofile");	// 인자랑 db테이블의 category랑 이름 같게하면 같은게 나옴
		System.out.println(setList);
		model.addAttribute("setList",setList);
		return "kit/set3detail.html";
	}
	@RequestMapping(value = "/chooseSet",params = "category=4")
	public String setList4(Model model) {
		List<SetMenu> setList = new ArrayList<SetMenu>();
		setList = service.getSetByCategory("diet");	// 인자랑 db테이블의 category랑 이름 같게하면 같은게 나옴
		model.addAttribute("setList",setList);
		return "kit/set4.html";
	}
	@RequestMapping(value = "/chooseDetail",params = "category=4")
	public String setDetail4(Model model) {
		List<SetMenu> setList = new ArrayList<SetMenu>();
		setList = service.getSetByCategory("diet");	// 인자랑 db테이블의 category랑 이름 같게하면 같은게 나옴
		System.out.println(setList);
		model.addAttribute("setList",setList);
		return "kit/set4detail.html";
	}
	@RequestMapping(value = "/chooseSet",params = "category=5")
	public String setList5(Model model) {
		List<SetMenu> setList = new ArrayList<SetMenu>();
		setList = service.getSetByCategory("salad");	// 인자랑 db테이블의 category랑 이름 같게하면 같은게 나옴
		model.addAttribute("setList",setList);
		return "kit/set5.html";
	}
	
	@RequestMapping(value = "/chooseDetail",params = "category=5")
	public String setDetail5(Model model) {
		List<SetMenu> setList = new ArrayList<SetMenu>();
		setList = service.getSetByCategory("salad");	// 인자랑 db테이블의 category랑 이름 같게하면 같은게 나옴
		System.out.println(setList);
		model.addAttribute("setList",setList);
		return "kit/set5detail.html";
	}
	
}