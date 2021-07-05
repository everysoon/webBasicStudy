import java.awt.Robot;

import kr.or.connect.jdbc.dao.RoleDAO;
import kr.or.connect.jdbc.dto.Role;

public class jdbcEx02 {
	public static void main(String []args) {
//		int roleId = 2;
//		String description = "CTO";
//		Role role = new Role(roleId,description);
		RoleDAO dao = new RoleDAO();
//		int insertCnt = dao.addRole(role);
//		System.out.println(insertCnt);
		Role role = dao.getRole(2);
		System.out.println(role);
		
	}
}
