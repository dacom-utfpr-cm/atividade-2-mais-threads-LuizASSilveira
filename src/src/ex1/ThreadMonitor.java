package ex1;

import java.util.ArrayList;


public class ThreadMonitor extends Thread{
    private ArrayList<Thread> arrayThread = new ArrayList<>();

    public ThreadMonitor(ArrayList<Thread> arrayThread) {
        this.arrayThread = arrayThread;
    }

    @Override
    public void run() {
        while (true){
            for (Thread t: this.arrayThread) {
                System.out.println(t.getState());
            }
            try {
                Thread.sleep(2000);
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }
    }
}
