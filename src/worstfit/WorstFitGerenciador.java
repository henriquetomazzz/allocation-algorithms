package worstfit;

import java.util.LinkedList;
import java.util.ListIterator;

public class WorstFitGerenciador {
    private LinkedList<BlocoMemoria> memoria;
    private int tamanhoTotal;


    public WorstFitGerenciador(int tamanhoTotal) {
        this.tamanhoTotal = tamanhoTotal;
        memoria = new LinkedList<>();
        memoria.add(new BlocoMemoria(0, tamanhoTotal));
    }

    public boolean alocar(int idProcesso, int tamanho) {
        System.out.println("\n>> Tentando alocar P" + idProcesso + " com " + tamanho + "KB...");

        BlocoMemoria piorBloco = null;
        int indicePiorBloco = -1;

        for (int i = 0; i < memoria.size(); i++) {
            BlocoMemoria blocoAtual = memoria.get(i);
            if (blocoAtual.livre && blocoAtual.tamanho >= tamanho) {
                if (piorBloco == null || blocoAtual.tamanho > piorBloco.tamanho) {
                    piorBloco = blocoAtual;
                    indicePiorBloco = i;
                }
            }
        }

        if (piorBloco == null) {
            System.out.println("!! Falha na alocação: Não há espaço contíguo suficiente para P" + idProcesso);
            return false;
        }

        if (piorBloco.tamanho > tamanho) {
            BlocoMemoria novoBlocoLivre = new BlocoMemoria(
                    piorBloco.enderecoInicial + tamanho,
                    piorBloco.tamanho - tamanho
            );
            piorBloco.tamanho = tamanho;
            memoria.add(indicePiorBloco + 1, novoBlocoLivre);
        }

        piorBloco.livre = false;
        piorBloco.idProcesso = idProcesso;

        System.out.println(">> Sucesso: P" + idProcesso + " alocado no endereço " + piorBloco.enderecoInicial);
        return true;
    }

    public void liberar(int idProcesso) {
        System.out.println("\n<< Tentando liberar P" + idProcesso + "...");

        ListIterator<BlocoMemoria> iterator = memoria.listIterator();

        while (iterator.hasNext()) {
            BlocoMemoria atual = iterator.next();

            if (!atual.livre && atual.idProcesso == idProcesso) {
                atual.livre = true;
                atual.idProcesso = -1;
                System.out.println("<< Liberado: Bloco de " + atual.tamanho + "KB no endereço " + atual.enderecoInicial);

                if (iterator.hasNext()) {
                    BlocoMemoria proximo = iterator.next();
                    if (proximo.livre) {
                        atual.tamanho += proximo.tamanho;
                        iterator.remove();
                        System.out.println("...bloco mesclado com o seguinte.");
                    }
                }

                int indiceAtual = memoria.indexOf(atual);
                if (indiceAtual > 0) {
                    BlocoMemoria anterior = memoria.get(indiceAtual - 1);
                    if (anterior.livre) {
                        anterior.tamanho += atual.tamanho;
                        memoria.remove(indiceAtual);
                        System.out.println("...bloco mesclado com o anterior.");
                    }
                }

                return;
            }
        }
        System.out.println("!! Falha na liberação: Processo P" + idProcesso + " não encontrado.");
    }

    public void imprimirEstadoMemoria() {
        System.out.println("\n--- Estado da Memória ---");
        for (BlocoMemoria bloco : memoria) {
            System.out.println(bloco);
        }
        System.out.println("-------------------------\n");
    }
}