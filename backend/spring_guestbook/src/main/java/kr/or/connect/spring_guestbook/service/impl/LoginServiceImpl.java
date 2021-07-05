package kr.or.connect.spring_guestbook.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.spring_guestbook.dao.UserDao;
import kr.or.connect.spring_guestbook.dto.User;
import kr.or.connect.spring_guestbook.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	UserDao dao;
	@Override
	@Transactional
	public boolean login(String id, String password) {
		return dao.login(id, password);	
	}

	@Override
	public int deleteById(String idx) {
		return dao.deleteById(Long.valueOf(idx));
	}

	@Override
	public Long insert(User user) {
		return dao.insert(user);
	}

	@Override
	public Map<String, String> selectById(String idx) {
		return dao.selectById(Long.valueOf(idx));
	}

	/*
	 * @Override public Map<String, String> register(String id, String password) {
	 * Map<String,String > test = dao.register(id, password);
	 * System.out.println("id : "+ test.get("id"));
	 * System.out.println("password : "+test.get("password"));
	 * System.out.println("valid : "+test.get("valid"));
	 * 
	 * 
	 * 
	 * return test; }
	 */

	
	
}
