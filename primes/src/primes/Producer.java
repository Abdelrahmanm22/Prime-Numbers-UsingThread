/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primes;

/**
 *
 * @author future
 */
public class Producer extends Thread{
    buffer b;
    
    public Producer(buffer b){
        this.b=b;
        
    }

    
    @Override
    public void run(){
        for(int i=0;i<=b.N;i++){
            if(isPrime(i))
                b.produce(i);
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
}
