package Calculator2;

import java.io.File;
import java.util.Scanner;

public class Readfile {
	private Scanner scan;
	
	//Open file 
	public void openFile() {
		try {
			scan = new Scanner(new File("textfile.txt"));
		}
		catch(Exception e) {
			System.out.println("File not found: " + e);
		}
	}
	
	//Read file + 
	public void readFile() {
			String str1 = scan.next();
			String op = scan.next();
			String str2 = scan.next();
			
			
			System.out.printf("%s %s %s :", str1, op, str2);
			
			double num1 = 0; 
			double num2 = 0;
			
			//Conversion form strings to doubles  
			try{
	            num1 = Double.parseDouble(str1);
	            //System.out.println(num1);
	            num2 = Double.parseDouble(str2);
	            //System.out.println(num2);
	        }
	        catch (NumberFormatException ex){
	            System.out.println("Formato non riconosciuto " + ex);
	            return;

	        }
		
			
			//Effettuo calcolo in base all'operatore per i primi 2 operandi
			double result = 0;
			
			switch(op) {
			case "+":
				result = num1 + num2; 
				System.out.println(result);
				break;
			case "-":
				result = num1 - num2; 
				System.out.println(result);
				break;
			case "/":
				result = num1 / num2; 
				System.out.println(result);
				break;
			case "*":
				result = num1 * num2; 
				System.out.println(result);
				break;
			case "%":
				result = num1 % num2; 
				System.out.println(result);
				break;
			default:
				System.out.println("Operazione non riconosciuta");
				return;				
		}	
			
		// Reading next characters starting form the first operation result 
		while(scan.hasNext()){
			String op1 = scan.next();
			String str3 = scan.next();
			
			System.out.printf("%s %s: ", op1, str3);
			
			double num3 = 0; 
			
			try{
	            num3 = Double.parseDouble(str3);
	            //System.out.println(num3);
	        }
	        catch (NumberFormatException ex){
	            System.out.println("Unknown  format " + ex);
	            return; 

	        }
			//Setting the math operator with the previous operand 
			switch(op1) {
			case "+":
				result = result + num3; 
				System.out.println(result);
				break;
			case "-":
				result = result - num3; 
				System.out.println(result);
				break;
			case "/":
				result = result / num3; 
				System.out.println(result);
				break;
			case "*":
				result = result * num3; 
				System.out.println(result);
				break;
			case "%":
				result = result % num3; 
				System.out.println(result);
				break;
			default:
				System.out.println("Not recognized operation");
				return;				
		  }	
			
		}
			
}	
	//Closing file
	public void closeFile() {
		scan.close();
	}
}


