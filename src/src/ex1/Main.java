//Faça um programa em Java que consulte periodicamente o estado de um conjunto de threads
// luizASSilveira

package ex1;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ThreadGroup group = new ThreadGroup("LuizThreads");
        ArrayList<Thread> arrayThred = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            arrayThred.add(i,new Thread(group,new TheadSleep(),"t".concat(String.valueOf(i))));
            arrayThred.get(i).start();
        }

        ThreadMonitor tm = new ThreadMonitor(arrayThred);
        tm.start();
    }
}
