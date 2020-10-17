package atm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EncashmentParser {
	private static final String dateFormat = "dd.MM.yyyy HH:mm:ss";
	private String data;
	
	public EncashmentParser(String data) {
		this.data = data;
	}
	
	public Encashment parse() {
		var fields = data.split("\t");
		var cassettes = new Cassette[] { 
				new Cassette(fields[3], fields[9]),
				new Cassette(fields[4], fields[10]),
				new Cassette(fields[5], fields[11]),
				new Cassette(fields[6], fields[12]),
				new Cassette(fields[7], fields[13]),
				new Cassette(fields[8], fields[14]) };
		
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
