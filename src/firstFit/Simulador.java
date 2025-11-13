package firstFit;

import java.util.*;

public class Simulador {
    public static void main(String[] args) {
        List<BlocoMemoria> blocos = new ArrayList<>();
        blocos.add(new BlocoMemoria(1, 100));
        blocos.add(new BlocoMemoria(2, 500));
        blocos.add(new BlocoMemoria(3, 200));
        blocos.add(new BlocoMemoria(4, 300));

        List<Processo> processos = new ArrayList<>();
        processos.add(new Processo("P1", 120));
        processos.add(new Processo("P2", 80));
        processos.add(new Processo("P3", 200));
        processos.add(new Processo("P4", 350));

        FirstFit firstFit = new FirstFit();

        for (Processo p : processos) {
            firstFit.alocarProcesso(p, blocos);
        }

        firstFit.exibirEstadoMemoria(blocos);

        firstFit.liberarProcesso("P2", blocos);
        firstFit.exibirEstadoMemoria(blocos);

        Processo novo = new Processo("P5", 90);
        firstFit.alocarProcesso(novo, blocos);
        firstFit.exibirEstadoMemoria(blocos);
    }
}
