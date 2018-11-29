package cn.mnu.demo.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public  class Person implements Comparable<Person>{
	public int id;
	public String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int compareTo(Person o) {
		
		return o.id-this.id>0?o.id-this.id:0;
	}
	//匿名内部类
	public static final Comparator<Person>  nameComparator=new Comparator<Person>() {

		@Override
		public int compare(Person o1, Person o2) {
			
			return o1.getName().trim().compareTo(o2.getName().trim());
		}
	};
	
	public static final Comparator<Person>  nameComparator1=(Person o1, Person o2)->{return o1.getName().trim().compareTo(o2.getName().trim());};
	
	
	LambdaInterface<Person> lambdaInterface=new LambdaInterface<Person>() {

		@Override
		public int compare1(Person t1, Person t2) {
			return t1.getName().trim().compareTo(t2.getName().trim());
		}
	};
	public static final LambdaInterface<Person> lambdaInterface1=(Person o1, Person o2)->{return o1.getName().trim().compareTo(o2.getName().trim());};
	
	
	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return String.format("Person [id=%s, name=%s]", id, name);
	}
	
	//匿名内部类
//	public static final Comparator<Person>  nameComparator1(Person o1, Person o2)->  o1.getName().trim().compareTo(o2.getName().trim());
	/*
	 * basic:
	 * (params) -> expression
	 * (params) -> statement
	 * (params) -> { statements }
	 */
	/*public static void name(Person o1, Person o2) {
		
		 nameComparatorLambda(o1, o2) -> return o1.getName().trim().compareTo(o2.getName().trim());
	}*/
	
	}
