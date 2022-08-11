// /////////////////////////////////////////////////////////////////////////////
// Student Name: Shean Danes Aton    
// ID: 1570802          
// Assignment 1
// /////////////////////////////////////////////////////////////////////////////

import java.io.*; 
import java.net.*;

/*
 * Create a SimpleClient program to go with your server.  
 * All your SimpleClient has to do is connect to the server, print out whatever the server sends back, and then exit.  
 */
public class SimpleServer {
    public static void main(String[] args){

        try{
             //Creates a server socket, bound to an available port.
	    	ServerSocket sSocket = new ServerSocket(0);
            System.out.println("Listening on port "+ sSocket.getLocalPort()); //Displays on the console the port number 
            Socket cSocket;
            
            while(true){
                //listen for a connection  
                cSocket = sSocket.accept(); 
                //get the input and output streams 
                BufferedReader read = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
                PrintWriter write =new PrintWriter(cSocket.getOutputStream(), true);
                
                String in = read.readLine();
                write.println("Hello, "+ in);
                write.println("Your IP address is "+ cSocket.getInetAddress().getHostAddress());

                cSocket.close(); 
            }
        }
       catch(IOException e){
        System.err.println("IO Exception" + e);
        return;
       }
    } 
}
