package com.dihaw.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CityRowMapper implements RowMapper<String> {

	public String mapRow(ResultSet resultSet, int line) throws SQLException {
		CityExtractor cityExtractor = new CityExtractor();
		return cityExtractor.extractData(resultSet);
	}

}
