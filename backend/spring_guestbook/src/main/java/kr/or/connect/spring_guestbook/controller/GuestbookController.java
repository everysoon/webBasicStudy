package kr.or.connect.spring_guestbook.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.connect.guestbook.argumentresolver.HeaderInfo;
import kr.or.connect.spring_guestbook.dto.Guestbook;
import kr.or.connect.spring_guestbook.service.GuestbookService;

@Controller
public class GuestbookController {
	@Autowired
	GuestbookService service;

	@GetMapping(path = "/list")
	public String list(@RequestParam(name = "start", required = false,
	defaultValue = "0") int start, ModelMap model,
			@CookieValue(value="count",defaultValue="0",required =true) String value,HttpServletResponse response,
			HeaderInfo headerInfo) {
		System.out.println("-----------------------------------");
		System.out.println(headerInfo.get("user-agent"));
		System.out.println("-----------------------------------");
		// 쿠키 이용해서 방문자 수 알아내기
		// 쿠키는 String value를 가지기때문에 value를 String으로!
		// Cookie가 없으면 null 반환!
		// 아래 예제는 HttpServletRequest를 사용해서 쿠키 받아내기,
		// 우리는 이제 @CookieValue어노테이션을 통해 쿠키설정할거양
//		String value = null;
//		boolean find = false;
//		Cookie[] cookies = request.getCookies();
//		if(cookies!=null) {
//			for(Cookie c : cookies) {
//				if("count".equals(c.getName())) {
//					find= true;
//					value = c.getValue(); 
//					break;
//				}
//			}
//		}
//		if(!find) {
//			value = "1";
//		}else {
//			// 쿠키를 찾았다면 
//			try {
//				int i = Integer.parseInt(value);
//				System.out.println("i  : "+i );
//				value = Integer.toString(++i);
//				System.out.println("value : "+value );
//			}catch(Exception e) {
//				e.printStackTrace();
//				value = "1";
//			}
//		}
//		// 값을 가지고 쿠키 생성
//		Cookie cookie = new Cookie("count",value);
//		cookie.setMaxAge(60*60*24*365); // 1년동안 유지!
//		cookie.setPath("/"); // 경로 이하에 모두 쿠키 적용
//		response.addCookie(cookie);
		
		
		// 아래는 @CookieValue사용하는 예제
		try {
			int i= Integer.parseInt(value);
			value = String.valueOf(++i);
		}catch(Exception e) {
			value="1";
		}
		
		// start로 시작하는 방명록 목록 구하기
		List<Guestbook> list = service.getGuestbooks(start);
		// 전체 페이지 수 구하기
		int count = service.getCount();
		int pageCount = count / GuestbookService.LIMIT;
		if (count % GuestbookService.LIMIT > 0) {
			pageCount++;
		}
		// 페이지 수만큼 start의 값을 리스트로 저장
		// 예를들면 페이지 수가 3이면 0,5,10 이렇게 저장
		// list?start=0,list?start=5,list?start=10 으로 링크가 걸린다.
		List<Integer> pageStartList = new ArrayList<>();
		for (int i = 0; i < pageCount; i++) {
			pageStartList.add(i * GuestbookService.LIMIT);
		}
		model.addAttribute("list", list);
		model.addAttribute("count", count);
		model.addAttribute("pageStartList", pageStartList);
		model.addAttribute("cookieCount", value);
		return "list";
	}
	@PostMapping(path="/write")
	public String write(@ModelAttribute Guestbook guestbook,
			HttpServletRequest request) {
		String clientIp = request.getRemoteAddr();
		System.out.println(clientIp);
		service.addGuestbook(guestbook, clientIp);
		return "redirect:list";
	}
	//url은 GET매핑
	@GetMapping(path="delete")
	public String delete(@RequestParam(name="id",required = true) Long id,
			@SessionAttribute("isAdmin") String isAdmin,
			HttpServletRequest request,
			RedirectAttributes redirectAttr) {
		if(isAdmin== null || !"true".equals(isAdmin)){
			redirectAttr.addFlashAttribute("errorMessage","로그인을 하지않앗슴다");
			return "redirect:loginform";
			
		}
		String clientIp = request.getRemoteAddr();
		service.deleteGuestbook(id, clientIp);
		return "redirect:list";
	}
	
}
