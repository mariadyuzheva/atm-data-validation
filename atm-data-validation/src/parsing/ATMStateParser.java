package parsing;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Arrays;

import atm.CassettesSetForCurrency;
import atm.DepositCassette;
import atm.DispenceCassette;
import atm.RejectCassette;

public class ATMStateParser {
	
	private static final int fieldsCount = 42;
	private static final int dispenceCassettesCount = 6;
	private static final int depositCassettesCount = 1;
	private static final int rejectCassettesCount = 2;
	private static final String dateFormat = "dd.MM.yyyy HH:mm:ss";
	private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
	
	public static CassettesSetForCurrency parse(String[] fields){
		Date dateAndTime = new Date();
		if (fields.length != fieldsCount) {
			//logging
			//exit
		}
		try {
			dateAndTime = simpleDateFormat.parse(fields[0]);
		}
		catch (ParseException ex) {
			System.out.println(ex.getMessage());
			//logging
			//exit
		}
		var id = 0;
		try {
			id = Integer.parseInt(fields[1]);
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			//logging
			//exit
		}
		
		var currency = 0;
		try {
			currency = Integer.parseInt(fields[41]);
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			//logging
			//exit
		}
		var dispenceCassettes = new ArrayList<DispenceCassette>();
		var depositCassettes = new ArrayList<DepositCassette>();
		var rejectCassettes = new ArrayList<RejectCassette>();
		try {
			for (var i = 0; i < dispenceCassettesCount; i++) {
				dispenceCassettes.add(CassetteFactory.getDispenseCassette(new String[] {
						fields[i*5 + 2], 
						fields[i*5 + 3], 
						fields[i*5 + 4], 
						fields[i*5 + 5], 
						fields[i*5 + 6]
								},
						currency));
			}
			for (var i = 0; i < depositCassettesCount; i++) {
				depositCassettes.add(CassetteFactory.getDepositCassette(new String[] {
						fields[i*3 + 32], 
						fields[i*3 + 33], 
						fields[i*3 + 34]
								}));
			}
			for (var i = 0; i < rejectCassettesCount; i++) {
				rejectCassettes.add(CassetteFactory.getRejectCassette(new String[] {
						fields[i*3 + 35], 
						fields[i*3 + 36], 
						fields[i*3 + 37]
								}));
			}
		}
		catch (ATMDataParserException ex) {
			//logging
			System.out.println(ex.getMessage());
			System.out.println(Arrays.toString(fields));
		}
		return new CassettesSetForCurrency(currency, id, dateAndTime, dispenceCassettes, depositCassettes, rejectCassettes);
		
	}
}
