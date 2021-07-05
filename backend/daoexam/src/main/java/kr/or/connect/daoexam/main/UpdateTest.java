package kr.or.connect.daoexam.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.daoexam.config.ApplicationConfig;
import kr.or.connect.daoexam.dao.RoleDAO;
import kr.or.connect.daoexam.dto.Role;

public class UpdateTest {
public static void main(String[] args) {
	ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
	RoleDAO dao = ac.getBean(RoleDAO.class);
	Role role = new Role();
	role.setRoleId(2);
	role.setDescription("Programmer");
	int result = dao.update(role);
	if(result>0) {
		System.out.println(result +" 건을 업데이트하였습니다.");		
	}
}
}
