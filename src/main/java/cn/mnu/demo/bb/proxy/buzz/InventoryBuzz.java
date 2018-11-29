package cn.mnu.demo.bb.proxy.buzz;

public class InventoryBuzz implements InventoryInterface {

	@Override
	public void doBussiness() {
		System.out.println("Inventory process");
		
	}
}
