/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primes;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Arrays;

/**
 *
 * @author future
 */
public class Producer extends Thread{
    buffer b;
    Queue<Integer> Primes_numbers  = new PriorityQueue<>();
    
    public Producer(buffer b){
        this.b=b;
        
        Boolean[] prime = new Boolean[b.Max_size + 1];
        Arrays.fill(prime, Boolean.TRUE);
        int lst_ = 0 ;
        for(int p = 2; p*p <= b.Max_size ; p++) {
        	if(prime[p] == true) {
        		Primes_numbers.add(p);
        		for(int i = p*p; i<=b.Max_size; i+=p)
        			prime[i] = false; 		
        	}
        	lst_ = p;
        }
        for(int p =lst_ + 1 ; p<=b.Max_size; p++) {
        	if(prime[p] == true)
        		Primes_numbers.add(p);
        }
    
       b.N = Primes_numbers.size();
        
    }
    
    
    
    @Override
    public void run(){
    	
    	for(Integer p : Primes_numbers) {
    		try {
				b.produce(p);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    
   
    }

    
}
