package kr.or.soon.dto;

import java.util.Date;

public class Article {
	private int articleNO, parentNO;
	private String title, content, imgFileName, m_id;
	private Date writedate;
	int level;
	public Article() {

	}

	public Article(int articleNO, int parentNO, String title, String content, String imgFileName, Date writedate,
			int level) {
		super();
		this.articleNO = articleNO;
		this.parentNO = parentNO;
		this.title = title;
		this.content = content;
		this.imgFileName = imgFileName;
		this.writedate = writedate;
		this.level = level;
	}

	public Article(int level,int articleNO, int parentNO, String title, String content,  String m_id,
			Date writedate) {

		this.level = level;
		this.articleNO = articleNO;
		this.parentNO = parentNO;
		this.title = title;
		this.content = content;
		this.m_id = m_id;
		this.writedate = writedate;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getArticleNO() {
		return articleNO;
	}

	public void setArticleNO(int articleNO) {
		this.articleNO = articleNO;
	}

	public int getParentNO() {
		return parentNO;
	}

	public void setParentNO(int parentNO) {
		this.parentNO = parentNO;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImgFileName() {
		return imgFileName;
	}

	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}

	public Date getWritedate() {
		return writedate;
	}

	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	@Override
	public String toString() {
		return "Article [articleNO=" + articleNO + ", parentNO=" + parentNO + ", title=" + title + ", content="
				+ content + ", imgFileName=" + imgFileName + ", m_id=" + m_id + ", writedate=" + writedate + ", level="
				+ level + "]";
	}
	

}
