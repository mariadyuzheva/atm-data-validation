package atm;
public class CassetteFactory {
	public static DepositCassette getDepositCassette(String[] fields) {
		var balance = Integer.parseInt(fields[0]);
		var billCount = Integer.parseInt(fields[1]);
		var statusCode = Integer.parseInt(fields[2]);
		CassetteStatus status = getStatus(statusCode);
		return new DepositCassette(balance, billCount, status);
	}
	
	public static RejectCassette getRejectCassette(String[] fields) {
		var balance = Integer.parseInt(fields[0]);
		var billCount = Integer.parseInt(fields[1]);
		var statusCode = Integer.parseInt(fields[2]);
		CassetteStatus status = getStatus(statusCode);
		return new RejectCassette(balance, billCount, status);
	}
	
	public static DispenceCassette getDispenseCassette(String[] fields) {
		var denomination = Integer.parseInt(fields[0]);
		var billCount = Integer.parseInt(fields[1]);
		var receivedMoneySum = Integer.parseInt(fields[2]);
		var dispensedMoneySum = Integer.parseInt(fields[3]);
		var statusCode = Integer.parseInt(fields[4]);
		var currency = Integer.parseInt(fields[5]);
		CassetteStatus status = getStatus(statusCode);
		return new DispenceCassette(denomination, billCount, receivedMoneySum, dispensedMoneySum, status, currency);
	}
	
	private static CassetteStatus getStatus(int statusCode) {
		CassetteStatus status = null;
		switch(statusCode) {
		case 1:
			status = CassetteStatus.OPERATIVECONDITION;
			break;
		case 2:
			status = CassetteStatus.FAULTYCONDITION;
			break;
		case 3:
			status = CassetteStatus.MISSING;
			break;
		default:
				break;
		}
		return status;
	}
}
