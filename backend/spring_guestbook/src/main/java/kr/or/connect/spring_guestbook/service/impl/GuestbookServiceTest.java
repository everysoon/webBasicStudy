package kr.or.connect.spring_guestbook.service.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.spring_guestbook.config.ApplicationConfig;
import kr.or.connect.spring_guestbook.service.GuestbookService;

public class GuestbookServiceTest {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		GuestbookService service = ac.getBean(GuestbookService.class);
//		
//		Guestbook g = new Guestbook();
//		g.setName("soon");
//		g.setContent("Service Test!");
//		g.setRegdate(new Date());
//		Guestbook result = service.addGuestbook(g, "127.0.0.1");
		
		System.out.println(String.valueOf(service.getCount()));
	}
}
