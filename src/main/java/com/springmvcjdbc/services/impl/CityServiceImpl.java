package com.springmvcjdbc.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvcjdbc.dao.CityDao;
import com.springmvcjdbc.services.CityService;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	CityDao citydao;

	public List<String> getCityList() {
		return citydao.getCityList();
	}

}
