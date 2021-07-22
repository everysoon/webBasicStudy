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

import kr.or.soon.dto.Article;

public class BoardDAO {
	private DataSource dataSource;
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	public BoardDAO() {
		try {
			Context context = new InitialContext();
			Context env = (Context) context.lookup("java:/comp/env");
			dataSource = (DataSource) env.lookup("jdbc/oracle");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Article viewArticle(int articleNO) {
		Article a = new Article();
		try {
			conn= dataSource.getConnection();
			String sql = "SELECT articleNO,parentNO,title,content,imgFileName,m_id,writedate FROM board where articleNO = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, articleNO);
			rs = ps.executeQuery();
			rs.next();
			a.setArticleNO(rs.getInt(1));
			a.setParentNO(rs.getInt(2));
			a.setTitle(rs.getString(3));
			a.setContent(rs.getString(4));
			a.setImgFileName(rs.getString(5));
			a.setM_id(rs.getString(6));
			a.setWritedate(rs.getDate(7));
			rs.close();
			ps.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	public List<Article> selectAllArticles() {
		List<Article> list = new ArrayList<>();
		try {
			conn = dataSource.getConnection();
			String sql = "SELECT LEVEL,articleNO,parentNO,title,content,m_id,writedate"
					+ " FROM board START WITH parentNO=0 CONNECT BY PRIOR articleNO = parentNO"
					+ " ORDER SIBLINGS BY articleNO DESC";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				int level = rs.getInt(1);
				int aNO = rs.getInt(2);
				int pNO = rs.getInt(3);
				String title = rs.getString("title");
				String content = rs.getString("content");
				String id = rs.getString("m_id");
				Date writedate = rs.getDate("writedate");
				Article a = new Article(level, aNO, pNO, title, content, id, writedate);
				System.out.println(a.toString());
				list.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	private int getNewArticleNO() {
		try {
			conn=dataSource.getConnection();
			String sql = "SELECT max(articleNO) from board"; // 기본글 번호 중 가장 큰 번호 검색
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				// 가장 큰 번호에 1 더한 값 리턴
				return (rs.getInt(1)+1);
			}
			rs.close();
			ps.close();
			conn.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int addArticle(Article a) {
		int articleNO = getNewArticleNO(); // 새 글에 대한 번호 가져오기
		System.out.println("addArticle articleNO :"+articleNO);
		try {
			conn = dataSource.getConnection();
			a.setArticleNO(articleNO);
			int parentNO = a.getParentNO();
			String title =a.getTitle();
			String content = a.getContent();
			String id = a.getM_id();
			String imgFileName = a.getImgFileName();
			String sql = "INSERT INTO board VALUES(?,?,?,?,?,sysdate,?)";
			System.out.println("addArticle"+a.toString());
			ps= conn.prepareStatement(sql);
			ps.setInt(1, articleNO);
			ps.setInt(2, parentNO);
			ps.setString(3, title);
			ps.setString(4, content);
			ps.setString(5, imgFileName);
			ps.setString(6, id);
			ps.executeUpdate();
			ps.close();
			conn.close();
			System.out.println("추가 완료!");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return articleNO;
	}
	
}
