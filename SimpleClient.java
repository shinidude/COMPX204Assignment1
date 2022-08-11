// /////////////////////////////////////////////////////////////////////////////
// Student Name: Shean Danes Aton    
// ID: 1570802          
// Assignment 1
// /////////////////////////////////////////////////////////////////////////////

import java.io.*;
import java.net.*;

public class SimpleClient
{
    public static void main(String[] args)
    {    
        InetAddress ia;

        //Instructions for the user to recognise the usage of SimpleClient 
        if(args.length!=2){
            System.err.println("Usage: SimpleClient <hostname> <port>");
            return;
        }

        //Gets the IP address of the given name 
        try{
           ia= InetAddress.getByName(args[0]);//Determines the IP address of a host, given the host's name.
        }
        catch(UnknownHostException e){
            System.err.println(args[0]+" : unknown host");
            return;
        }
        
        //Prints out to the console which port it chose.
        try {
           Socket s = new Socket(ia, Integer.parseInt(args[1]));
            PrintWriter writer = new PrintWriter(s.getOutputStream(), true);
            writer.println(args[0]); //communicating to the server that this is the used hostname
            BufferedReader read = new BufferedReader(new InputStreamReader(s.getInputStream()));
    
            System.out.println(read.readLine()); //Displays the send information on the console
            System.out.println(read.readLine());

            s.close();//closes this socket    
        } catch(IOException e) {
            System.err.println("IO Exception" + e);
            return;
        }
    }

}