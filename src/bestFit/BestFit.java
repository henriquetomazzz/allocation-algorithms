package bestFit;

import java.util.List;

public class BestFit {

    public boolean alocarProcesso(Processo processo, List<BlocoMemoria> blocos) {
        BlocoMemoria melhorBlocoEncontrado = null;
        int menorEspacoRestante = Integer.MAX_VALUE;

        for (BlocoMemoria bloco : blocos) {
            if (!bloco.isOcupado() && bloco.getTamanho() >= processo.getTamanho()) {
                int espacoRestante = bloco.getTamanho() - processo.getTamanho();

                if (espacoRestante < menorEspacoRestante) {
                    menorEspacoRestante = espacoRestante;
                    melhorBlocoEncontrado = bloco;
                }
            }
        }

        if (melhorBlocoEncontrado != null) {
            melhorBlocoEncontrado.alocar(processo);
            System.out.println("Processo " + processo.getNome() + " alocado no Bloco " + melhorBlocoEncontrado.getId());
            return true;
        }

        System.out.println("Nenhum bloco disponível para o processo " + processo.getNome());
        return false;
    }

    public void liberarProcesso(String nomeProcesso, List<BlocoMemoria> blocos) {
        for (BlocoMemoria bloco : blocos) {
            if (bloco.isOcupado() && bloco.getProcesso().getNome().equalsIgnoreCase(nomeProcesso)) {
                bloco.liberar();
                System.out.println("Processo " + nomeProcesso + " liberado do Bloco " + bloco.getId());
                return;
            }
        }
        System.out.println("Processo " + nomeProcesso + " não encontrado.");
    }

    public void exibirEstadoMemoria(List<BlocoMemoria> blocos) {
        System.out.println("\nESTADO ATUAL DA MEMÓRIA\n");
        for (BlocoMemoria bloco : blocos) {
            System.out.println(bloco);
        }
    }
}