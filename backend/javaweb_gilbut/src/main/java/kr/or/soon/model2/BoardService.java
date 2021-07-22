package kr.or.soon.model2;

import java.util.List;

import kr.or.soon.dao.BoardDAO;
import kr.or.soon.dto.Article;

public class BoardService {
	BoardDAO dao ;
	public BoardService() {
		dao = new BoardDAO();
	}
	public List<Article> listArticles(){
		List<Article> articles = dao.selectAllArticles();
		return articles;
	}
	public int addArticle(Article a) {
		int cnt = dao.addArticle(a);
		return cnt;
	}
	public Article viewArticle(int articleNO) {
		Article a = null;
		a = dao.viewArticle(articleNO);
		return a;
	}
}
