import java.util.List;

public class BestFit {

    private List<BlocoMemoria> memoria;

    public BestFit(List<BlocoMemoria> memoria) {
        this.memoria = memoria;
    }

    public void alocar(Processo processo) {
        int melhorIndice = -1;
        int menorTamanhoRestante = Integer.MAX_VALUE;

        for (int i = 0; i < memoria.size(); i++) {
            BlocoMemoria bloco = memoria.get(i);


            if (!bloco.isAlocado() && bloco.getTamanho() >= processo.getTamanho()) {
                int tamanhoRestante = bloco.getTamanho() - processo.getTamanho();

                if (tamanhoRestante < menorTamanhoRestante) {
                    menorTamanhoRestante = tamanhoRestante;
                    melhorIndice = i;
                }
            }
        }

        if (melhorIndice != -1) {
            BlocoMemoria blocoEscolhido = memoria.get(melhorIndice);

            blocoEscolhido.setAlocado(true);
            blocoEscolhido.setIdProcessoAlocado(processo.getId());

            System.out.println("Processo " + processo.getId() + " (tamanho " + processo.getTamanho() +
                    ") alocado no Bloco " + blocoEscolhido.getId() +
                    " (tamanho " + blocoEscolhido.getTamanho() + ").");
        } else {
            System.out.println("Falha: Não foi encontrado espaço para alocar o Processo " + processo.getId() +
                    " (tamanho " + processo.getTamanho() + ").");
        }
    }

    public void exibirMemoria() {
        System.out.println("\n--- Estado da Memória ---");
        for (BlocoMemoria bloco : memoria) {
            System.out.println(bloco);
        }
        System.out.println("------------------------\n");
    }
}