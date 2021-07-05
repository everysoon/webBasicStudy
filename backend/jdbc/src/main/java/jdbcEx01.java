import kr.or.connect.jdbc.dao.RoleDAO;
import kr.or.connect.jdbc.dto.Role;

public class jdbcEx01 {
	public static void main(String[] args) {
		RoleDAO dao = new RoleDAO();
		Role role = dao.getRole(1);
		System.out.println(role);
	}
}
