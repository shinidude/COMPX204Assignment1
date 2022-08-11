// /////////////////////////////////////////////////////////////////////////////
// Student Name: Shean Danes Aton    
// ID: 1570802          
// Assignment 1
// /////////////////////////////////////////////////////////////////////////////

import java.net.*; //import java.net

class resolve{
    public static void main(String[] args) {
        //Checks the number of arguments and informs the user of the usage
        if(args.length==0){
            System.err.println("Usage: resolve <name1> <name2> ... <nameN>");
            return;
        }

        //Prints the given host name's corresponding IP address
       InetAddress ia;
       for (String arg : args) {
            try{
                ia=InetAddress.getByName(arg); //Determines the IP address of the host given the hostname 
                String ip = ia.getHostAddress(); //returns the IP address string in textual presentation
                System.out.println(arg+" : "+ ip);
            }
            catch(UnknownHostException e){
                System.err.println(arg+" : unknown host");
                //takes off the return otherwise invalid host could end the program before it should do 
            }
        }
    }
} 
