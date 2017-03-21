package tp.pl.model;

import java.math.BigDecimal;

public class Adjustement {

	private BigDecimal totalBefore;
	private BigDecimal totalAfter;
	private BigDecimal totalQty;
	private Command command;
	private BigDecimal delta;
	private String productType;

	public Adjustement(BigDecimal totalBefore, BigDecimal totalAfter, BigDecimal totalQty, Command command,
			BigDecimal delta, String productType) {
		this.totalBefore = totalBefore;
		this.totalAfter = totalAfter;
		this.totalQty = totalQty;
		this.command = command;
		this.delta = delta;
		this.productType = productType;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public BigDecimal getTotalBefore() {
		return totalBefore;
	}
	public void setTotalBefore(BigDecimal totalBefore) {
		this.totalBefore = totalBefore;
	}
	public BigDecimal getTotalAfter() {
		return totalAfter;
	}
	public void setTotalAfter(BigDecimal totalAfter) {
		this.totalAfter = totalAfter;
	}
	public BigDecimal getTotalQty() {
		return totalQty;
	}
	public void setTotalQty(BigDecimal totalQty) {
		this.totalQty = totalQty;
	}
	public Command getCommand() {
		return command;
	}
	public void setCommand(Command command) {
		this.command = command;
	}
	public BigDecimal getDelta() {
		return delta;
	}
	public void setDelta(BigDecimal delta) {
		this.delta = delta;
	}
	
	public String toString () {
		return "Applied "+getCommand()+" "+getDelta()+" to "+getTotalQty()+ " "+ getProductType()+" and price changed from "+getTotalBefore()+ " to "+getTotalAfter();
	}
	
}
