/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package primes;
import java.util.*; 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.PrintStream;
/**
 *
 * @author future
 */
public class Primes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        Scanner input = new Scanner(System.in);
        System.out.print("Ente N: ");
        int N=input.nextInt();
        
        File file = new File("D:\\University\\Operating System\\ASS\\Ass1\\Out.txt");
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);
        
        
        
        buffer buf = new buffer(N);
        Producer P = new Producer(buf);
        Consumer c = new Consumer(buf);
        P.start();
        c.start();
        while(!p.IsAlive() && !c.IsAlive()){
            System.out.println(p.MX());     
        }
    }
    
}
