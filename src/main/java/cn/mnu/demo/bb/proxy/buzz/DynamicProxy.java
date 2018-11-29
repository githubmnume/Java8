package cn.mnu.demo.bb.proxy.buzz;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {

	private BuzzInterface buzzInterface;
	private InventoryInterface inventoryInterface;
	public InventoryInterface getInventoryInterface() {
		return inventoryInterface;
	}

	public void setInventoryInterface(InventoryInterface inventoryInterface) {
		this.inventoryInterface = inventoryInterface;
	}

	private Log log;
	private Auth auth;
	
	
	public BuzzInterface getBuzzInterface() {
		return buzzInterface;
	}

	public void setBuzzInterface(BuzzInterface buzzInterface) {
		this.buzzInterface = buzzInterface;
	}

	public Log getLog() {
		return log;
	}

	public void setLog(Log log) {
		this.log = log;
	}

	public Auth getAuth() {
		return auth;
	}

	public void setAuth(Auth auth) {
		this.auth = auth;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("DynamicProxy start");
		if (method.getName().equals("doBussiness")) {
			log.log();
			auth.auth();
			if (buzzInterface!=null) {
				method.invoke(buzzInterface, args);
			}
			if (inventoryInterface!=null) {
				method.invoke(inventoryInterface, args);
			}
			log.log();
		}
		else {
			System.out.println("DynamicProxy skip");
		}
		System.out.println("DynamicProxy end");
		return null;
	}

}
