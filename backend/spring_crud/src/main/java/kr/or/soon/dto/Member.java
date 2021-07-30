package kr.or.soon.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Member {
	private String id;
	private String password;
	private String email;
	private String name;
	public Member() {
		
	}
	public Member(String id, String password, String email, String name) {
		super();
		this.id = id;
		this.password = password;
		this.email = email;
		this.name = name;
	}

}
