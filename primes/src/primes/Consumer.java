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
    
    public Consumer(buffer b){
        this.b=b;
    }
    @Override
    public void run(){
        for(int i=0;i<=b.N;i++){
            try {
                System.out.print(b.consume()+", ");
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}