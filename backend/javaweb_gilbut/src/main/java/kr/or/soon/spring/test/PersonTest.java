package kr.or.soon.spring.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import kr.or.soon.spring.PersonService;

public class PersonTest {
	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("C:\\Users\\MINSUN\\Desktop\\myBasicWebStudy\\backend\\javaweb_gilbut\\src\\main\\webapp\\xml\\person.xml"));
		PersonService service = (PersonService) factory.getBean("personServiceConstructor");
		service.sayHello();
	}
}
