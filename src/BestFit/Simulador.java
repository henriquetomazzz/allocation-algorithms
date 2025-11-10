import java.util.ArrayList;
import java.util.List;

public class Simulador {

    public static void main(String[] args) {

        List<BlocoMemoria> blocos = new ArrayList<>();
        blocos.add(new BlocoMemoria(1, 100));
        blocos.add(new BlocoMemoria(2, 500));
        blocos.add(new BlocoMemoria(3, 200));
        blocos.add(new BlocoMemoria(4, 300));
        blocos.add(new BlocoMemoria(5, 600));

        BestFit gerenciadorMemoria = new BestFit(blocos);

        System.out.println("Estado inicial da memória:");
        gerenciadorMemoria.exibirMemoria();

        Processo p1 = new Processo(1, 212);
        Processo p2 = new Processo(2, 417);
        Processo p3 = new Processo(3, 112);
        Processo p4 = new Processo(4, 426);

        gerenciadorMemoria.alocar(p1);
        gerenciadorMemoria.exibirMemoria();

        gerenciadorMemoria.alocar(p2);
        gerenciadorMemoria.exibirMemoria();

        gerenciadorMemoria.alocar(p3);
        gerenciadorMemoria.exibirMemoria();

        gerenciadorMemoria.alocar(p4);
        gerenciadorMemoria.exibirMemoria();
    }
}