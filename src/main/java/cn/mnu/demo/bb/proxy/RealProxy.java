package cn.mnu.demo.bb.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class RealProxy implements InvocationHandler {
	private Object pinterface;

	
	
	public RealProxy(Object pinterface) {
		super();
		this.pinterface = pinterface;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 增强逻辑
        System.out.println("PROXY : " + proxy.getClass().getName());

        // 反射调用，目标方法
        Object result = method.invoke(pinterface, args);

        // 增强逻辑
        System.out.println(method.getName() + " : " + result);

        return result;
	}

}
