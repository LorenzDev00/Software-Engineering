package JavaTutorial;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("- - - Digit the numbers  - - -");
		
		//Scanner first number
		double userIn1 = 0; 
		while(true) {
			try {
				Scanner firstNum = new Scanner(System.in);
				System.out.println("Digit first number: ");
				userIn1 = firstNum.nextDouble(); 
				break;
			}
			catch(Exception e) {
				System.out.println("Unknown number format: " + e);
				continue; 

			}
		}

				
		//Scanner second number
		double userIn2 = 0; 
		while(true) {
			try {
				Scanner secondNum = new Scanner(System.in);
				System.out.println("Digit second number: ");
				userIn2 = secondNum.nextDouble(); 
				break;
			}
			catch(Exception e) {
				System.out.println("Unknown number format: " + e);
				continue; 
			}
		}
		//Scanner operator
		boolean isTrue = true;
		while(isTrue) {
			Scanner operator = new Scanner(System.in);
			System.out.println("Select:\n [+] Sum \n [-] Subtraction \n [/] Integer Division \n [*] Multiplication \n [%] Division");
			String op = operator.nextLine(); 
			
			//Applying the operation to the numbers 
			System.out.println("Inserted data: " + userIn1 + " " + op + " " + userIn2);
			System.out.println("Result: ");
		
			switch(op) {
			case "+":
				double result1 = userIn1 + userIn2; 
				System.out.println(result1);
				isTrue = false;
				break;
			case "-":
				double result2 = userIn1 - userIn2; 
				System.out.println(result2);
				isTrue = false;
				break;
			case "/":
				double result3 = userIn1 / userIn2; 
				System.out.println(result3);
				isTrue = false;
				break;
			case "*":
				double result4 = userIn1 * userIn2; 
				System.out.println(result4);
				isTrue = false;
				break;
			case "%":
				double result5 = userIn1 % userIn2; 
				System.out.println(result5);
				isTrue = false;
				break;
			default:
				System.out.println("Unknown operation, digit the operator again");
				
				
		 }
		 				
		}
		
	}
}

