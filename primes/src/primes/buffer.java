/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primes;

/**
 *
 * @author future
 */
public class buffer {
    private int Size = 5;
    private int store[]= new int[Size];
    protected int N;
    
    public buffer(int size){
        this.N=size;
    }
    private int inptr = 0;
    private int outptr = 0;
    
    Semaphore spaces = new Semaphore(Size);
    Semaphore elements = new Semaphore(0);
    
    public void produce(int value){
        spaces.P();
        store[inptr] = value;
        inptr = (inptr+1)%Size;
        elements.V();
    }
    
    public int consume(){
        int value;
        elements.P();
        value = store[outptr];
        outptr = (outptr+1)%Size;
        spaces.V();
        return value;
    }
}
