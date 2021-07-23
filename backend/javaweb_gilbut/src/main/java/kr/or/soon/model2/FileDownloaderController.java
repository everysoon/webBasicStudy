package kr.or.soon.model2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/download.do")
public class FileDownloaderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private static String ARITICLE_IMAGE_REPO ="C:\\Users\\ict01-103\\Documents\\webBasicStudy\\backend\\javaweb_gilbut\\src\\main\\webapp\\WEB-INF\\img";
	private static String ARITICLE_IMAGE_REPO = "C:\\Users\\MINSUN\\Desktop\\myBasicWebStudy\\backend\\gilbut_board_img";
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String imgFileName = (String)request.getParameter("imgFileName");
		String articleNO = request.getParameter("articleNO");
		System.out.println("fileDownloader 속 imgFileName : "+imgFileName);
		OutputStream out = response.getOutputStream();
		// 글 번호에 대한 경로 설정
		String path = ARITICLE_IMAGE_REPO+"\\"+articleNO+"\\"+imgFileName;
		File imgFile = new File(path);
		response.setHeader("Cache-Control", "no-cache");
		// 파일을 내려받는데 필요한 response Header 설정
		response.addHeader("Content-disposition", "attachment;fileName="+imgFileName);
		FileInputStream in = new FileInputStream(imgFile);
		// 버퍼를 이용해 한번에 8Kb씩 전송
		byte[] buffer = new byte[1024*8];
		while(true) {
			int cnt = in.read(buffer);
			if(cnt == -1) {
				break;
			}
			out.write(buffer,0,cnt);
		}
		in.close();
		out.close();
		
	}

}
