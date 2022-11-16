/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primes;

import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author future
 */
public class Consumer extends Thread{
    buffer b;
    PrintStream stream;
    public Consumer(buffer b , PrintStream stream){
        this.b=b;
        this.stream = stream; 
        System.setOut(stream);
    }
    @Override
    public void run() {
    	for(int i = 1 ; i<=b.N; i++) {
    		try {
				System.out.print(b.consume() + ", ");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
}

