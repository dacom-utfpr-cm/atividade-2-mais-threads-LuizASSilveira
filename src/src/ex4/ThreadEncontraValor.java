package ex4;

public class ThreadEncontraValor extends Thread {
    private int inicialintevalo;
    private int finalIntervalo;
    private int[] array;
    private int valorEncontrar;

    public ThreadEncontraValor(int valorEncontrar, int inicialintevalo, int finalIntervalo, int[] array) {

        this.valorEncontrar = valorEncontrar;
        this.inicialintevalo = inicialintevalo;
        this.finalIntervalo = finalIntervalo;
        this.array = array;
    }

    @Override
    public void run() {
        for (int i = this.inicialintevalo; i < this.finalIntervalo ; i++) {
            if(this.array[i] == this.valorEncontrar){
                System.out.println("Encontrou na posição:" + String.valueOf(i));
                break;
            }
        }
    }
}
