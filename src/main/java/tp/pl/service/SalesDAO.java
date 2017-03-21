package tp.pl.service;

import java.util.ArrayList;
import java.util.List;

import tp.pl.model.Sale;

public class SalesDAO {
	private List<Sale> sales = new ArrayList<Sale>();
	
	public List<Sale> getSales() {
		return sales;
	}
}
