package cn.mnu.demo.bb.proxy.buzz;

public class AuthenticationActioner implements BuzzInterface {

	private BuzzInterface buzzInterface;
	
	public AuthenticationActioner(BuzzInterface buzzInterface) {
		super();
		this.buzzInterface = buzzInterface;
	}
	@Override
	public void doBussiness() {
		if (Math.random()>0.5) {
			System.out.println("AuthenticationActioner success");
			buzzInterface.doBussiness();
		}
		else {
			System.out.println("AuthenticationActioner failed");
		}

	}

}
