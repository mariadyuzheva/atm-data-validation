package parsing;

import atm.CassetteStatus;
import atm.DepositCassette;
import atm.DispenceCassette;
import atm.RejectCassette;

public class CassetteFactory {
	public static DepositCassette getDepositCassette(String[] fields) throws ATMDataParserException {
		var balance = getBalance(fields[0]);
		var billCount = getBillCount(fields[1]);
		CassetteStatus status = getStatus(fields[2]);
		if (status == CassetteStatus.MISSING) {
			if (balance != 0)
				throw new ATMDataParserException("������� �����������, �� ������� �� ����� 0");
			if (billCount != 0)
				throw new ATMDataParserException("������� �����������, �� ���������� ����� �� ����� 0");
		}
		return new DepositCassette(balance, billCount, status);
	}
	
	public static RejectCassette getRejectCassette(String[] fields) throws ATMDataParserException {
		var balance = getBalance(fields[0]);
		if (fields[1].length() > 4)
			throw new ATMDataParserException("������� ������ ���� ������, ���������� �� ����� ������� ������");
		var billCount = getBillCount(fields[1]);
		CassetteStatus status = getStatus(fields[2]);
		if (status == CassetteStatus.MISSING) {
			if (balance != 0)
				throw new ATMDataParserException("������� �����������, �� ������� �� ����� 0");
			if (billCount != 0)
				throw new ATMDataParserException("������� �����������, �� ���������� ����� �� ����� 0");
		}
		return new RejectCassette(balance, billCount, status);
	}
	
	public static DispenceCassette getDispenseCassette(String[] fields, int currency) throws ATMDataParserException {
		var denomination = getDenomination(fields[0]);
		var billCount = getBillCount(fields[2]);
		var receivedMoneySum = getReceivedMoneySum(fields[3]);
		var dispensedMoneySum = getDispensedMoneySum(fields[4]);
		CassetteStatus status = getStatus(fields[1]);
		if (status == CassetteStatus.MISSING) {
			if (denomination != 0)
				throw new ATMDataParserException("������� �����������, �� ������� �� ����� 0");
			if (billCount != 0)
				throw new ATMDataParserException("������� �����������, �� ������� �� ����� 0");
		}
		return new DispenceCassette(denomination, billCount, receivedMoneySum, dispensedMoneySum, status, currency);
	}
	
	private static int parseStringToInteger(String str, String excMessage) throws ATMDataParserException {
		try {
			return Integer.parseInt(str);
		}
		catch (Exception ex) {
			throw new ATMDataParserException(excMessage);
		}
	}
	
	private static int getBalance(String str) throws ATMDataParserException {
		var balance = parseStringToInteger(str, "������� ������ ���� ����� ������");
		if (balance < 0)
			throw new ATMDataParserException("������� ������ ���� ��������������� ������");
		return balance;
	}
	
	private static int getBillCount(String str) throws ATMDataParserException {
		var billCount = parseStringToInteger(str, "���������� ����� ������ ���� ����� ������");
		if (billCount < 0)
			throw new ATMDataParserException("���������� ����� ������ ���� ��������������� ������");
		return billCount;
	}
	
	private static int getDenomination(String str) throws ATMDataParserException {
		var denomination =  parseStringToInteger(str, "������� ������ ���� ����� ������");
		if (denomination < 0)
			throw new ATMDataParserException("������� ������ ���� ������������� ������");
		return denomination;
	}
	
	private static int getReceivedMoneySum(String str) throws ATMDataParserException {
		var receivedMoneySum = parseStringToInteger(str, "����������� � ������ ��� ������ ���� ����� ������");
		if (receivedMoneySum < 0)
			throw new ATMDataParserException("����������� � ������ ��� ������ ���� ��������������� ������");
		return receivedMoneySum;
	}
	
	private static int getDispensedMoneySum(String str) throws ATMDataParserException {
		var dispensedMoneySum = parseStringToInteger(str, "������ � ������ ��� ������ ���� ����� ������");
		if (dispensedMoneySum < 0)
			throw new ATMDataParserException("������ � ������ ��� ������ ���� ��������������� ������");
		return dispensedMoneySum;
	}
	
	
	private static CassetteStatus getStatus(String str) throws ATMDataParserException {
		var statusCode = parseStringToInteger(str, "������ ������� ������ ���� ����� ������");
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
			throw new ATMDataParserException("������ ������� ����� ��������� ������ ��������: 1, 2 � 3");
		}
		return status;
	}
}
