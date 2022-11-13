/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primes;

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
            System.out.print(b.consume()+", ");
        }
    }
}