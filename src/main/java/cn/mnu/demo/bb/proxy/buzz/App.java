package cn.mnu.demo.bb.proxy.buzz;

import java.lang.reflect.Proxy;

public class App {

	public static void main(String[] args) {
		// BuzzInterface buzzInterface = getInstance();
		// buzzInterface.doBussiness();
		//
		BuzzInterface newProxyInstance = getDynamicInstance();
		newProxyInstance.doBussiness();
		
		InventoryInterface newProxyInstance1 =getDynamicInstance1();
		newProxyInstance1.doBussiness();
	}

	public static BuzzInterface getInstance() {
		return new LogActioner(new AuthenticationActioner(new OrderBuzz()));
	}

	public static BuzzInterface getDynamicInstance() {
		DynamicProxy dynamicProxy = new DynamicProxy();
		dynamicProxy.setAuth(new Auth());
		dynamicProxy.setLog(new Log());
		BuzzInterface newProxyInstance = (BuzzInterface) Proxy.newProxyInstance(BuzzInterface.class.getClassLoader(),
				new Class[] { BuzzInterface.class }, dynamicProxy);
		dynamicProxy.setBuzzInterface(new OrderBuzz());
		return newProxyInstance;
	}
	public static InventoryInterface getDynamicInstance1(){
		DynamicProxy dynamicProxy = new DynamicProxy();
		dynamicProxy.setAuth(new Auth());
		dynamicProxy.setLog(new Log());
		InventoryInterface newProxyInstance = (InventoryInterface) Proxy.newProxyInstance(InventoryInterface.class.getClassLoader(),
				new Class[] { InventoryInterface.class }, dynamicProxy);
		dynamicProxy.setInventoryInterface(new InventoryBuzz());
		return newProxyInstance;
	}

}
