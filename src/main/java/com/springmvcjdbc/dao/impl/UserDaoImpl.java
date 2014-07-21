package com.springmvcjdbc.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.metadata.CallMetaDataContext;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Repository;

import com.springmvcjdbc.dao.UserDao;
import com.springmvcjdbc.domain.User;
import com.springmvcjdbc.jdbc.UserRowMapper;

@Repository
public class UserDaoImpl extends StoredProcedure implements UserDao {

	@Autowired
	DataSource dataSource;
	
	protected CallMetaDataContext context = new CallMetaDataContext();
	
	private static final String PROC_NAME = "GetListUsers";
	
	@Autowired
    public UserDaoImpl(DataSource ds) {		
        super(ds, PROC_NAME);
        context.setProcedureName(PROC_NAME);
		context.initializeMetaData(ds);
        declareParameter(context.createReturnResultSetParameter("p_out", new UserRowMapper()));
        compile(); 
    }

	public void insertData(User user) {

		String sql = "INSERT INTO user "
				+ "(first_name,last_name, gender, city) VALUES (?, ?, ?,?)";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(
				sql,
				new Object[] { user.getFirstName(), user.getLastName(),
						user.getGender(), user.getCity() });

	}

	
	public List<User> getUserList() {
		Map<String, Object> out = execute();
    	List<User> userList = (List<User>) out.get("p_out");    
		return userList;
	}

	
	
	
	public void deleteData(String id) {
		String sql = "delete from user where user_id=" + id;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql);

	}

	public void updateData(User user) {

		String sql = "UPDATE user set first_name = ?,last_name = ?, gender = ?, city = ? where user_id = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(
				sql,
				new Object[] { user.getFirstName(), user.getLastName(),
						user.getGender(), user.getCity(), user.getUserId() });

	}

	public User getUser(String id) {
		List<User> userList = new ArrayList<User>();
		String sql = "select * from user where user_id= " + id;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(sql, new UserRowMapper());
		return userList.get(0);
	}

}
