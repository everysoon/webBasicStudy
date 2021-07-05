package kr.or.connect.daoexam.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.daoexam.config.ApplicationConfig;
import kr.or.connect.daoexam.dao.RoleDAO;
import kr.or.connect.daoexam.dto.Role;

public class InsertTest {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		RoleDAO dao = ac.getBean(RoleDAO.class);
		
		Role r= new Role();
		r.setRoleId(2);
		r.setDescription("CEO");
		int result = dao.insert(r);
		if(result>0) {
			System.out.println(result+"건 입력!");
		}
	}
	
}
