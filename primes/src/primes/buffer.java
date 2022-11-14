/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primes;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author future
 */
public class buffer {
    private int Size = 5;
//    private int store[]= new int[Size];
    private Queue <Integer> queue = new LinkedList<>();
    protected int N; 
    
    private int inptr = 0;
    private int outptr = 0;
    
    Semaphore spaces = new Semaphore(Size);
    Semaphore elements = new Semaphore(0);
    
    public buffer(int size){
        this.N=size;
    }
    
    
    public void produce(int value) throws InterruptedException{
        
        synchronized(this){
            while(queue.size()==Size)
                wait();
            
            queue.add(value);
            notify();
        }
//        spaces.P();
//        store[inptr] = value;
//        inptr = (inptr+1)%Size;
//        elements.V();
    }
    
    public int consume() throws InterruptedException{
        int value;
        synchronized(this){
            while(queue.size()==0)
                wait();
            
            value = queue.remove();
            notify();
            return value;
        }
//        int value;
//        elements.P();
//        value = store[outptr];
//        outptr = (outptr+1)%Size;
//        spaces.V();
//        return value;
    }
}
