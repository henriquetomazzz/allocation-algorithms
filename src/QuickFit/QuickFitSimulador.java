package QuickFit;

public class QuickFitSimulador {

    public static void main(String[] args) {
        System.out.println("### Simulador de Alocação de Memória: Quick Fit ###");

        QuickFitAllocator allocator = new QuickFitAllocator();


        allocator.imprimirEstadoMemoria();


        System.out.println("\n--- ALOCAÇÕES ---");

        // 2. Alocações de Tamanhos Populares (4096 KB e 8192 KB)
        allocator.alocar(4096, 101);
        allocator.alocar(8192, 102);

        // 3. Alocação de Tamanho Não Popular (10000 KB)

        allocator.alocar(10000, 103); // P103 (10MB - Não Popular)

        // 4. Alocação de um tamanho Popular, mas com "Split" (16384 KB)
        allocator.alocar(16384, 104); // P104 (16MB - Popular, mas não havia buraco exato)

        allocator.imprimirEstadoMemoria();

        System.out.println("\n--- DESALOCAÇÕES ---");

        // 5. Desalocação de um Popular (Retorna à lista popular - O(1))
        allocator.liberar(102); // Libera P102 (8192 KB)

        // 6. Desalocação de um Não Popular (Retorna à lista arbitrária)
        allocator.liberar(103); // Libera P103 (10000 KB)

        allocator.imprimirEstadoMemoria();

        System.out.println("\n--- RE-ALOCAÇÃO ---");

        // 7. Re-alocação (Pega o buraco de 8192 KB que foi liberado - O(1))
        allocator.alocar(8192, 105); // P105 (8MB)

        // 8. Alocação que falha (tamanho muito grande)
        allocator.alocar(80000, 106);

        allocator.imprimirEstadoMemoria();
    }
}
