package cn.mnu.demo.lambda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

import javax.swing.JButton;

public class App {
	/*
	 * basic:
	 * (params) -> expression
	 * (params) -> statement
	 * (params) -> { statements }
	 */
	public static void main(String[] args) {
		
//		eventLambda();
		
//		basicLambda();
//		lambdaInteractor();
//		lambda2();
		
//		Collectors 
		Random seed = new Random();
		Supplier<Integer> random = seed::nextInt;
		Stream.generate(random).limit(10).forEach(System.out::println);
		// 1. Individual values
//		Stream stream = Stream.of("a", "b", "c");
		
	}
	private static void basicLambda() {
		//Java8
		new Thread( () -> System.out.println("In Java8, Lambda expression rocks !!") ).start();
		
		
		// Java 8之前：
		new Thread(new Runnable() {
		    @Override
		    public void run() {
		    System.out.println("Before Java8, too much code for too little to do");
		    }
		}).start();
	}
	private static void eventLambda() {
		// Java 8之前：
		JButton show =  new JButton("Show");
		show.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    System.out.println("Event handling without lambda expression is boring");
		    }
		});
		// Java 8方式：
		show.addActionListener((e) -> {
		    System.out.println("Light, Camera, Action !! Lambda expressions Rocks");
		});
		
	}
	public static void lambdaInteractor() {
		// Java 8之前：
		List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
		for (String feature : features) {
		    System.out.println(feature);
		}
		// Java 8之后：
		features.forEach(n -> System.out.println(n));
		 
		// 使用Java 8的方法引用更方便，方法引用由::双冒号操作符标示，
		// 看起来像C++的作用域解析运算符
		features.forEach(System.out::println);
		
		
		
		List<Person> list=new ArrayList<>();
		list.add(new Person(1,"ab"));
		list.add(new Person(2,"ac"));
		list.add(new Person(3,"ad"));
		list.add(new Person(4,"aa"));
		list.sort(Person.nameComparator1);
		list.forEach(n ->System.out.println(n.toString()));
	}
	public static void lambda2() {
		List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
//		languages.forEach(System.out::println);
		languages.stream().forEach(System.out::println);
//		count = strings.stream().filter(string->string.isEmpty()).count();
//		languages.stream().filter(language->language.trim().length()>0).count();
//		System.out.println(languages.stream().filter(a->a.trim().length()>4).count());
		System.out.println(languages.stream().filter(a->a.trim().length()>4).count());
	}
}
