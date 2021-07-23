package kr.or.soon.model2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.soon.dao.BoardDAO;
import kr.or.soon.dto.Article;

public class BoardService {
	BoardDAO dao ;
	public BoardService() {
		dao = new BoardDAO();
	}
	public Map listArticles(Map<String,String> pagingMap){
		Map articleMap = new HashMap<String, String>();
		List<Article> articles = dao.selectAllArticles(pagingMap);
		System.out.println("listArticles : "+articles.toString());
		int total = dao.selectTotalArticles();
		articleMap.put("articles", articles); // 조회된 글 목록
		articleMap.put("total", total); // 전체 글 수 저장
		return articleMap;
	}
	public List<Article> listArticles(){
		List<Article> articles = dao.selectAllArticles();
		return articles;
	}
	public int addArticle(Article a) {
		return dao.addArticle(a);
	
	}
	public Article viewArticle(int articleNO) {
		Article a = null;
		a = dao.viewArticle(articleNO);
		return a;
	}
	public void modArticle(Article a) {
		dao.updateArticle(a);
	}
	public List<Integer> removeArticle(int articleNO){
		List<Integer> list = dao.selectRemovedArticles(articleNO);
		dao.deleteArticle(articleNO);
		return list;
		
	}
	public int addReply(Article a) {
	return dao.addArticle(a); // 새 글 추가시 사용한 addArticle 활용하기
	}
}
