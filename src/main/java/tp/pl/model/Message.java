package tp.pl.model;

import java.math.BigDecimal;

public class Message {
	private String productType;
	private BigDecimal price;
	private BigDecimal qty=BigDecimal.ONE;
	private Command command=Command.SALE;
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getQty() {
		return qty;
	}
	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}
	public Command getCommand() {
		return command;
	}
	public void setCommand(Command command) {
		this.command = command;
	}	
	
}
