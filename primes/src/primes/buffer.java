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
	private int size; // the buffer bound
	private Object store[];
	private int inptr = 0;
	private int outptr = 0;	
	public int N = -1 ; 
	public int Max_size ;
	public int Max_prime = -1; 
	static public boolean DoneProducer=  false , Doneconsumer = false; 
	private semaphore spaces;
    private semaphore elements;
	
	public buffer(int n, int size) {
		this.Max_size = n; 
		this.size = size;
		this.spaces = new semaphore(this.size);
	    this.elements = new semaphore(0); 
	    this.store = new Object[this.size];
	}
	
	
    
    
    public void produce(Object value) throws InterruptedException{
    	spaces.P();
    	store[inptr] = value;
    	Max_prime = Math.max(Max_prime, (int) value); 
    	inptr = (inptr + 1) % size;
    	elements.V();

    }
    
    public Object consume() throws InterruptedException{
    	Object value;
    	elements.P();
    	value = store[outptr];
    	outptr = (outptr + 1) % size;
    	spaces.V();
    	return value;	
 
    }
	
}
