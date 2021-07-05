package kr.or.connect.spring_guestbook.dao;

public class UserSqls {
	public static final String SELECT_BY_IDX = "SELECT idx,id,password FROM user WHERE idx =:idx";
	public static final String DELETE_BY_IDX = "DELETE FROM user WHERE idx=:idx";
	public static final String LOGIN_AND_REGISTER = "SELECT id,password FROM user WHERE id=:id && password=:password";
	public static final String SELECT_BY_ID = "SELECT idx,id,password FROM user WHERE id=:id";
	
}
