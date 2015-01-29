package com.dihaw.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dihaw.entity.Gender;
import com.dihaw.entity.User;
import com.dihaw.services.CityService;
import com.dihaw.services.UserService;
import com.dihaw.validators.ValidatorUserEntry;

@Controller
@RequestMapping("/jdbc")
//@SessionAttributes(HomeController.USER_FORM_ATTRIBUTE)
public class HomeController {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	public static final String USER_FORM_ATTRIBUTE = "user";
	public static final String CITY_MODEL_ATTRIBUTE = "cityList";
	public static final String GENDER_MODEL_ATTRIBUTE = "genderList";
	public static final String USERS_COUNT = "0";
	
	public static final String MAP = "map";
	
	private static String REGISTER_VIEW = "pages/jdbc/add";
	private static String LIST_VIEW = "pages/jdbc/list";
	private static String USER_LIST_VIEW = "pages/jdbc/userList";
	private static String EDIT_VIEW = "pages/jdbc/edit";
	
	@Autowired
	private ValidatorUserEntry validatorUserEntry;

	@Autowired
	UserService userService;
	
	@Autowired
	CityService cityService;
	
	@ModelAttribute(USER_FORM_ATTRIBUTE)
	public User registerUSerRequestForm() {
		return new User();
	}
	
	@ModelAttribute(GENDER_MODEL_ATTRIBUTE)
	public List<String> GenderModelAttribute() {
		
		List<String> genderList = new ArrayList<String>();
		genderList.add(Gender.F.getAbreviation());
		genderList.add(Gender.M.getAbreviation());

		return genderList;
	}
	
	@ModelAttribute(CITY_MODEL_ATTRIBUTE)
	public List<String> CityModelAttribute() {
		
		List<String> cityNameList = new ArrayList<String>();
		cityNameList = cityService.getCityList();
		
		return cityNameList;
	}
	
	@ModelAttribute(USERS_COUNT)
	public int usersCount() {
		System.out.println("-------------USERS_COUNT");
		System.out.println("-------------USERS_COUNT: "+userService.getUsersCount());
		
		return userService.getUsersCount();
	}
	
	@RequestMapping(value="/users", method = RequestMethod.GET)
	  public String listAll(Model model) {
	    model.addAttribute("users", userService.getAll());
	    return LIST_VIEW;
	  }
	
	
	@RequestMapping(value="/users/pages/{pageNumber}", method = RequestMethod.GET)
	public String usersList( @PathVariable Integer pageNumber, Model model) {
		
		int usersCount = usersCount();
		
		System.out.println("-------2------> users list with pagination");
		
		int totalPages = usersCount / 3;
		
		int current = pageNumber ;
	    int begin = Math.max(1, current - 5);
	    int end = Math.min(begin + 10, totalPages);

	    model.addAttribute("deploymentLog", pageNumber);
	    model.addAttribute("beginIndex", begin);
	    model.addAttribute("endIndex", end);
	    model.addAttribute("currentIndex", current);
	    model.addAttribute("totalPages", totalPages);
		
		model.addAttribute("usersCount", usersCount);
		model.addAttribute("users", userService.getAllByPageSize(pageNumber, 3));
		
		return USER_LIST_VIEW;
	}

	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String registerUser(Model model, ModelMap modelMap,
			@ModelAttribute(GENDER_MODEL_ATTRIBUTE) List<String> genderList, 
			@ModelAttribute(CITY_MODEL_ATTRIBUTE) List<String> cityList,
			@ModelAttribute(USER_FORM_ATTRIBUTE) User user, BindingResult bindingResult) {
		
		Errors errors = (Errors) modelMap.get("addErrors");
		
		if (errors != null) {
			bindingResult.addAllErrors(errors);
		}

		model.addAttribute(USER_FORM_ATTRIBUTE, new User());
		model.addAttribute(GENDER_MODEL_ATTRIBUTE, genderList);
		model.addAttribute(CITY_MODEL_ATTRIBUTE, cityList);
		
		return REGISTER_VIEW;
		
	}

	@RequestMapping(value = "/do-add", method = RequestMethod.POST)
	public String addUser(Model model,
			@ModelAttribute(GENDER_MODEL_ATTRIBUTE) List<String> genderList, 
			@ModelAttribute(CITY_MODEL_ATTRIBUTE) List<String> cityList,
			@Validated @ModelAttribute(USER_FORM_ATTRIBUTE) User user, 
			BindingResult bindingResult ) {
		
		validatorUserEntry.validate(user, bindingResult);
		
		if (bindingResult.hasErrors()) {
			
			model.addAttribute("addErrors", bindingResult);
			
			model.addAttribute(GENDER_MODEL_ATTRIBUTE, genderList);
			model.addAttribute(CITY_MODEL_ATTRIBUTE, cityList);
			
			return REGISTER_VIEW;
		}
		
		else{
			userService.addUser(user);
			return "redirect:/jdbc/users";
		}
	}

	@RequestMapping(value="/edit", method = RequestMethod.GET)
	public String editUser(Model model, ModelMap modelMap,
			@ModelAttribute(GENDER_MODEL_ATTRIBUTE) List<String> genderList, 
			@ModelAttribute(CITY_MODEL_ATTRIBUTE) List<String> cityList,
			@RequestParam String id,
			@ModelAttribute(USER_FORM_ATTRIBUTE) User user,
			BindingResult bindingResult) {
		
		logger.info("RequestMapping: /edit");
		
		Errors errors = (Errors) modelMap.get("editErrors");
		
		if (errors != null) {
			bindingResult.addAllErrors(errors);
		}

		user = userService.getUser(id);
		
		model.addAttribute(USER_FORM_ATTRIBUTE, user);
		model.addAttribute(GENDER_MODEL_ATTRIBUTE, genderList);
		model.addAttribute(CITY_MODEL_ATTRIBUTE, cityList);
		
		return EDIT_VIEW;

	}

	@RequestMapping(value="/do-edit", method = RequestMethod.POST)
	public String updateUser(Model model,
			@ModelAttribute(GENDER_MODEL_ATTRIBUTE) List<String> genderList, 
			@ModelAttribute(CITY_MODEL_ATTRIBUTE) List<String> cityList,
			@ModelAttribute(USER_FORM_ATTRIBUTE) User user,
			BindingResult bindingResult ) {
		
		logger.info("RequestMapping: /do-edit");
		
		if (bindingResult.hasErrors()) {
			
			model.addAttribute("editErrors", bindingResult);
			
			model.addAttribute(USER_FORM_ATTRIBUTE, user);
			model.addAttribute(GENDER_MODEL_ATTRIBUTE, genderList);
			model.addAttribute(CITY_MODEL_ATTRIBUTE, genderList);
			
			return EDIT_VIEW;
		}
		else{
			
			userService.updateData(user);
			return "redirect:/jdbc/users";
		}
		
	}

	@RequestMapping("/delete")
	public String deleteUser(@RequestParam String id) {
		
		logger.info("RequestMapping: /delete");
		
		userService.deleteData(id);
		
		return "redirect:/jdbc/users";
	}
}