package kr.or.soon.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalTest {
	public static void main(String[] args) {
		/** ApplicationContext의 경로 설정
		 * ClassPathXmlApplicationContext : classPath에있는 xml 읽음
		 * FileSystemXmlApplicationContext : 파일경로로 지정된 곳에서 xml읽음 (해당 소스가 src폴더에 있어야 가능)
		 */
		ApplicationContext context = new ClassPathXmlApplicationContext("aopTest.xml");
	
		Calculator cal = (Calculator) context.getBean("proxyCal");
		// 메소드 호출 전 후 에 어드바이스 빈이 적용 됨.
		cal.add(100, 20);
		cal.sub(100,20);
		cal.multi(100, 20);
		cal.div(100, 20);
	}
}
