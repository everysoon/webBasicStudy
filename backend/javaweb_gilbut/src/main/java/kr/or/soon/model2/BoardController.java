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
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

import kr.or.soon.dto.Article;

@WebServlet("/board/*")
public class BoardController extends HttpServlet {
//	private static String ARITICLE_IMAGE_REPO ="C:\\Users\\ict01-103\\Documents\\webBasicStudy\\backend\\javaweb_gilbut\\src\\main\\webapp\\WEB-INF\\img";
	private static String ARITICLE_IMAGE_REPO = "C:\\Users\\MINSUN\\Desktop\\myBasicWebStudy\\backend\\gilbut_board_img";
	private static final long serialVersionUID = 1L;
	BoardService service;
	Article article;

	@Override
	public void init() throws ServletException {
		service = new BoardService();
		article = new Article();
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
		HttpSession session;
		String action = request.getPathInfo();
		System.out.println("board Action : " + action);
		try {
			List<Article> list = new ArrayList<>();
			if (action == null || action.contains("/*")) {
				// ?????????
				String _section = request.getParameter("section");
				String _pageNum = request.getParameter("pageNum");
				// ?????? ????????? section??? page??? ??????????????? 1??? ?????????
				String section = (_section==null)? "1":_section;
				String pageNum = (_pageNum==null)? "1":_pageNum;
				Map<String,String> pagingMap = new HashMap<String, String>();
				pagingMap.put("section",section);
				pagingMap.put("pageNum", pageNum);
				Map articleMap = service.listArticles(pagingMap);
				articleMap.put("section",section);
				articleMap.put("pageNum", pageNum);
				request.setAttribute("articleMap", articleMap);
				
//				list = service.listArticles();
//				request.setAttribute("articles", list);
				nextPage = "/model2board/listArticles.jsp";
			} else if (action.equals("/listArticles.do")) {
				// ?????? ??? ??????
				String _section = request.getParameter("section");
				String _pageNum = request.getParameter("pageNum");
				String section = (_section==null)? "1": _section;
				String pageNum = (_pageNum==null)?"1":_pageNum;
				Map<String,String> pagingMap = new HashMap<String, String>();
				pagingMap.put("section", section);
				pagingMap.put("pageNum", pageNum);
				Map articleMap = service.listArticles(pagingMap);
				articleMap.put("section",section);
				articleMap.put("pageNum", pageNum);
				request.setAttribute("articleMap", articleMap);
//				list = service.listArticles(); // ?????? ??? ????????????
//				request.setAttribute("articles", list); // ????????? ??? articles??? ????????? ??? jsp??? ?????????
				nextPage = "/model2board/listArticles.jsp";
			} else if (action.equals("/articleForm.do")) {
				nextPage = "/model2board/articleForm.jsp";
			} else if (action.equals("/addArticle.do")) {
				int articleNO = 0;

				Map<String, String> articleMap = upload(request, response);
				String title = articleMap.get("title");
				String content = articleMap.get("content");
				String imgFileName = articleMap.get("imgFileName");
				System.out.println("addArticle imgFileName"+imgFileName);
				article.setParentNO(0); // ?????? ??? ?????? 0 ?????? ??????
				article.setM_id("soon");
				article.setTitle(title);
				article.setContent(content);
				article.setImgFileName(imgFileName);
				articleNO = service.addArticle(article); // ??? ?????? ????????? ??? ??? ??? ?????? ????????????
				System.out.println("addArticle controller articleNO :" + articleNO);

				if (imgFileName != null && imgFileName.length() != 0) {
					// ????????? ???????????????
					// temp ????????? ????????? ????????? ??? ?????? ????????? ??????
					File srcFile = new File(ARITICLE_IMAGE_REPO + "\\" + "temp" + "\\" + imgFileName);
					File destDir = new File(ARITICLE_IMAGE_REPO + "\\" + articleNO);
					destDir.mkdirs();
					// temp ?????? ????????? ??? ????????? ???????????? ?????? ????????? ??????
					FileUtils.moveFileToDirectory(srcFile, destDir, true);
				}
				PrintWriter pw = response.getWriter();
				pw.print("<script> alert('??? ?????? ??????????????????.'); location.href='/board/listArticles.do';</script>");
//				nextPage="/board/listArticles.do";
				return;

			} else if (action.equals("/viewArticle.do")) {
				String articleNO = request.getParameter("articleNO");
				article = service.viewArticle(Integer.parseInt(articleNO));
				request.setAttribute("article", article);
				nextPage = "/model2board/viewArticle.jsp";
			}else if(action.equals("/modArticle.do")) {
				Map<String,String> map = upload(request, response);
				int articleNO =Integer.parseInt(map.get("articleNO"));
				String title = map.get("title");
				String content = map.get("content");
				String imgFileName = map.get("imgFileName");
				article.setArticleNO(articleNO);
				article.setParentNO(0);
				article.setM_id("soon");
				article.setTitle(title);
				article.setContent(content);
				article.setImgFileName(imgFileName);
				service.modArticle(article);
				if(imgFileName!=null && imgFileName.length()!=0) {
					String originFileName = map.get("originalFileName");
					File srcFile = new File(ARITICLE_IMAGE_REPO+"\\temp\\"+imgFileName);
					File destDir = new File(ARITICLE_IMAGE_REPO+"\\"+articleNO);
					destDir.mkdirs();
					FileUtils.moveFileToDirectory(srcFile, destDir, true);
					File oldFile =new File(ARITICLE_IMAGE_REPO+"\\"+articleNO+"\\"+originFileName);
					oldFile.delete();
				}
				PrintWriter pw = response.getWriter();
				pw.print("<script>alert('?????? ???????????????'); location.href='/board/viewArticle.do?articleNO="+articleNO+"';</script>");
				return ;
			}else if(action.equals("/removeArticle.do")) {
				int articleNO = Integer.parseInt(request.getParameter("articleNO"));
				List<Integer> articleNOList = service.removeArticle(articleNO);
				for(int a: articleNOList) {
					File imgDir = new File(ARITICLE_IMAGE_REPO+"\\"+a);
					if(imgDir.exists()) {
						// ??????????????? ?????????
						FileUtils.deleteDirectory(imgDir);
					}
				}
				PrintWriter pw = response.getWriter();
				pw.print("<script>alert('?????? ???????????????'); location.href='/board/listArticles.do';</script>");
				return;
			}else if(action.equals("/replyForm.do")) {
				int parentNO = Integer.parseInt(request.getParameter("parentNO"));
				session = request.getSession();
				session.setAttribute("parentNO", parentNO);
				nextPage="/model2board/replyForm.jsp";
			}else if(action.equals("/addReply.do")) {
				session = request.getSession();
				int parentNO = (Integer) session.getAttribute("parentNO");
				session.removeAttribute("parentNO");
				Map<String,String> map = upload(request, response);
				String title = map.get("title");
				String content = map.get("content");
				String imgFileName = map.get("imgFileName");
				article.setParentNO(parentNO);
				article.setM_id("soon");
				article.setTitle(title);
				article.setContent(content);
				article.setImgFileName(imgFileName);
				int articleNO = service.addReply(article);
				if(imgFileName!=null && imgFileName.length()!=0) {
					File srcFile = new File(ARITICLE_IMAGE_REPO+"\\temp\\"+imgFileName);
					File destDir =new File(ARITICLE_IMAGE_REPO+"\\"+articleNO);
					destDir.mkdirs();
					FileUtils.moveFileToDirectory(srcFile, destDir,true);
				}
				PrintWriter pw = response.getWriter();
				pw.print("<script>alert('?????? ?????? ??????!');location.href='/board/viewArticle.do?articleNO="+articleNO+"';</script>");
				return;
				
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Map<String, String> upload(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String> map = new HashMap<>();
		String encoding = "utf-8";
		File currentDirPath = new File(ARITICLE_IMAGE_REPO); // ??? ????????? ?????? ????????? ?????? ?????? ??????
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath);
		factory.setSizeThreshold(1024 * 1024);
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List items = upload.parseRequest(request);
			for (int i = 0; i < items.size(); i++) {
				FileItem item = (FileItem) items.get(i); // FileItem??? byte????????? ??????
				if (item.isFormField()) {
					// isFormField : ?????? ?????????????????? ????????? ?????? ????????? ?????? true??????
					// getString??? ?????? ??????????????? ?????? ????????? ?????? ?????? : ?????? encoding?????? ????????? ??? ??????
					// getFiledName??? ???????????? ?????? (input????????? name?????? ??? ??????)
					System.out.println(item.getFieldName() + "=" + item.getString(encoding));
					// ?????? ???????????? ?????? ????????? ??? ??? ?????? ???????????????
					// map??? ???,value??? ????????? ??? ????????????,
					// ??? ????????? title??? content??? map??? ??????
					map.put(item.getFieldName(), item.getString(encoding));

				} else {
					System.out.println("?????????????????? : " + item.getFieldName());
					System.out.println("?????? ?????? : " + item.getName());
					System.out.println("?????? ?????? : " + item.getSize() + "bytes");
					if (item.getSize() > 0) {
						int idx = item.getName().lastIndexOf("\\");
						if (idx == -1) {
							idx = item.getName().lastIndexOf("/");
						}
						String fileName = item.getName().substring(idx + 1);
						File uploadFile = new File(currentDirPath + "\\temp\\" + fileName); // temp????????? ?????????
						item.write(uploadFile);
						map.put(item.getFieldName(), fileName); // ???????????? ????????? ??????????????? map??? ("imgFileName","????????? ????????????")?????? ??????
//						// ????????? ????????? ????????? ?????? ????????? ????????? ?????????????????? ???????????? ?????????
//						File uploadFile = new File(currentDirPath+"\\"+fileName);
//						item.write(uploadFile);
					} // end if
				} // end if
			} // end for
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
