package program;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import atm.CassettesSetForCurrency;
import parsing.ATMStateParser;

public class HistoryProgram {
	public static void main(String[] args){
		String fileName = "atmHistory20200430110813.csv";
		var ATMStates = new HashMap<Integer, HashMap<Integer, CassettesSetForCurrency>>();
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String str;
			while((str = br.readLine()) != null) {
				var fields = str.split("\t");
				var cassettesSetForCurrency = ATMStateParser.parse(fields);
				if (!ATMStates.containsKey(cassettesSetForCurrency.id)) {
					ATMStates.put(cassettesSetForCurrency.id, new HashMap<Integer, CassettesSetForCurrency>());
				}
				ATMStates.get(cassettesSetForCurrency.id).put(cassettesSetForCurrency.currency, cassettesSetForCurrency);
			}
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println("done");
	}
}
