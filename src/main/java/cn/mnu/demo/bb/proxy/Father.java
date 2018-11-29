package cn.mnu.demo.bb.proxy;

public class Father implements PersonInterface {

	@Override
	public void sayHello() {
		System.out.println("Father say hello");
	}

	@Override
	public void sayBye() {
		System.out.println("Father say sayBye");
		
	}

}

