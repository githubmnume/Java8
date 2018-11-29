package cn.mnu.demo.bb.proxy;

import java.lang.reflect.Proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses=BbProxyApplication.class)
public class BbProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(BbProxyApplication.class, args);
	 PersonInterface aFather=	getInstance();
	 aFather.sayHello();
	 aFather.sayBye();
	
	//
	
	PersonInterface personInterface=(PersonInterface) Proxy.newProxyInstance(PersonInterface.class.getClassLoader(), new Class<?>[] {PersonInterface.class},
			new RealProxy(new Father()));
	personInterface.sayHello();
	
	
	System.out.println("--------------");
//	PersonInterface personInterface2=(PersonInterface) Proxy.newProxyInstance(PersonInterface.class.getClassLoader(), new Class<?>[] {PersonInterface.class},
//			new RealProxy(new Son(aFather)));
//	personInterface2.sayHello();
	}
	
	 public static PersonInterface getInstance(Class<PersonInterface> clazz ){   
		 if (clazz.getName().equals("Son")) {
			 return new Son(new Father());
		 }
		 if (clazz.getName().equals("Child")) {
			 return new Child(new Father());
		}
		 return null;
		 } 
	 public static PersonInterface getInstance(){   
		  return new Son(new Father());
		 }
}
