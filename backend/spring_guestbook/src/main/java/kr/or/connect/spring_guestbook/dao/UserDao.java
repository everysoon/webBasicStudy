package kr.or.connect.spring_guestbook.dao;

import static kr.or.connect.spring_guestbook.dao.UserSqls.DELETE_BY_IDX;
import static kr.or.connect.spring_guestbook.dao.UserSqls.LOGIN_AND_REGISTER;
import static kr.or.connect.spring_guestbook.dao.UserSqls.SELECT_BY_IDX;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.spring_guestbook.dto.User;
@Repository
public class UserDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<User> userMapper = BeanPropertyRowMapper.newInstance(User.class);
	
	public UserDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("user").usingGeneratedKeyColumns("idx");
	}
	public boolean login(String id,String password) {
		boolean loginOk = false;
		Map<String,String> param = new HashMap<>();
		param.put("id", id);
		param.put("password",password);
		List<User> users = jdbc.query(LOGIN_AND_REGISTER, param,userMapper);
		if(users != null) {
			for(User u : users) {
				System.out.println(u.getId());
				System.out.println(u.getPassword());
			}
			loginOk = true;
		}
		return loginOk;
	}
	
	/*
	 * public Map<String,String> register(String id, String password){
	 * Map<String,String> map = new HashMap<>(); map.put("id", id); User user =
	 * jdbc.queryForOb(SELECT_BY_ID, map,userMapper); boolean regiValid =false;
	 * for(User u:users) { System.out.println("-----------------");
	 * System.out.println(u.getId()); System.out.println(u.getPassword());
	 * System.out.println("-----------------"); } if(users==null) { regiValid =
	 * true; map.put("password", password); } map.put("valid",
	 * String.valueOf(regiValid)); return map; }
	 */
	public Long insert(User user) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(user);
		return insertAction.executeAndReturnKey(params).longValue();
	}
	public int deleteById(Long idx) {
		Map<String,?> params = Collections.singletonMap("idx", idx);
		return jdbc.update(DELETE_BY_IDX, params);
	}
	public Map<String,String> selectById(Long idx) {
		Map<String,?> params = Collections.singletonMap("idx", idx);
		List<User> users = jdbc.query(SELECT_BY_IDX, params,userMapper);
		Map<String,String> result =null;
		if(users != null) {
			for(User u : users) {
				result =  new HashMap<>();
				System.out.println(u.getId());
				System.out.println(u.getPassword());
				result.put("id", u.getId());
				result.put("password", u.getPassword());
			}
		}
		return result;
	}
}
