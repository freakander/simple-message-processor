package tp.pl.service;

import java.util.ArrayList;
import java.util.List;

import tp.pl.model.Adjustement;

public class AdjustementsDAO {
	private List<Adjustement> adjustements = new ArrayList<Adjustement>();
	
	public List<Adjustement> getAdjustements() {
		return adjustements;
	}
}
