package networkClient;

import java.io.*;
import java.net.*;

public class Client {
	
	// Set to null while connection is not existing 
	
		Socket mySocket = null;
		
		// Stream initializing
		
		DataOutputStream out;
		DataInputStream in; 
		
		BufferedReader keyboard;
		String message;
		
	public void Communciate() {
		
		try {
				do
				{
					//Scanning input from keyboard 
					
					keyboard = new BufferedReader(new InputStreamReader(System.in)); 
					
					System.out.print("3: Message to be sent to Server : ");
					
					message = keyboard.readLine();
					
					System.out.println("4: Sending message : " + message);
					
					out.writeBytes(message + "\n");
					
					System.out.println("5: Waiting answer...");
					
					String received = in.readLine();
					
					System.out.println("6: Server Replying : " + received);
					
				}while(!message.toLowerCase().equals("esci"));
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
		
	public Socket connect(int port) {
				
		try {
			//Creating socket connection with host , saving channel into server
			
			System.out.println("1: Client Connection try...");
			
			Socket mySocket = new Socket(InetAddress.getLocalHost(),port);
			
			System.out.println("2: Client Connected");
			
			in = new DataInputStream(mySocket.getInputStream());
			out = new DataOutputStream(mySocket.getOutputStream());
			
		}catch(UnknownHostException e) {
			System.out.println("Unknown host : " + e);
		}catch(Exception e) {
			System.out.println("Impossible to establish connection : " + e);
		}
		return mySocket;
	}	
	
	public static void main(String[] args) {

		// Initializing server port
		
		int port = 6789;
		
		// Starting client
		
		Client client = new Client();
		client.connect(port);
		client.Communciate();
		
		

	}

}
