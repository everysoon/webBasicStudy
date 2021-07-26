package kr.or.soon.dto;

public class Member {
	private String m_id, m_pwd, m_name, m_email, m_regDate;

	public Member() {

	}

	public Member(String m_id, String m_pwd, String m_name, String m_email) {
		this.m_id = m_id;
		this.m_pwd = m_pwd;
		this.m_name = m_name;
		this.m_email = m_email;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_pwd() {
		return m_pwd;
	}

	public void setM_pwd(String m_pwd) {
		this.m_pwd = m_pwd;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public String getM_regDate() {
		return m_regDate;
	}

	public void setM_regDate(String m_regDate) {
		this.m_regDate = m_regDate;
	}

	@Override
	public String toString() {
		return "Member [ m_id=" + m_id + ", m_pwd=" + m_pwd + ", m_name=" + m_name + ", m_email="
				+ m_email + ", m_regDate=" + m_regDate + "]";
	}

}
