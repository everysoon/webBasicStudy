import java.util.List;

import kr.or.connect.jdbc.dao.RoleDAO;
import kr.or.connect.jdbc.dto.Role;

public class jdbcEx03 {
	public static void main(String[] args) {
		RoleDAO dao = new RoleDAO();
		List<Role> list = dao.getRoles();
		for(Role r : list) {
			System.out.println(r);
		}
	}
}
