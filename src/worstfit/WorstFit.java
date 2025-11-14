package worstfit;

import java.util.List;

public class WorstFit {

    public boolean alocarProcesso(Processo processo, List<BlocoMemoria> blocos) {
        BlocoMemoria piorBloco = null;

        for (BlocoMemoria bloco : blocos) {
            if (!bloco.isOcupado() && bloco.getTamanho() >= processo.getTamanho()) {
                if (piorBloco == null || bloco.getTamanho() > piorBloco.getTamanho()) {
                    piorBloco = bloco;
                }
            }
        }

        if (piorBloco == null) {
            System.out.println("Nenhum bloco disponível para o processo " + processo.getNome());
            return false;
        }

        piorBloco.alocar(processo);
        System.out.println("Processo " + processo.getNome() + " alocado no Bloco " + piorBloco.getId());
        return true;
    }

    public void liberarProcesso(String nomeProcesso, List<BlocoMemoria> blocos) {
        for (BlocoMemoria bloco : blocos) {
            if (bloco.isOcupado() && bloco.getProcesso().getNome().equalsIgnoreCase(nomeProcesso)) {
                System.out.println("Processo " + nomeProcesso + " liberado do Bloco " + bloco.getId());
                bloco.liberar();
                return;
            }
        }
        System.out.println("Processo " + nomeProcesso + " não encontrado.");
    }

    public void exibirEstadoMemoria(List<BlocoMemoria> blocos) {
        System.out.println("\n--- ESTADO ATUAL DA MEMÓRIA ---");
        for (BlocoMemoria bloco : blocos) {
            System.out.println(bloco);
        }
        System.out.println("--------------------------------\n");
    }
}