/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primes;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author future
 */
public class Consumer extends Thread{
    buffer b;
    boolean end; 
    public Consumer(buffer b){
        this.b=b;
    }
    @Override
    public void run(){
    		try {
				b.consume();
			} catch (InterruptedException e) {
					// TODO Auto-generated catch block
		 		e.printStackTrace();
	     	}
    		
    }
 }

