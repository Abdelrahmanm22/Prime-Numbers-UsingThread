package primes;
import java.util.*; 

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

public class Primes {
		static buffer buf = new buffer();
		public static void main(String[] args) throws IOException, InterruptedException {
	        // TODO code application logic here
	        
	        Scanner input = new Scanner(System.in);
	        System.out.print("Ente N: ");
	        int N=input.nextInt();
	        buf.Resize(N);
	       // File file = new File("C:\\Users\\Ahmed\\Destop");
	       //PrintStream stream = new PrintStream(file);
	       //System.setOut(stream);
	       
	       
	        Producer P = new Producer(buf);
	        Consumer c = new Consumer(buf);
	        P.start();
	        c.start();
	          
	       
	    }
	    
}
