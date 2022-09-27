package JavaTutorial;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("- - - Inserire numeri - - -");
		
		//Scanner primo numero
		double userIn1 = 0;
		try {
			Scanner firstNum = new Scanner(System.in);
			System.out.println("Inserire il primo numero: ");
			userIn1 = firstNum.nextDouble(); 
		}
		catch(Exception e) {
			System.out.println("Numero non riconosciuto: " + e);
		}
		
		//Scanner secondo numero
		double userIn2 = 0; 
		try {
			Scanner secondNum = new Scanner(System.in);
			System.out.println("Inserire il secondo numero: ");
			userIn2 = secondNum.nextDouble(); 
		}
		catch(Exception e) {
			System.out.println("Numero non riconosciuto: " + e);
		}
		
		//Scanner operatore
		Scanner operator = new Scanner(System.in);
		System.out.println("Scegliere operazione:\n [+] Somma \n [-] Sottrazione \n [/] Divisione \n [*] Prodotto \n [%] Divisione");
		String op = operator.nextLine(); 
		
		//Elaboro operatore per decidere operazione matematica 
		System.out.println("Dati inseriti:" + userIn1 + " " + userIn2 + " " + op);
		switch(op) {
		case "+":
			double result1 = userIn1 + userIn2; 
			System.out.println(result1);
			break;
		case "-":
			double result2 = userIn1 - userIn2; 
			System.out.println(result2);
			break;
		case "/":
			double result3 = userIn1 / userIn2; 
			System.out.println(result3);
			break;
		case "*":
			double result4 = userIn1 * userIn2; 
			System.out.println(result4);
			break;
		case "%":
			double result5 = userIn1 % userIn2; 
			System.out.println(result5);
			break;
		default:
			System.out.println("Operazione non riconosciuta");
			
		}
		
	}
}
