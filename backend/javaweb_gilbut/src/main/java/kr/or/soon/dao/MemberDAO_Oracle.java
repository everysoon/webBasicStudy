package kr.or.soon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.or.soon.dto.O_Member;

public class MemberDAO_Oracle {

	private PreparedStatement ps = null;
	private Connection conn = null;
	private ResultSet rs = null;
	private DataSource dataSource;

	public MemberDAO_Oracle() {
		try {
			Context context = new InitialContext(); // JNDI에 접근하기 위한 기본경로 지정 ->java:/comp/env
			Context envCon = (Context) context.lookup("java:/comp/env");
		
			// 미리연결한 DataSource 받아오기
			dataSource = (DataSource) envCon.lookup("jdbc/oracle");// 톰캣 context.xml에 설정한 name값

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public O_Member findMember(String findId) {
		O_Member m =null ;
		try {
			conn=dataSource.getConnection();
			String sql = "select * from member where m_id= ?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, findId);
			rs = ps.executeQuery();
			while(rs.next()) {
				int idx= rs.getInt(1);
				String id = rs.getString("m_id");
				String pwd = rs.getString("m_pwd");
				String email = rs.getString("m_email");
				String name = rs.getString("m_name");
				Date regDate = rs.getDate(6);
				m = new O_Member(idx,id, pwd, name, email,regDate);	
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return m;
	}
	public void modMember(O_Member m) {
		
		System.out.println("dao member ? :"+m.toString());
		String id= m.getM_id();
		String pwd = m.getM_pwd();
		String name = m.getM_name();
		String email = m.getM_email();
		try {
			conn= dataSource.getConnection();
			String sql = "update member set m_pwd =?, m_name =?,m_email=? where m_id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, pwd);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setString(4, id);
			System.out.println("..왜안대..");
			int cnt = ps.executeUpdate();
			System.out.println("cnt? "+cnt);
			conn.setAutoCommit(true);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	public boolean delMember(String id) {
		boolean result = false;
		try {
			conn= dataSource.getConnection();
			String sql = "delete from member where m_id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			int cnt= ps.executeUpdate();
			if(cnt>0) {
				result =true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public List<O_Member> listMembers() {
		List<O_Member> list = new ArrayList<>();
		try {
			conn = dataSource.getConnection();
			conn.setAutoCommit(false);
			String sql = "select * from member order by m_regdate desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					int idx = rs.getInt(1);
					String id = rs.getString("m_id");
					String pwd = rs.getString("m_pwd");
					String name = rs.getString("m_name");
					String email = rs.getString("m_email");
					Date regDate = rs.getDate(6);
					O_Member m = new O_Member(id, pwd, name, email);
					m.setM_id(id);
					m.setM_regDate(regDate);
					list.add(m);
				}
				conn.commit();
			} else {
				System.out.println("listMembers 실패..");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean addMember(O_Member m) {
		boolean result = false;
		try {
			conn = dataSource.getConnection();
			conn.setAutoCommit(false);
			String id = m.getM_id();
			String pwd = m.getM_pwd();
			String email = m.getM_email();
			String name = m.getM_name();
			String sql = "INSERT INTO member VALUES(id_seq.NEXTVAL,?,?,?,?,sysdate)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, m.getM_id());
			ps.setString(2, m.getM_pwd());
			ps.setString(3, m.getM_name());
			ps.setString(4, m.getM_email());
			int cnt = ps.executeUpdate();
			if (cnt > 0) {
				System.out.println("addMember 완료!");
				result=true;
				conn.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
