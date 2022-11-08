package networkServer;

import java.io.*;
import java.net.*;

public class server {
	
	// Set to null while connection is not existing 
	
	ServerSocket server = null; 
	Socket socketClient = null;
	
	// Stream initializing
	
	DataOutputStream out;
	DataInputStream in; 
	
	String read;
	
	public void Communication() {
		
		try {
				do {
					System.out.println("4: Waiting for a message...");
					
					read = in.readLine();
					
					System.out.println("5: Message recived : " + read);
					
					String answer = read.toUpperCase();
					
					System.out.println("6: Replying : " + answer);
					
					// Writing answer on output stream
					
					out.writeBytes(answer + "\n");
				}while(!read.toLowerCase().equals("esci"));			
		
				// Closing connection with client
				
				System.out.println("7: Closing connection...");
				
				socketClient.close();
			
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	// Connection method
	
	public Socket wait(int port) {
		
		try {
			
			System.out.println("1: Server initializing...");
			
			server = new ServerSocket(port); // Service initializing
			
			System.out.println("2: Server ready, listening on port : " + port);
			
			socketClient = server.accept();  // Listening on port : waiting for connection
			
			System.out.println("3: Connection established");
			
			server.close(); // Once connected : avoid other connection -> one-to-one connection
			
			//Creating new Stream variables
			
			in = new DataInputStream(socketClient.getInputStream());
			out = new DataOutputStream(socketClient.getOutputStream());
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return socketClient;
	}

	public static void main(String[] args) {
		
		// Initializing server port
		
		int port = 6789;
		
		// Starting server
		
		server server = new server();
		server.wait(port);
		server.Communication();
		

	}

}
