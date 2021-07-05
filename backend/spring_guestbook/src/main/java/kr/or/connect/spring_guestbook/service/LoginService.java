package kr.or.connect.spring_guestbook.service;

import java.util.Map;

import kr.or.connect.spring_guestbook.dto.User;

public interface LoginService {
	public boolean login(String id,String password);
	public int deleteById(String idx);
	public Long insert(User user);
	public Map<String,String> selectById(String idx);
//	public Map<String,String> register(String id,String password);
}
