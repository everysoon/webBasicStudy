package kr.or.soon.model2;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

import kr.or.soon.dto.Article;

@WebServlet("/board/*")
public class BoardController extends HttpServlet {
	private static String ARITICLE_IMAGE_REPO ="C:\\Users\\ict01-103\\Documents\\webBasicStudy\\backend\\javaweb_gilbut\\src\\main\\webapp\\WEB-INF\\img";
	private static final long serialVersionUID = 1L;
	BoardService service;
	Article article;

	@Override
	public void init() throws ServletException {
		service = new BoardService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nextPage = null;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getPathInfo();
		System.out.println("board Action : "+action);
		try {
			List<Article> list =new ArrayList<>();
			if(action== null || action.contains("/*")) {
				list =service.listArticles();
				request.setAttribute("articles", list);
				nextPage ="/model2board/listArticles.jsp";
			}else if(action.equals("/listArticles.do")) {
				// 전체 글 조회
				list = service.listArticles(); // 전체 글 받아오기
				request.setAttribute("articles", list); //조회된 글 articles로 바인딩 후 jsp로 포워딩
				nextPage="/model2board/listArticles.jsp";
			}else if(action.equals("/articleForm.do")) {
				nextPage ="/model2board/articleForm.jsp";
			}else if(action.equals("/addArticle.do")) {
				int articleNO = 0;
			
				Map<String,String> articleMap =upload(request,response);
				String title = articleMap.get("title");
				String content = articleMap.get("content");
				String imgFileName= articleMap.get("imgFileName");
				article = new Article();
				article.setParentNO(0); // 부모 글 번호 0 으로 저장
				article.setM_id("soon");
				article.setTitle(title);
				article.setContent(content);
				article.setImgFileName(imgFileName);
				articleNO = service.addArticle(article); // 새 글을 추가한 후 새 글 번호 가져오기
				if(imgFileName!=null && imgFileName.length()!=0) {
					// 파일을 첨부했다면 
					//temp 폴더에 임시로 업로드 된 파일 객체를 생성
					File srcFile =new File(ARITICLE_IMAGE_REPO+"\\"+"temp"+"\\"+imgFileName);
					File destDir = new File (ARITICLE_IMAGE_REPO+"\\"+articleNO);
					destDir.mkdirs();
					// temp 폴더 파일을 글 번호를 이름으로 하는 폴더로 이동
					FileUtils.moveFileToDirectory(srcFile, destDir, true);
				}
				PrintWriter pw = response.getWriter();
				pw.print("<script> alert('새 글을 추가했습니다.'); location.href='/board/listArticles.do';</script>");
//				nextPage="/board/listArticles.do";
				return ;
			}else if(action.equals("/viewArticle.do")) {
				String articleNO = request.getParameter("articleNO");
				article = service.viewArticle(Integer.parseInt(articleNO));
				request.setAttribute("article", article);
				nextPage = "/model2board/viewArticle.jsp";
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
			dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private Map<String,String> upload(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		Map<String,String> map = new HashMap<>();
		String encoding="utf-8";
		File currentDirPath = new File(ARITICLE_IMAGE_REPO);
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath);
		factory.setSizeThreshold(1024*1024);
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List items = upload.parseRequest(request);
			for(int i=0; i<items.size(); i++) {
				FileItem item = (FileItem) items.get(i); // FileItem을 byte배열로 반환
				if(item.isFormField()) {
					//일반 파라미터인지 여부를 반환 일반일 경우 true반환
					// getString은 기본 문자셋으로 파일 아이템 내용 반환 : 안에 encoding형태 넣어줄 수 있음
					// getFiledName은 필드이름 반환 (input태그의 name속성 값 반환)
					System.out.println(item.getFieldName()+"="+item.getString(encoding));
					//파일 업로드로 같이 전송된 새 글 관련 매개변수를
					// map에 키,value로 저장한 후 반환하고,
					// 새 글관련 title과 content를ㄹ map에 저장
					map.put(item.getFieldName(), item.getString(encoding));
					
				}else {
					System.out.println("파라미터이름 : "+item.getFieldName());
					System.out.println("파일 이름 : "+item.getName());
					System.out.println("파일 크기 : "+item.getSize()+"bytes");
					if(item.getSize()>0) {
						int idx = item.getName().lastIndexOf("\\");
						if(idx == -1) {
							idx = item.getName().lastIndexOf("/");
						}
						String fileName = item.getName().substring(idx+1);
						File uploadFile = new File(currentDirPath+"\\temp\\"+fileName); // temp폴더에 업로드
						item.write(uploadFile);
//						map.put(item.getFieldName(), fileName); // 업로드된 파일의 파일이름을 map에 ("imgFileName","업로드 파일이름")으로 저장
//						// 업로드 파일이 존재할 경우 업로드 파일의 파일이름으로 저장소에 업로드
//						File uploadFile = new File(currentDirPath+"\\"+fileName);
//						item.write(uploadFile);
					} //end if
				} // end if 
			}// end for
		}catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
