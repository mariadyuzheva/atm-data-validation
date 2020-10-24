package atm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EncashmentParser {
	private static final String dateFormat = "dd.MM.yyyy HH:mm:ss";
	private static final int cassettesCount = 6;
	private String data;
	
	public EncashmentParser(String data) {
		this.data = data;
	}
	
	public Encashment parseEncashment() {
		var fields = data.split("\t");
		var cassettes = new ArrayList<EncashmentCassette>();
		for (int i = 0; i < cassettesCount; i++) {
			cassettes.add(new EncashmentCassette(fields[i + 3], fields[i + 3 + cassettesCount]));
		}
		
		var simpleDateFormat = new SimpleDateFormat(dateFormat);
		Date dateAndTime = new Date();
		try {
			dateAndTime = simpleDateFormat.parse(fields[0]);
		} catch(ParseException ex) {
			System.out.println(ex.getMessage());
		}
		
		return new Encashment(
				dateAndTime, 
				Integer.parseInt(fields[1]), 
				Integer.parseInt(fields[2]), 
				cassettes,
				Integer.parseInt(fields[15]),
				Integer.parseInt(fields[16]),
				Integer.parseInt(fields[17]));
	}
}
