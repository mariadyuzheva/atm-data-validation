package program;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import atm.Encashment;
import parsing.EncashmentParser;

public class EncashmentProgram {
	
	public static void main(String[] args) {
		var encashments = new HashMap<Integer, ArrayList<Encashment>>();
		Scanner input = new Scanner(System.in);
		String filename;
		try {
			System.out.print("Input a filename: ");
			filename = input.nextLine();
		} finally {
			input.close();
		}
		
		 try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
			 String s;
			 while((s = br.readLine()) != null) {
				 var parser = new EncashmentParser(s);
				 var encashment = parser.parseEncashment();
				 
				 if (!encashments.containsKey(encashment.atmNumber)) {
					 encashments.put(encashment.atmNumber, new ArrayList<Encashment>());
				 }
				 encashments.get(encashment.atmNumber).add(encashment);
			 }
		 } catch(IOException ex) {
			 System.out.println(ex.getMessage());
	     } 
	}
}
