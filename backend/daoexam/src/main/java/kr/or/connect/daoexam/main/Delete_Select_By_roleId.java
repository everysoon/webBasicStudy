package kr.or.connect.daoexam.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.daoexam.config.ApplicationConfig;
import kr.or.connect.daoexam.dao.RoleDAO;
import kr.or.connect.daoexam.dto.Role;

public class Delete_Select_By_roleId {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		RoleDAO dao = ac.getBean(RoleDAO.class);
		// Select by role id
		Role r = dao.select(2);
		if(r != null) {
			System.out.println("select 성공!");
			System.out.println(r);	
		}
		// delete by role id
		int result = dao.delete(2);
		if(result>0) {
			System.out.println(result +" 건 삭제 완료!");
		}
		
	}
}
