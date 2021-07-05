package kr.or.connect.jdbc.dto;

public class Person {
	private String idx;
	private String id;
	private String pw;
	private String name;
	private String age;
	private String addr;
	private String reg;

	public Person() {

	}

	public Person(String idx, String id, String pw, String name, String age, String addr, String reg) {
		super();
		this.idx = idx;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.age = age;
		this.addr = addr;
		this.reg = reg;
	}

	public String getIdx() {
		return idx;
	}

	public void setIdx(String idx) {
		this.idx = idx;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getReg() {
		return reg;
	}

	public void setReg(String reg) {
		this.reg = reg;
	}

	@Override
	public String toString() {
		return "Person [idx=" + idx + ", id=" + id + ", pw=" + pw + ", name=" + name + ", age=" + age + ", addr=" + addr
				+ ", reg=" + reg + "]";
	}
}
