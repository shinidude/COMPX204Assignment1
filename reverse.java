// /////////////////////////////////////////////////////////////////////////////
// Student Name: Shean Danes Aton    
// ID: 1570802          
// Assignment 1
// /////////////////////////////////////////////////////////////////////////////


import java.net.*; //import java.net

class reverse{
    public static void main(String[] args) {
        //Checks the number of arguments and informs the user of the proper usage
        if(args.length==0){  
            System.err.println("Usage: reverse <IPaddress1> <IPaddress2> ... <IPaddressN>");
            return;
        }

        //Prints the IP addresses corresponding host name.
       InetAddress ia;
       String IPname; 
       for (String arg : args) { 
            try{
                ia=InetAddress.getByName(arg); 
                IPname = ia.getHostName();
                if(IPname.compareTo(arg)==0){ //if IPname and arg are identical, this indicates that there is no name for the IP address
                   IPname= "no name"; //Change the value of the IPname into no name to inform the user 
                }
                System.out.println(arg+" : "+ IPname);
            }
            catch(UnknownHostException e){
                System.err.println(arg+" : unknown host");
                //takes off the return otherwise invalid host could end the program before it should do 
            }
        }
    }
} 
