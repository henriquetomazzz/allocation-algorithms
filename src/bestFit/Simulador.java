package bestFit;

import java.util.ArrayList;
import java.util.List;

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

        BestFit bestFit = new BestFit();

        System.out.println("INICIANDO SIMULAÇÃO COM BESTFIT");

        for (Processo p : processos) {
            bestFit.alocarProcesso(p, blocos);
        }

        bestFit.exibirEstadoMemoria(blocos);

        bestFit.liberarProcesso("P2", blocos);
        bestFit.exibirEstadoMemoria(blocos);

        Processo novo = new Processo("P5", 90);
        bestFit.alocarProcesso(novo, blocos);
        bestFit.exibirEstadoMemoria(blocos);
    }
}