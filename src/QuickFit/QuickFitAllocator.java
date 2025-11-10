package QuickFit;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class QuickFitAllocator {

    private final Map<Integer, LinkedList<BlocoMemoria>> freeLists;

    private final LinkedList<BlocoMemoria> arbitraryList;

    private final LinkedList<BlocoMemoria> memoriaPrincipal;

    public QuickFitAllocator() {
        this.freeLists = new HashMap<>();
        this.arbitraryList = new LinkedList<>();
        this.memoriaPrincipal = new LinkedList<>();


        adicionarTamanhoPopular(4096);
        adicionarTamanhoPopular(8192);
        adicionarTamanhoPopular(16384);


        BlocoMemoria memoriaTotal = new BlocoMemoria(0, 102400, 0);
        this.arbitraryList.add(memoriaTotal);
        this.memoriaPrincipal.add(memoriaTotal);
    }

    private void adicionarTamanhoPopular(int tamanho) {
        freeLists.put(tamanho, new LinkedList<>());
    }


    public boolean alocar(int tamanhoProcesso, int idProcesso) {

        if (freeLists.containsKey(tamanhoProcesso) && !freeLists.get(tamanhoProcesso).isEmpty()) {
            BlocoMemoria bloco = freeLists.get(tamanhoProcesso).removeFirst();
            bloco.setIdProcesso(idProcesso);
            System.out.println("Quick Fit: Alocado P" + idProcesso + " em um bloco de tamanho exato " + tamanhoProcesso + " KB.");
            return true;
        }




        for (BlocoMemoria bloco : arbitraryList) {
            if (bloco.getIdProcesso() == 0 && bloco.getTamanho() >= tamanhoProcesso) {


                arbitraryList.remove(bloco);


                bloco.setIdProcesso(idProcesso);


                int sobra = bloco.getTamanho() - tamanhoProcesso;
                bloco.tamanho = tamanhoProcesso;

                if (sobra > 0) {
                    BlocoMemoria novoLivre = new BlocoMemoria(0, sobra, bloco.getEnderecoInicial() + tamanhoProcesso);


                    if (freeLists.containsKey(sobra)) {
                        freeLists.get(sobra).add(novoLivre);
                        System.out.println("Alocado P" + idProcesso + " (Tamanho não popular). Sobra " + sobra + " KB adicionada à lista popular.");
                    } else {
                        arbitraryList.addFirst(novoLivre);
                        System.out.println("⚠Alocado P" + idProcesso + " (Tamanho não popular). Sobra " + sobra + " KB adicionada à lista arbitrária.");
                    }


                    int index = memoriaPrincipal.indexOf(bloco);
                    if (index != -1) {
                        memoriaPrincipal.add(index + 1, novoLivre);
                    }
                } else {
                    System.out.println("First Fit (Lista Arbitrária): Alocado P" + idProcesso + " (Tamanho exato no bloco arbitrário).");
                }

                return true;
            }
        }

        System.out.println("Falha na Alocação: Não foi encontrado espaço livre para P" + idProcesso + " (" + tamanhoProcesso + " KB).");
        return false;
    }

    public boolean liberar(int idProcesso) {
        for (BlocoMemoria bloco : memoriaPrincipal) {
            if (bloco.getIdProcesso() == idProcesso) {
                bloco.liberar();

                int tamanhoLiberado = bloco.getTamanho();


                if (freeLists.containsKey(tamanhoLiberado)) {
                    freeLists.get(tamanhoLiberado).addFirst(bloco);
                    System.out.println("Quick Fit: Liberado P" + idProcesso + " e adicionado de volta à lista popular de " + tamanhoLiberado + " KB.");
                    return true;
                }


                arbitraryList.addFirst(bloco);
                System.out.println("Liberado P" + idProcesso + " e adicionado de volta à lista arbitrária.");
                return true;
            }
        }
        System.out.println("Falha na Desalocação: Processo P" + idProcesso + " não encontrado.");
        return false;
    }

    public void imprimirEstadoMemoria() {
        System.out.println("\n--- Estado da Memória (Quick Fit) ---");
        long totalLivre = 0;
        for (BlocoMemoria bloco : memoriaPrincipal) {
            System.out.println(bloco);
            if (bloco.getIdProcesso() == 0) {
                totalLivre += bloco.getTamanho();
            }
        }
        System.out.println("Total de Memória Livre: " + totalLivre + " KB");
        System.out.println("------------------------------------");
    }
}
