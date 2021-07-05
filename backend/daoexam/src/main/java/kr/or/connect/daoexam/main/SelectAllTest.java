package kr.or.connect.daoexam.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.daoexam.config.ApplicationConfig;
import kr.or.connect.daoexam.dao.RoleDAO;
import kr.or.connect.daoexam.dto.Role;

public class SelectAllTest {
public static void main(String[] args) {
	ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
	RoleDAO dao = ac.getBean(RoleDAO.class);
	List<Role> list = dao.selectAll();
	for(Role r : list) {
		System.out.println(r);
	}
}
}
