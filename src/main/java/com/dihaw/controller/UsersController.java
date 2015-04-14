package com.dihaw.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dihaw.domain.Gender;
import com.dihaw.domain.User;
import com.dihaw.services.CityService;
import com.dihaw.services.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	private static String REGISTER_VIEW = "view/users/add";
	private static String LIST_VIEW = "view/users/list";
	private static String EDIT_VIEW = "view/users/edit";

	@Autowired
	UserService userService;
	
	@Autowired
	CityService cityService;
	
	@RequestMapping("/register")
	public String registerUser(@ModelAttribute User user, Model model) {
		
		logger.info("RequestMapping: /register");
		
		List<String> genderList = new ArrayList<String>();
		
		genderList.add(Gender.F.getAbreviation());
		genderList.add(Gender.M.getAbreviation());
		
		logger.info("genderList: "+genderList);
		
		List<String> cityNameList = new ArrayList<String>();
		cityNameList = cityService.getCityList();
		
		logger.info("cityNameList: "+cityNameList);

		Map<String, List> map = new HashMap<String, List>();
		map.put("genderList", genderList);
		map.put("cityList", cityNameList);
		
		model.addAttribute("map", map);
		return REGISTER_VIEW;
		
	}

	@RequestMapping("/insert")
	public String inserData(@ModelAttribute User user) {
		
		logger.info("User: /insert");
		
		logger.info("user: "+user);
		
		if (user != null)
			userService.insertData(user);
		
		return "redirect:/users/getList";
	}
	

	@RequestMapping("/list")
	public String getUserLIst(Model model) {
		
		logger.info("RequestMapping: /getList");
		
		List<User> userList = userService.getUserList();
		
		logger.info("userList: "+userList);
		
		model.addAttribute("userList", userList);
		return LIST_VIEW;
		
	}

	@RequestMapping("/edit")
	public String editUser(@RequestParam String id,
			@ModelAttribute User user, Model model) {
		
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
		return EDIT_VIEW;

	}

	@RequestMapping("/update")
	public String updateUser(@ModelAttribute User user) {
		
		logger.info("RequestMapping: /update");
		
		userService.updateData(user);
		
		return "redirect:/users/list";

	}

	@RequestMapping("/delete")
	public String deleteUser(@RequestParam String id) {
		
		logger.info("RequestMapping: /delete");
		
		System.out.println("id = " + id);
		userService.deleteData(id);
		
		return "redirect:/users/list";
	}
}