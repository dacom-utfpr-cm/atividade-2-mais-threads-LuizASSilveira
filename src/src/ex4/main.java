// Faça um programa em Java que realize uma busca paralela em um vetor de inteiros.
// Informe para o método: valor procurado, vetor de inteiros e o número de threads.
// LuizASSilveira

package ex4;

import java.util.ArrayList;

public class main {

    public static void main(String[] args){
        int[] array = {2,5,12,56,6,4,7,10,9,89,34,21};
        encontraNumeroInteiro(10,array,5);
    }

    private static void encontraNumeroInteiro(Integer val, int[] arrayInt, Integer numThread){
        ThreadGroup group = new ThreadGroup("LuizThreads");
        ArrayList<Thread> arrayThred = new ArrayList<>();
        Integer intervalo = arrayInt.length / numThread;

        for (int i = 0; i < numThread; i++) {
            int inicial = i*intervalo;
            int interacaoFinal;

            if(i == (numThread-1)){
                interacaoFinal = arrayInt.length;
            }else{
                interacaoFinal = inicial + intervalo;
            }
            arrayThred.add(i,new Thread(group, new Thread(new ThreadEncontraValor(val, inicial, interacaoFinal, arrayInt)),"t".concat(String.valueOf(i))));
            arrayThred.get(i).start();
        }
    }


}
