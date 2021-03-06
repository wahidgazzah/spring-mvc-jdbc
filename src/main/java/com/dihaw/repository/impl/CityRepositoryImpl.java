package com.dihaw.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dihaw.jdbc.CityRowMapper;
import com.dihaw.repository.CityRepository;

@Repository
public class CityRepositoryImpl  implements CityRepository{

	@Autowired
	DataSource dataSource;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<String> getCityList() {
		List cityList = new ArrayList();

		String sql = "select city_name from city";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		cityList = jdbcTemplate.query(sql, new CityRowMapper());
		return cityList;
	}

}
