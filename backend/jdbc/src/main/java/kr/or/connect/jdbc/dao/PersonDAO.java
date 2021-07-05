package kr.or.connect.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.or.connect.jdbc.dto.Person;

public class PersonDAO {
	private static String url = "jdbc:mysql://localhost/mavenjdbc?characterEncoding=utf-8&useSSL=false&autoReconnect=true&serverTimezone=Asia/Seoul";
	private static String user = "root";
	private static String password = "ict01";

	ResultSet rs;
	// 싱글톤
	private static PersonDAO dao = new PersonDAO();

	public static PersonDAO getInstance() {
		return dao;
	}

	public Person getLogin(Person p) {
		classForName();
		Person newP  = null;
		String sql = "SELECT * FROM person WHERE id= ? and pw = ?";
		try (Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, p.getId());
			ps.setString(2, p.getPw());
			rs = ps.executeQuery();
			if (rs.next()) {
				newP = new Person();
				newP.setIdx(rs.getString(1));
				newP.setId(rs.getString(2));
				newP.setPw(rs.getString(3));
				newP.setName(rs.getString(4));
				newP.setAge(rs.getString(5));
				newP.setAddr(rs.getString(6));
				newP.setReg(rs.getString(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newP;
	}

	public void classForName() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getInsert(Person p) {
		classForName();
		int cnt = 0;
		String sql = "INSERT INTO person(id,pw,name,age,addr,reg) VALUES(?,?,?,?,?,now())";
		try (Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setString(1, p.getId());
			ps.setString(2, p.getPw());
			ps.setString(3, p.getName());
			ps.setString(4, p.getAge());
			ps.setString(5, p.getAddr());
			cnt = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

	public List<Person> getSelectAll() {
		classForName();
		String sql = "SELECT * FROM person ORDER BY idx";
		try (Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement ps = conn.prepareStatement(sql);) {
			List<Person> list = new ArrayList<>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Person p = new Person();
				p.setIdx(rs.getString(1));
				p.setId(rs.getString(2));
				p.setPw(rs.getString(3));
				p.setName(rs.getString(4));
				p.setAge(rs.getString(5));
				p.setAddr(rs.getString(6));
				p.setReg(rs.getString(7));
				list.add(p);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Person getDetail(String idx) {
		classForName();
		Person p = null;
		String sql = "SELECT * FROM person WHERE idx = ?";
		try (Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, idx);
			rs = ps.executeQuery();
			if (rs.next()) {
				p = new Person();
				p.setIdx(rs.getString(1));
				p.setId(rs.getString(2));
				p.setPw(rs.getString(3));
				p.setName(rs.getString(4));
				p.setAge(rs.getString(5));
				p.setAddr(rs.getString(6));
				p.setReg(rs.getString(7));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	public int getDelete(String idx) {
		classForName();
		int cnt = 0;
		String sql = "DELETE FROM person WHERE idx = ?";
		try (Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, idx);
			cnt = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
	public int getUpdate(Person p) {
		classForName();
		int cnt = 0;
		String sql = "UPDATE person set name =?, age =? ,addr =? where idx = ?";
		try(Connection conn = DriverManager.getConnection(url,user,password);
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, p.getName());
			ps.setString(2, p.getAge());
			ps.setString(3, p.getAddr());
			ps.setString(4, p.getIdx());
			cnt = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
}
