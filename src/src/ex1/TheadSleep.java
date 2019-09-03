package ex1;

import java.util.Random;
public class TheadSleep extends Thread{
    private Integer number;

    public TheadSleep() {
        Random number = new Random();
        this.number = number.nextInt(1000);
    }
    @Override
    public void run() {
        System.out.println("Thread number: " + Long.toString(this.getId())  + " Rodando");
        while (true){
            try {
                for (int i = 0; i <10000 ; i++) {
                    for (int j = 0; j < 10000 ; j++) {

                    }
                }
                Thread.sleep(this.number);
            } catch (InterruptedException ex){
                System.out.println("Thread number: " + Long.toString(this.getId())  + " " + ex);
                break;
            }
        }
    }
}