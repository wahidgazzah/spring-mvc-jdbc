package com.dihaw.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class CityExtractor implements ResultSetExtractor<String> {

	public String extractData(ResultSet resultSet) throws SQLException,
			DataAccessException {
		
		String city;
		
		city = resultSet.getString(1);

		return city;
	}

}
