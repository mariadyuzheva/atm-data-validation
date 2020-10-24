package atm;
import java.util.ArrayList;
import java.util.Date;

public class CassettesSetForCurrency {
	public final int currency;
	public final int id;
	public final Date dateAndTime;
	public ArrayList<DispenceCassette> dispenceCassettes;
	public ArrayList<DepositCassette> depositCassettes;
	public ArrayList<RejectCassette> rejectCassette;
	
	public CassettesSetForCurrency (int currency, int id, Date dateAndTime, ArrayList<DispenceCassette> dispenceCassettes, 
			ArrayList<DepositCassette> depositCassettes, ArrayList<RejectCassette> rejectCassette) {
		this.currency = currency;
		this.id = id;
		this.dateAndTime = dateAndTime;
		this.dispenceCassettes = dispenceCassettes;
		this.depositCassettes = depositCassettes;
		this.rejectCassette = rejectCassette;
	}
}
