package com.example.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Hellolombok {
	private String name;
	private int age;

	public static void main(String[] args) {
		Hellolombok hellolombok = new Hellolombok();
		System.out.println("helloLombok = " + hellolombok.toString());

	}
}
