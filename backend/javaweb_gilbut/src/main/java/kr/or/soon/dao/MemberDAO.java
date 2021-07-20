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
	public List<Member> searchList(Member m){
		List<Member> list= new ArrayList<>();
		try {
			Context context = new InitialContext(); // JNDI에 접근하기 위한 기본경로 지정 ->java:/comp/env
			Context envCon = (Context) context.lookup("java:/comp/env");

			// 미리연결한 DataSource 받아오기
			dataSource = (DataSource)envCon.lookup("jdbc/mysql");// 톰캣 context.xml에 설정한 name값
			conn = dataSource.getConnection();
			String sql ="select * from member";
			String name = m.getM_name();
			System.out.println("dao name : "+name);
			if(name!=null&&name.length()!=0) {
				// 검색할 이름이 있으면
				sql += " where m_name = ?";
				ps=conn.prepareStatement(sql);
				System.out.println("sql문 ? : "+sql);
				ps.setString(1, name);
			}else {
				ps =conn.prepareStatement(sql);
			}
			rs = ps.executeQuery();
			while(rs.next()) {
				Member temp = new Member();
				temp.setM_idx(rs.getInt("m_idx"));
				System.out.println("idx ? "+rs.getInt("m_idx"));
				temp.setM_id(rs.getString("m_id"));
				temp.setM_pwd(rs.getString("m_pwd"));
				temp.setM_name(rs.getString("m_name"));
				temp.setM_email(rs.getString("m_email"));
				temp.setM_regDate(rs.getString("m_regdate"));
				list.add(temp);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public boolean addMember(Member m){
		boolean result = false;
		try {
			Context context = new InitialContext(); // JNDI에 접근하기 위한 기본경로 지정 ->java:/comp/env
			Context envCon = (Context) context.lookup("java:/comp/env");
			
			// 미리연결한 DataSource 받아오기
			dataSource = (DataSource)envCon.lookup("jdbc/mysql");// 톰캣 context.xml에 설정한 name값
			conn = dataSource.getConnection();
			int idx = 5; 
			String sql = "insert into member values(?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, String.valueOf(idx));
			ps.setString(2, m.getM_id());
			ps.setString(3, m.getM_pwd());
			ps.setString(4, m.getM_name());
			ps.setString(5, m.getM_email());
			ps.setString(6, "2021-07-20");
			idx++;
			int cnt  = ps.executeUpdate();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public boolean isExisted(Member m) {
		boolean result =false;
		String id = m.getM_id();
		String password = m.getM_pwd();
		try {
			Context context = new InitialContext(); // JNDI에 접근하기 위한 기본경로 지정 ->java:/comp/env
			Context envCon = (Context) context.lookup("java:/comp/env");

			// 미리연결한 DataSource 받아오기
			dataSource = (DataSource)envCon.lookup("jdbc/mysql");// 톰캣 context.xml에 설정한 name값
			conn = dataSource.getConnection();
			String sql = "select if(count(*)>=1,'true','false')as result from member where m_id =? and m_pwd =?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, password);
			rs = ps.executeQuery();
			rs.next(); // 커서를 첫번째 레코드로 위치시킴
			result = Boolean.parseBoolean(rs.getString("result"));
			System.out.println("result :"+result);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
