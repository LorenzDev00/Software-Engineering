# 📡 Java Networking with Sockets 📡 #

### What is a socket ?

>A socket connection means the two **machines have information about each other’s network location** (IP Address) and TCP port. The `java.net.Socket` class represents a Socket

### Stages
-   Server application makes a ServerSocket on a specific **port**. 
	 - This starts  Server listening for client requests coming in for that port.
-   Then Server makes a **new Socket** to communicate with the client.
- The `wait()` method _stand-bys_ until a client connects to the server.
-   Then we take input from the socket using getInputStream() method. Our Server keeps receiving messages until the Client sends _“esci”_.
-   After we’re done we **close the connection** by closing the socket and the input stream.
-   To run the Client and Server application on your machine, compile both of them. Then first run the server application and then run the Client application.

StackEdit stores your files in your browser, which means all your files are automatically saved locally and are accessible **offline!**

Resources :
- Youtube  📺
- [GeeksforGeeks](https://www.geeksforgeeks.org/socket-programming-in-java/) 🌐
