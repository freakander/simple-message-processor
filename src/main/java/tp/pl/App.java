package tp.pl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import tp.pl.model.Adjustement;
import tp.pl.model.Message;
import tp.pl.model.Sale;
import tp.pl.service.AdjustementsDAO;
import tp.pl.service.MessageReader;
import tp.pl.service.Parser;
import tp.pl.service.SalesDAO;

public class App {
	public static void main (String[] args) {
		SalesDAO salesDao = new SalesDAO();
		AdjustementsDAO adjustementsDao = new AdjustementsDAO();
		List <Message> messages;
		MessageReader mr = new MessageReader();
		messages = mr.process();
		Parser pr = new Parser(salesDao,adjustementsDao);
		int i = 0;
		App app = new App();
		for (Message message: messages) {
			i++;
			pr.parse(message).execute();
			if (i % 10 ==0)
			{
				app.reportAfterEach10Sales(salesDao.getSales());
			}
			if (i % 50 ==0)
			{
				app.reportAfter50Sales(adjustementsDao.getAdjustements());
			}
		}
	}
	
	public void reportAfterEach10Sales (List<Sale> sales) {
		HashMap<String,Sale> res = new HashMap<String,Sale>();
		BigDecimal totalValue = BigDecimal.ZERO;
		for (Sale sale : sales) {
			String productType = sale.getProductType();
			Sale totalSale = res.get(productType);
			BigDecimal value = sale.getQty().multiply(sale.getPrice());
			totalValue = totalValue.add(value);
			if (totalSale!=null) {
				totalSale.setQty(totalSale.getQty().add(sale.getQty()));
				totalSale.setPrice(totalSale.getPrice().add(value));//price as value in this use case
			} else {
				totalSale= new Sale(productType, value, sale.getQty());
			}
			res.put(productType, totalSale);
		}
		
		System.out.println("After each 10 sales report");
		System.out.println(" ------------------------------------------- ");
		System.out.println("|            product|       value|       qty|");
		System.out.println("|-------------------|------------|----------|");
		for (Sale sale: res.values()) {
			System.out.println(sale);
		}
		System.out.println("|-------------------|------------|----------|");
		System.out.println("|        total sales|"+String.format("%1$12s", totalValue.toString())+"|          |");
		System.out.println(" ------------------------------------------- ");
		System.out.println();
		}
	
		public void reportAfter50Sales (List<Adjustement> adjustements) {
			System.out.println("50 processed messsages limit reached. Adjustements made so far:");
			for (Adjustement adjustement: adjustements) {
				System.out.println(adjustement);
			}
			System.exit(1);
		}
	}
