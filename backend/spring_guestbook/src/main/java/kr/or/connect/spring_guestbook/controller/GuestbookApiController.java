package kr.or.connect.spring_guestbook.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
	public Map<String,Object> list(@RequestParam(name="start",required = false,defaultValue = "0") int start){
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
