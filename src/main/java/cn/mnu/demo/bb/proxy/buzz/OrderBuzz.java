package cn.mnu.demo.bb.proxy.buzz;

public class OrderBuzz implements BuzzInterface {

	@Override
	public void doBussiness() {
		System.out.println("order processing ");
	}

}
