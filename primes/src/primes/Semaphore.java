/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primes;

/**
 *
 * @author future
 */
public class Semaphore {
    protected int value = 0 ;
    protected Semaphore(){
        value = 0 ; 
    }
    protected Semaphore(int initial) 
    { 
        value = initial ; 
    }
    public synchronized void P() {
 
        value-- ;
        if (value < 0)
            try { 
                wait() ; 
            } catch( InterruptedException e )
            { }
    }
    public synchronized void V() {
        value++ ;
        if (value <= 0)
            notify() ;
    }
}
