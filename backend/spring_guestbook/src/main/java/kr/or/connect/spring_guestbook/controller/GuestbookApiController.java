package kr.or.connect.spring_guestbook.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.spring_guestbook.dto.Guestbook;
import kr.or.connect.spring_guestbook.service.GuestbookService;

// RestController
@RestController
@RequestMapping(path="/guestbooks")
public class GuestbookApiController {
	@Autowired
	GuestbookService service;
	
	// RequestMapping에 path 적어줘서 GetMapping에 안적어줘도됨!
	@GetMapping
	public Map<String,Object> list(@RequestParam(name="start",required = false,defaultValue = "0") int start,
			HttpServletRequest request,HttpServletResponse response){
		// 쿠키 이용해서 방문자 수 알아내기
				// 쿠키는 String value를 가지기때문에 value를 String으로!
				// Cookie가 없으면 null 반환!
				String value = null;
				boolean find = false;
				Cookie[] cookies = request.getCookies();
				if(cookies!=null) {
					for(Cookie c : cookies) {
						if("count".equals(c.getName())) {
							find= true;
							value = c.getValue(); 
							break;
						}
					}
				}
				if(!find) {
					value = "1";
				}else {
					// 쿠키를 찾았다면 
					try {
						int i = Integer.parseInt(value);
						System.out.println("i  : "+i );
						value = Integer.toString(++i);
						System.out.println("value : "+value );
					}catch(Exception e) {
						e.printStackTrace();
						value = "1";
					}
				}
				// 값을 가지고 쿠키 생성
				Cookie cookie = new Cookie("count",value);
				cookie.setMaxAge(60*60*24*365); // 1년동안 유지!
				cookie.setPath("/"); // 경로 이하에 모두 쿠키 적용
				response.addCookie(cookie);
				
		List<Guestbook> list = service.getGuestbooks(start);
		int count = service.getCount();
		int pageCount = count/GuestbookService.LIMIT;
		if(count% GuestbookService.LIMIT>0) {
			pageCount++;
		}
		List<Integer> pageStartList = new ArrayList<>();
		for(int i=0; i<pageCount; i++) {
			pageStartList.add(i*GuestbookService.LIMIT);
		}
		Map<String,Object> map = new HashMap<>();
		map.put("list", list);
		map.put("count", count);
		map.put("pageStartList", pageStartList);
		map.put("cookieCount", value);
		// 해당 map객체를 json객체로 변환해서 return 
		return map;
	}
	@PostMapping
	public Guestbook write(@RequestBody Guestbook guestbook,
			HttpServletRequest request) {
		String clientIp = request.getRemoteAddr();
		Guestbook result = service.addGuestbook(guestbook, clientIp);
		return result;
	}
	@DeleteMapping("/{id}")
	public Map<String,String> delete(@PathVariable(name="id") Long id,
			HttpServletRequest request){
		String clientIp = request.getRemoteAddr();
		int deleteCount = service.deleteGuestbook(id, clientIp);
		
		return Collections.singletonMap("success", deleteCount>0? "true" : "false");
	}
}
