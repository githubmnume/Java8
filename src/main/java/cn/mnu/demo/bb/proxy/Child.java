package cn.mnu.demo.bb.proxy;

public class Child implements PersonInterface {

private Father father;
	
	
	public Child(Father father) {
	super();
	this.father = father;
}

	@Override
	public void sayHello() {
		// TODO Auto-generated method stub

	}

	@Override
	public void sayBye() {
		System.out.println("Son sayBye()");
		father.sayBye();

	}

}
