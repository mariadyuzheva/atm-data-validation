package atm;

public class DepositCassette extends Cassette {
	public final int balance;
	public final int billCount;

	public DepositCassette(int balance, int billCount, CassetteStatus status) {
		super(status);
		this.balance = balance;
		this.billCount = billCount;
	}

}
