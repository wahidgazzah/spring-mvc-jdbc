package com.dihaw.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dihaw.domain.Person;

@Controller
@RequestMapping("/msm")
public class PersonsController {
	
	private static String INDEX_VIEW = "index";
	private static String PERSON_LIST_VIEW = "personList";
	private static String TEMPLATE_VIEW = "template/SiteTemplate";
	private static String PERSONS_ATTRIBUTE = "persons";


	@RequestMapping("/index")
	public String index() {
		return INDEX_VIEW;
	}
	
	@RequestMapping("/template")
	public String templateView() {
		return TEMPLATE_VIEW;
	}
	
	@RequestMapping("/viewPeson")
	public String viewPersons(Model model) {
		
		List<Person> persons = Person.createPersons();
		
		model.addAttribute(PERSONS_ATTRIBUTE, persons);
		return PERSON_LIST_VIEW;
		
	}
}
