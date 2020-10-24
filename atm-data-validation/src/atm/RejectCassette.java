package atm;

public class RejectCassette extends Cassette {
	public final int balance;
	public final int billCount;

	public RejectCassette(int balance, int billCount, CassetteStatus status) {
		super(status);
		this.balance = balance;
		this.billCount = billCount;
	}

}
