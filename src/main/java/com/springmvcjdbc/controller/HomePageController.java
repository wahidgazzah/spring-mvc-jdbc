package com.springmvcjdbc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvcjdbc.domain.Gender;
import com.springmvcjdbc.domain.User;
import com.springmvcjdbc.services.CityService;
import com.springmvcjdbc.services.UserService;

@Controller
public class HomePageController {
	private static final Logger logger = Logger.getLogger(HomePageController.class);

	@Autowired
	UserService userService;
	
	@Autowired
	CityService cityService;

	@SuppressWarnings("rawtypes")
	@RequestMapping("/register")
	public String registerUser(@ModelAttribute User user, Model model) {
		
		logger.info("RequestMapping: /register");
		
		List<String> genderList = new ArrayList<String>();
		
		// use enum for GENDER
		genderList.add(Gender.F.getAbreviation());
		genderList.add(Gender.M.getAbreviation());
		
		logger.info("genderList: "+genderList);


		List<String> cityNameList = new ArrayList<String>();
		// use CityService to get the city_name list
		cityNameList = cityService.getCityList();
		
		logger.info("cityNameList: "+cityNameList);

		Map<String, List> map = new HashMap<String, List>();
		map.put("genderList", genderList);
		map.put("cityList", cityNameList);
		
		//return new ModelAndView("register", "map", map);
		model.addAttribute("map", map);
		return "register";
	}

	@RequestMapping("/insert")
	public String inserData(@ModelAttribute User user) {
		
		logger.info("User: /insert");
		
		logger.info("user: "+user);
		
		if (user != null)
			userService.insertData(user);
		
		return "redirect:/getList";
	}

	@RequestMapping("/getList")
	public String getUserLIst(Model model) {
		
		logger.info("RequestMapping: /getList");
		System.out.println("sys: RequestMapping: /getList");
		
		List<User> userList = userService.getUserList();
		
		logger.info("userList: "+userList);
		
		//return new ModelAndView("userList", "userList", userList);
		model.addAttribute("userList", userList);
		return "userList";
		
	}

	@RequestMapping("/edit")
	public String editUser(@RequestParam String id,@ModelAttribute User user,Model model) {
		
		logger.info("RequestMapping: /edit");

		user = userService.getUser(id);
		
		logger.info("user: "+user);

		List<String> genderList = new ArrayList<String>();
		genderList.add(Gender.F.getAbreviation());
		genderList.add(Gender.M.getAbreviation());


		List<String> cityNameList = new ArrayList<String>();
		cityNameList = cityService.getCityList();


		Map<String, Object> map = new HashMap<String, Object>();
		map.put("genderList", genderList);
		map.put("cityList", cityNameList);
		map.put("user", user);

		model.addAttribute("map", map);
		
		return "edit";

	}

	@RequestMapping("/update")
	public String updateUser(@ModelAttribute User user) {
		
		logger.info("RequestMapping: /update");
		
		userService.updateData(user);
		
		return "redirect:/getList";

	}

	@RequestMapping("/delete")
	public String deleteUser(@RequestParam String id) {
		
		logger.info("RequestMapping: /delete");
		
		System.out.println("id = " + id);
		userService.deleteData(id);
		
		return "redirect:/getList";
	}
}