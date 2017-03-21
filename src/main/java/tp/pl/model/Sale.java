package tp.pl.model;

import java.math.BigDecimal;

public class Sale {
		public Sale(String productType, BigDecimal price, BigDecimal qty) {
		super();
		this.productType = productType;
		this.price = price;
		this.qty = qty;
	}
		private String productType;
		private BigDecimal price;
		private BigDecimal qty=BigDecimal.ONE;

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
		public String toString () {
			return "|"+String.format("%1$19s", getProductType())+"|"+String.format("%1$12s",getPrice().toString())+"|"+String.format("%1$10s",getQty().toString())+"|";
		}
	}