package cn.mnu.demo.bb.proxy.buzz;

public class LogActioner implements BuzzInterface {

	private BuzzInterface buzzInterface;
	
	public LogActioner(BuzzInterface buzzInterface) {
		super();
		this.buzzInterface = buzzInterface;
	}

	@Override
	public void doBussiness() {
		System.out.println("LogActioner loged");
		buzzInterface.doBussiness();
	}

}
