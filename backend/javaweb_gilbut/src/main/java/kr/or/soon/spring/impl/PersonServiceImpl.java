package kr.or.soon.spring.impl;

import kr.or.soon.spring.PersonService;

public class PersonServiceImpl implements PersonService{
	private String name;
	private int age;
	
	public PersonServiceImpl(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println("안뇽 나는 "+age+"살 "+name+"이양" );
	}

}
