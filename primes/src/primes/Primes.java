package primes;
import java.util.*; 

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;


public class Primes {
		
		public static void main(String[] args) throws IOException, InterruptedException {
	        // TODO code application logic here
	        
	       Scanner input = new Scanner(System.in);
	       System.out.print("Ente N: ");
	       int N=input.nextInt();
	       PrintStream console = System.out;
	       buffer buf = new buffer(N);
	       File file = new File("C:\\Users\\Ahmed\\Destop");
	       PrintStream stream = new PrintStream(file);
	      
	       
	       
	        Producer P = new Producer(buf);
	        Consumer c = new Consumer(buf , stream);
	        
	        P.start();
	        c.start();
	        
	        
	        
	        P.join();
	        c.join();
	        
	        System.setOut(console);
	        
	        
	        System.out.println("The Max Prime is " + buf.Max_prime+"\n"+ "The Numbers of Primes are " + buf.N);
	    }
	        
	        
	      
	    
	    
}
