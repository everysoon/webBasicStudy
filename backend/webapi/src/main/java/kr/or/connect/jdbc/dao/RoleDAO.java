package kr.or.connect.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import kr.or.connect.jdbc.dto.Role;

public class RoleDAO {
	Connection conn = null;
	PreparedStatement ps = null; // 명령 담을 객체
	ResultSet rs = null; // 결과 담을 객체
	private static String url = "jdbc:mysql://localhost/mavenjdbc?characterEncoding=utf-8&useSSL=false&autoReconnect=true&serverTimezone=Asia/Seoul";
	private static String user = "root";
	private static String password = "ict01";

	public boolean conn() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 드라이버 로딩
			System.out.println("Loading OK");
			conn = DriverManager.getConnection(url, user, password); // DB와 connection
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	// try - with Resource 사용!
	public List<Role> getRoles(){
		List<Role> list =new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e) {
			e.printStackTrace();
		}
		String sql = "SELECT description,role_id FROM role ORDER BY role_id desc";
		try(Connection conn = DriverManager.getConnection(url,user,password);
				PreparedStatement ps = conn.prepareStatement(sql)){
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					String description = rs.getString(1);
					int id = rs.getInt("role_id");
					Role role = new Role(id,description);
					list.add(role);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	// closeAll 대신 try - with resource 를 사용하자!
	public void closeAll() {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	}
	public int addRole(Role role) {
		int insertCnt = 0;
		try {
			if (conn()) {
				String sql = "INSERT INTO role VALUES (?,?)";
				ps = conn.prepareStatement(sql);
				ps.setInt(1,role.getRoleId());
				ps.setString(2, role.getDescription());
				insertCnt = ps.executeUpdate();
		
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return insertCnt;
		
	}

	// 데이터 한 건 가져오는 메서드
	public Role getRole(int roleId) {
		Role role = null;
		if (conn()) {
			String sql = "SELECT role_id, description FROM role WHERE role_id= ? ";
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, roleId);
				rs = ps.executeQuery();
				if (rs.next()) {
					int role_id = rs.getInt("role_id"); // rs.getInt(1) 가능
					String description = rs.getString("description"); // rs.getString(2) 가능
					role = new Role(role_id, description);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeAll();
			}
			return role;
		}
		return null;
	}

}
