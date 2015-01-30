package com.dihaw.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dihaw.entity.User;
import com.dihaw.jdbc.UserRowMapper;
import com.dihaw.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	DataSource dataSource;
	
	// An EntityManager will be automatically injected from EntityManagerFactory setup on
	// spring-context.xml
	@PersistenceContext
	private EntityManager entityManager;

	public List<User> findAllUsers() {
		
	    CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	    CriteriaQuery<User> cq = builder.createQuery(User.class);
	    Root<User> root = cq.from(User.class);
	    cq.select(root);
	    return entityManager.createQuery(cq).getResultList();
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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<User> getUserList() {
		List userList = new ArrayList();

		String sql = "select * from user";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(sql, new UserRowMapper());
		return userList;
	}

	@CacheEvict(value = "usersCache", allEntries=true)
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

	@Transactional
	public List<User> getAll() {
		List<User> result = entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
		return result;
	}
	
	@Transactional
	@CacheEvict(value = "usersCache", allEntries=true)
	public void addUser(User user) {
		System.out.println("--------------@CacheEvict--addUser");
		
		entityManager.persist(user);
	}
	
	@Cacheable("usersCache") 
	public List<User> getAllByPageSize(Integer page, Integer size) {
		
		System.out.println("--------------Cacheable--getAllByPageSize");
		
		Query newquery= entityManager.createQuery("SELECT u FROM User u", User.class);
		newquery.setFirstResult(page*size);
		newquery.setMaxResults(size);
		
		return newquery.getResultList();
		
	}

	@Cacheable("usersCache") 
	public int getUsersCount() {
		
		System.out.println("--------------Cacheable--getUsersCount");
		
		Query query = entityManager.createQuery("Select count(u.userId) from User u");
		List result = query.getResultList();
		long count = (Long) result.get(0);
		
		System.out.println("----------count: "+count);
		
		return (int) count;
	}

}
