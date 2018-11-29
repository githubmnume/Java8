package cn.mnu.demo.bb.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class MyMethodInterceptor implements MethodInterceptor {

	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		System.out.println("MyMethodInterceptor intercept");
		return arg3.invokeSuper(arg0, arg2);
	}
	
	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(HelloConcrete.class);
		enhancer.setCallback(new MyMethodInterceptor());
		 
		HelloConcrete hello = (HelloConcrete)enhancer.create();
		System.out.println(hello.sayHello("I love you!"));
	}
	

}
