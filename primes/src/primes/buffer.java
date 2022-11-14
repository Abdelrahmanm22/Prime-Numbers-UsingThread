/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primes;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author future
 */
public class buffer {
    static public int Size = 5;
    static public int cnt = 0; 
	static public  boolean Lock = false ; 
    static public Queue <Integer> queue = new PriorityQueue<>();
    protected int N; 
    
    public void Resize(int n) {
    	this.N = n; 
    }
    
    public void produce(int value) throws InterruptedException{
        
        synchronized(this){
       
        	queue.add(value);
        	
        	notifyAll();
       }
    }
    
    public void consume() throws InterruptedException{
   
        synchronized(this) {
        	while(queue.size() < Size)
        		wait();
        	while(queue.size() > 0) {
        		System.out.print(queue.remove() + ", " );
        	}
        	
        	notifyAll();
        }
    }
	
}
