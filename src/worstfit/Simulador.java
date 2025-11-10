package worstfit;

public class Simulador {
    public static void main(String[] args) {
        WorstFitGerenciador gerenciador = new WorstFitGerenciador(1024);
        System.out.println("Memória inicializada com 1024KB.");
        gerenciador.imprimirEstadoMemoria();


        gerenciador.alocar(1, 212); // P1
        gerenciador.imprimirEstadoMemoria();

        gerenciador.alocar(2, 417); // P2
        gerenciador.imprimirEstadoMemoria();

        gerenciador.alocar(3, 112);
        gerenciador.imprimirEstadoMemoria();

        gerenciador.alocar(4, 426);
        gerenciador.imprimirEstadoMemoria();

        gerenciador.liberar(2);
        gerenciador.imprimirEstadoMemoria();

        gerenciador.alocar(4, 100); // P4 com 100KB
        gerenciador.imprimirEstadoMemoria();

        gerenciador.liberar(3);
        gerenciador.imprimirEstadoMemoria();

        gerenciador.liberar(4);
        gerenciador.imprimirEstadoMemoria();

        gerenciador.liberar(1);
        gerenciador.imprimirEstadoMemoria();
    }
}