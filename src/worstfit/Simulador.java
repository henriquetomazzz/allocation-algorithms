package worstfit;

import java.util.ArrayList;
import java.util.List;

public class Simulador {

    public static void main(String[] args) {
        List<BlocoMemoria> blocos = new ArrayList<>();
        blocos.add(new BlocoMemoria(100));
        blocos.add(new BlocoMemoria(500));
        blocos.add(new BlocoMemoria(200));
        blocos.add(new BlocoMemoria(300));

        List<Processo> processos = new ArrayList<>();
        processos.add(new Processo("P1", 120));
        processos.add(new Processo("P2", 80));
        processos.add(new Processo("P3", 200));
        processos.add(new Processo("P4", 350));

        WorstFit worstFit = new WorstFit();
        worstFit.exibirEstadoMemoria(blocos);

        for (Processo p : processos) {
            worstFit.alocarProcesso(p, blocos);
        }
        worstFit.exibirEstadoMemoria(blocos);

        worstFit.liberarProcesso("P1", blocos);
        worstFit.exibirEstadoMemoria(blocos);

        Processo novoProcesso = new Processo("P5", 90);
        worstFit.alocarProcesso(novoProcesso, blocos);
        worstFit.exibirEstadoMemoria(blocos);
    }
}