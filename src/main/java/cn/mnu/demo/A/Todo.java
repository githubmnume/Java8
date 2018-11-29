package cn.mnu.demo.A;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Todo {
	public enum Priority {LOW, MEDIUM, HIGH}
	public enum Status {STARTED, ASSIGNED,FINISHED}
	String author() default "zhouf";
	Priority priority() default Priority.LOW;
	Status status() default Status.ASSIGNED;
}
