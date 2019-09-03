//Faça um programa em Java para testar um conjunto de operações sobre um grupo de threads. Use o ThreadGroup.
//LuizASSilveira

package ex2;
import ex1.TheadSleep;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup group = new ThreadGroup("LuizThreads");
        ArrayList<Thread> arrayThred = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            arrayThred.add(i,new Thread(group,new TheadSleep(),"t".concat(String.valueOf(i))));
            arrayThred.get(i).start();
        }
        System.out.println("Numero de threads ativas:" + String.valueOf(group.activeCount()));
        System.out.println("Prioridade Maxima threads:" + String.valueOf(group.getMaxPriority()));

        group.interrupt();
        Thread.sleep(2000);
        System.out.println("Numero de threads ativas:" + String.valueOf(group.activeCount()));

        group.destroy();

    }
}
