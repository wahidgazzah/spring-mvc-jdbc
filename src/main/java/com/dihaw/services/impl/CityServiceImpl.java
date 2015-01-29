package com.dihaw.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dihaw.repository.CityRepository;
import com.dihaw.services.CityService;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	CityRepository citydao;

	public List<String> getCityList() {
		return citydao.getCityList();
	}

}
