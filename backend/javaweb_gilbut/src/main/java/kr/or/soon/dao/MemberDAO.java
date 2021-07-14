package kr.or.soon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.or.soon.dto.Member;

public class MemberDAO {
	public static final String url ="jdbc:mysql://localhost/springDB";
	public static final String user ="root";
	public static final String pwd ="ict01";
	
	private PreparedStatement ps = null;
	private Connection conn = null;
	private ResultSet rs = null;
	private DataSource dataSource;
	public void connDB() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url,user,pwd);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public List<Member> getListMemebers(){
		List<Member> list = new ArrayList<>();
		try {
			connDB();
			String sql = "select * from member";
			ps = conn.prepareStatement(sql);
			rs= ps.executeQuery();
			while(rs.next()) {
				Member m = new Member();
				m.setM_id(rs.getString(1));
				m.setM_pwd(rs.getString(2));
				m.setM_name(rs.getString(3));
				m.setM_email(rs.getString(4));
				m.setM_regDate(String.valueOf(new Date()));
				list.add(m);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<Member> getListMembersWithConnectionPool(){
		List<Member> list =null;
		try {
			Context context = new InitialContext(); // JNDI에 접근하기 위한 기본경로 지정 ->java:/comp/env
			Context envCon = (Context) context.lookup("java:/comp/env");

			// 미리연결한 DataSource 받아오기
			dataSource = (DataSource)envCon.lookup("jdbc/mysql");// 톰캣 context.xml에 설정한 name값
			conn = dataSource.getConnection();
			list = getListMemebers();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
