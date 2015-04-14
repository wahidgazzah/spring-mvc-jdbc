package com.dihaw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dihaw.domain.Person;
import com.dihaw.services.PersonService;

@Controller
@RequestMapping("/persons")
public class PersonsController {
	
	@Autowired
	PersonService personService;
	
	private static String PERSON_LIST_VIEW = "view/persons/personList";
	private static String PERSONS_ATTRIBUTE = "view/persons/persons";

	@RequestMapping("/list")
	public String viewPersons(Model model) {
		
		List<Person> persons = personService.getPersons();
		
		model.addAttribute(PERSONS_ATTRIBUTE, persons);
		return PERSON_LIST_VIEW;
		
	}
}
