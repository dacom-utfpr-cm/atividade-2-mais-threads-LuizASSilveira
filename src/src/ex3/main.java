//Faça um programa em Java com threads que exiba os números primos entre 0 e 100000.
//LuizASSilveira

package ex3;
import java.util.ArrayList;

public class main {
    public static void main(String[] args){
        ThreadGroup group = new ThreadGroup("LuizThreads");
        ArrayList<Thread> arrayThred = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            arrayThred.add(i,new Thread(group, new Thread(new ThreadPrimus()),"t".concat(String.valueOf(i))));
            arrayThred.get(i).start();
        }
    }
}
