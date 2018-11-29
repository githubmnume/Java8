package cn.mnu.demo.A;

public class C extends A {
public static void main(String[] args) {
	A a=new A();
	a.Aname();
	C c=new C();
	c.Aname();
	
}

@Override
protected void Aname() {
	// TODO Auto-generated method stub
	System.out.println("C name");
}

}
