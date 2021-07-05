package kr.or.connect.spring_guestbook.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.spring_guestbook.config.ApplicationConfig;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		/*
		 * GuestbookDao dao = ac.getBean(GuestbookDao.class); Guestbook guestbook = new
		 * Guestbook(); guestbook.setName("soon");
		 * guestbook.setContent(" insert Test!"); guestbook.setRegdate(new Date()); Long
		 * id = dao.insert(guestbook); System.out.println("id :"+id);
		 */
		/*
		 * LogDao dao = ac.getBean(LogDao.class); Log log = new Log();
		 * log.setIp("127.0.0.1"); log.setMethod("insert"); log.setRegdate(new Date());
		 * dao.insert(log);
		 */
		
		UserDao dao = ac.getBean(UserDao.class);
		
//		 User user = new User(); user.setId("soon"); 
//		 user.setPassword("alstjsl1");
//		  Long idx = dao.insert(user);
		
//		Map<String,String> map = dao.selectById(Long.valueOf("2"));
//		System.out.println("id  : "+map.get("id"));
//		System.out.println("password  : "+map.get("password"));
//		boolean login = dao.login("soon","alstjsl1");
//		System.out.println("login ok ?" + login);
	}
}
