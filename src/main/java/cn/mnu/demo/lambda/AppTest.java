package cn.mnu.demo.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AppTest {
	
	public static void main(String[] args) {
		convertTest();
//		optionalName();
	}
	public static void convertTest() {
	    List<String> collected = new ArrayList<>();
	    collected.add("alpha");
	    collected.add("beta");
	    collected.add("lumbda");
	    collected = collected.stream().map(string -> string.toUpperCase()).collect(Collectors.toList());
	    
	    System.out.println(collected);
	    collected= collected.parallelStream().map(String::toLowerCase).collect(Collectors.toCollection(ArrayList::new));
	    System.out.println(collected);
	}
	public static void optionalName() {
		Optional< String > fullName = Optional.ofNullable( "null" );
		System.out.println( "Full Name is set? " + (fullName.isPresent()==true?"Yes":"No" ));        
		System.out.println( "Full Name: " + fullName.orElseGet( () -> "[none]" ) ); 
		System.out.println( fullName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );
	}


}
