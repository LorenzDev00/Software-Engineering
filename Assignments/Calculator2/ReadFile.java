package Calculator2;

import java.io.File;
import java.util.Scanner;

public class Readfile {
	private Scanner scan;
	
	//Apro file
	public void openFile() {
		try {
			scan = new Scanner(new File("textfile.txt"));
		}
		catch(Exception e) {
			System.out.println("File not found: " + e);
		}
	}
	
	//Lettura file + Calcolo 
	public void readFile() {
		while(scan.hasNext()) {
			String str1 = scan.next();
			String str2 = scan.next();
			String op = scan.next();
			
			System.out.printf("- - - - - - - \n%s %s %s\n", str1, str2, op);
			
			double num1 = 0,num2 = 0;
			
			//Effettuo conversione da String a Double 
			try{
	            num1 = Double.parseDouble(str1);
	            //System.out.println(num1);
	            num2 = Double.parseDouble(str2);
	            //System.out.println(num2);
	        }
	        catch (NumberFormatException ex){
	            System.out.println("Formato non riconosciuto " + ex);

	        }
			
			System.out.println("Risultato: ");
			
			//Effettuo calcolo in base all'operatore 
			switch(op) {
			case "+":
				double result1 = num1 + num2; 
				System.out.println(result1);
				break;
			case "-":
				double result2 = num1 - num2; 
				System.out.println(result2);
				break;
			case "/":
				double result3 = num1 / num2; 
				System.out.println(result3);
				break;
			case "*":
				double result4 = num1 * num2; 
				System.out.println(result4);
				break;
			case "%":
				double result5 = num1 % num2; 
				System.out.println(result5);
				break;
			default:
				System.out.println("Operazione non riconosciuta");
			
		 System.out.println("- - - - - - -");		
		}
	}
}	
	//Chiudo file 
	public void closeFile() {
		scan.close();
	}
}


