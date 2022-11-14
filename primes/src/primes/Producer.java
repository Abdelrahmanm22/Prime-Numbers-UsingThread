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

/**
 *
 * @author future
 */
public class Producer extends Thread{
    buffer b;
    Queue<Integer> Primes_numbers  = new PriorityQueue<>();
    
    int MAX  = -1;
  
    public Producer(buffer b ){
        this.b=b;
        for(int i = 0 ; i <=b.N; i ++) {
        	if(isPrime(i)) {
        		Primes_numbers.add(i); 
        		MAX  = Math.max(i, MAX); 
        	}
        }
    }
    
    @Override
    public void run(){
        for(Integer p : Primes_numbers) {
        	try {
        		
        		b.produce(p);
        				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
    }
    
    boolean isPrime(int x){
        if(x<=1){return false;}
        for (int i = 2; i*i <=x ; ++i) {
            if(x%i==0){
                return false;
            }
        }
        return true;
    }
    public int MX (){
        return MAX;
    }
    
}
