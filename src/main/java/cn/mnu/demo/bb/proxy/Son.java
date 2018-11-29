package cn.mnu.demo.bb.proxy;

public class Son implements PersonInterface {

	private Father father;
	
	public Son(Father father) {
		super();
		this.father = father;
	}

	@Override
	public void sayHello() {
		System.out.println("Son say hello,static proxy");
		father.sayHello();
	}

	@Override
	public void sayBye() {
//		System.out.println("Son say sayBye,static proxy");
//		father.sayBye();
	}
	
}
