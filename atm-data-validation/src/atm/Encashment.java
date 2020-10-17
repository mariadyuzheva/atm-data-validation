package atm;

import java.util.Date;

public class Encashment {
	
	public enum Operation {
		unloadingDispensing,
		loadingDispensing,
		unloadingDeposit,
		loadingDeposit
	}
	
	private Operation[] operations = new Operation[] {
		Operation.unloadingDispensing,
		Operation.loadingDispensing,
		Operation.unloadingDeposit,
		Operation.loadingDeposit
	};
	
	public Date dateAndTime;
	public int atmNumber;
	public Operation operation;
	public Cassette[] cassettes;
	public int rejectSum;
	public int depositSum;
	public int currencyCode;
	
	public Encashment(Date dateAndTime, int atmNumber, int operationCode, Cassette[] cassettes, 
			int rejectSum, int depositSum, int currencyCode) {
		this.dateAndTime = dateAndTime;
		this.atmNumber = atmNumber;
		this.operation = operations[operationCode];
		this.cassettes = cassettes;
		this.rejectSum = rejectSum;
		this.depositSum = depositSum;
		this.currencyCode = currencyCode;
	}
}
