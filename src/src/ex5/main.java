//Faça um programa multithreaded em Java que ordene um vetor usando o Merge Sort recursivo. Faça com que a thread
// principal dispare duas threads para classificar cada metade do vetor.
//LuizASSilveira
package ex5;

public class main {
    public static void main(String[] args) {
        int arr[] ={99,38,63,44,23,11,10,56} ;
        MergeSorter mr = new MergeSorter(arr,0,arr.length-1);
        Thread t = new Thread(mr);
        t.start();

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i :mr.getResultArr())
            System.out.print(i+" ");
    }
}
