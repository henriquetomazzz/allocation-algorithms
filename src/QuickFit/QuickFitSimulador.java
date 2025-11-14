package QuickFit;

public class QuickFitSimulador {

    public static void main(String[] args) {
        System.out.println("### Simulador de Alocação de Memória: Quick Fit ###");

        QuickFitAllocator allocator = new QuickFitAllocator();


        allocator.imprimirEstadoMemoria();


        System.out.println("\n--- ALOCAÇÕES ---");

        allocator.alocar(4096, 101);
        allocator.alocar(8192, 102);

        allocator.alocar(10000, 103);

        allocator.alocar(16384, 104);

        allocator.imprimirEstadoMemoria();

        System.out.println("\n--- DESALOCAÇÕES ---");

        allocator.liberar(102);

        allocator.liberar(103);

        allocator.imprimirEstadoMemoria();

        System.out.println("\n--- RE-ALOCAÇÃO ---");

        allocator.alocar(8192, 105);

        allocator.alocar(80000, 106);

        allocator.imprimirEstadoMemoria();
    }
}
