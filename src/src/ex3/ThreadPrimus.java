package ex3;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPrimus extends Thread {
    private static AtomicInteger count = new AtomicInteger(1);

    @Override
    public void run() {
        while(true) {
            Integer val = count.getAndIncrement();
            if (val > 100000){
                break;
            }
            //peguei na internet o calculo dos numeros primos
            long number = Math.abs(val);
            if (number % 2 == 0) { continue; }
            for (long i = 3; i * i <= number; i += 2) {
                if (number % i == 0) { continue; }
            }
            System.out.println(this.getName() +" encontrou valor: ".concat(String.valueOf(val)));
        }
    }
}

