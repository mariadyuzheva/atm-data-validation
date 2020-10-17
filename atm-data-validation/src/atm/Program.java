package atm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Program {
	
	public static void main(String[] args) {
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
				parse(s);
			 }
		 } catch(IOException ex) {
			 System.out.println(ex.getMessage());
	     } 
	}
	
	private static void parse(String s) {
		var parser = new EncashmentParser(s);
		parser.parse();
	}
}
