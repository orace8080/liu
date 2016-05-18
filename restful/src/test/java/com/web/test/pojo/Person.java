package com.web.test.pojo;

public class Person {

	private String id;
	private String name;
	
	
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public static Person getPerson(String id,String name){
		Person p=new Person();
		p.id=id;
		p.name=name;
		return p;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
