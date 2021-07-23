package kr.or.soon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
	public int selectTotalArticles(){
		try {
			conn = dataSource.getConnection();
			String sql = "SELECT count(articleNO) FROM board";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return (rs.getInt(1));
			}
			rs.close();
			ps.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public List<Integer> selectRemovedArticles(int articleNO){
		List<Integer> list = new ArrayList<Integer>();
		try {
			conn=dataSource.getConnection();
			String sql = "SELECT articleNO FROM board START WITH articleNO =? CONNECT BY PRIOR articleNO = parentNO";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, articleNO);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				articleNO = rs.getInt("articleNO");
				list.add(articleNO);
			}
			ps.close();
			conn.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public void deleteArticle(int articleNO) {
		try {
			conn=dataSource.getConnection();
			// 계층형 쿼리를 통해 삭제글과 관련된 자식글까지 모두 삭제
			String sql = "DELETE FROM board WHERE articleNO in (SELECT articleNO FROM board START WITH articleNO =? CONNECT BY PRIOR articleNO = parentNO )";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, articleNO);
			int cnt = ps.executeUpdate();
			if(cnt>0) {
				System.out.println(cnt+" 개의 Article 삭제 성공");
			}
			ps.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void updateArticle(Article a) {
		int articleNO = a.getArticleNO();
		String title = a.getTitle();
		String content = a.getContent();
		String imgFileName = a.getImgFileName();
		try {
			conn = dataSource.getConnection();
			String sql = "UPDATE board set title=?,content=?";
			if (imgFileName != null && imgFileName.length() != 0) {
				sql += ",imgFileName=?";
			}
			sql += " where articleNO =?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, content);
			if (imgFileName != null && imgFileName.length() != 0) {
				ps.setString(3, imgFileName);
				ps.setInt(4, articleNO);
			} else {
				ps.setInt(3, articleNO);
			}
			int cnt = ps.executeUpdate();
			if(cnt > 0) {
				System.out.println("수정 성공");
			}
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Article viewArticle(int articleNO) {
		Article a = new Article();
		try {
			conn = dataSource.getConnection();
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	public List<Article> selectAllArticles(Map<String,String> pagingMap){
		List<Article> articles = new ArrayList<Article>();
		int section = Integer.parseInt(pagingMap.get("section"));
		int pageNum = Integer.parseInt(pagingMap.get("pageNum"));
		try {
			conn= dataSource.getConnection();
//			String sql = "SELECT * FROM "
//					+ "(SELECT ROWNUM as recNum,LVL,articleNO,parentNO,title,m_id,writedate"
//					+ " FROM "
//					+ "(SELECT LEVEL as LVL, articleNO, parentNO, title, m_id, writedate "
//					+ "FROM board "
//					+ "START WITH parentNO=0 "
//					+ "CONNECT BY PRIOR articleNO = parentNO "
//					+ "ORDER SIBLINGS BY articleNO DESC)"
//					+ ") WHERE recNum between (?-1)*100+(?-1)*10+1 and (?-1)*100+?*10";
			String sql="SELECT * FROM (SELECT ROWNUM as recNum,LVL,articleNO,parentNO,title,m_id,writedate FROM (SELECT LEVEL as LVL, articleNO, parentNO, title, m_id, writedate FROM board START WITH parentNO=0 CONNECT BY PRIOR articleNO = parentNO ORDER SIBLINGS BY articleNO DESC)) WHERE recNum between (?-1)*100+(?-1)*10+1 and (?-1)*100+?*10";
			//recNum between(?-1)*100+(?-1)*10+1 and (?-1)*100+?*10 은
			// section과 pageNum이 각각 1일때는 between 1~ 10
			ps = conn.prepareStatement(sql);
			ps.setInt(1, section);
			ps.setInt(2, pageNum);
			ps.setInt(3, section);
			ps.setInt(4, pageNum);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int level = rs.getInt("LVL");
				int articleNO = rs.getInt("articleNO");
				int parentNO = rs.getInt("parentNO");
				String title = rs.getString("title");
				String id = rs.getString("m_id");
				Date writeDate = rs.getDate("writedate");
				Article a = new Article(level, articleNO, parentNO, title, id, writeDate);
				System.out.println("a : "+a.toString());
				articles.add(a);
			}
			rs.close();
			ps.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return articles;
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
			conn = dataSource.getConnection();
			String sql = "SELECT max(articleNO) from board"; // 기본글 번호 중 가장 큰 번호 검색
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				// 가장 큰 번호에 1 더한 값 리턴
				return (rs.getInt(1) + 1);
			}
			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int addArticle(Article a) {
		int articleNO = getNewArticleNO(); // 새 글에 대한 번호 가져오기
		System.out.println("addArticle articleNO :" + articleNO);
		try {
			conn = dataSource.getConnection();
			a.setArticleNO(articleNO);
			int parentNO = a.getParentNO();
			String title = a.getTitle();
			String content = a.getContent();
			String id = a.getM_id();
			String imgFileName = a.getImgFileName();
			String sql = "INSERT INTO board VALUES(?,?,?,?,?,sysdate,?)";
			System.out.println("addArticle" + a.toString());
			ps = conn.prepareStatement(sql);
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return articleNO;
	}

}
