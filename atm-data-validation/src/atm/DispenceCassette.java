package atm;

public class DispenceCassette extends Cassette {
	public final int denomination;
	public final int billCount;
	public final int receivedMoneySum;
	public final int dispensedMoneySum;
	public final int currency;
	

	public DispenceCassette (int denomination, int billCount, int receivedMoneySum, int dispensedMoneySum, CassetteStatus status, int currency) {
		super(status);
		this.denomination = denomination; //enum?
		this.billCount = billCount;
		this.receivedMoneySum = receivedMoneySum;
		this.dispensedMoneySum = dispensedMoneySum;
		this.currency = currency; //enum?
	}
	
}
