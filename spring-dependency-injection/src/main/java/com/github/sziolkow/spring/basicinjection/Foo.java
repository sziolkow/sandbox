package com.github.sziolkow.spring.basicinjection;

public class Foo {

	private String name;

	public Foo() {
	}

	public Foo(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
