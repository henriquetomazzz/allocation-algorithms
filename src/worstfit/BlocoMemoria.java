package worstfit;

public class BlocoMemoria {
    int idProcesso;
    int enderecoInicial;
    int tamanho;
    boolean livre;

    public BlocoMemoria(int enderecoInicial, int tamanho) {
        this.enderecoInicial = enderecoInicial;
        this.tamanho = tamanho;
        this.livre = true;
        this.idProcesso = -1;
    }

    @Override
    public String toString() {
        String estado = livre ? "Livre" : "Ocupado por P" + idProcesso;
        return String.format("Bloco[Endereço=%-4d, Tamanho=%-4dKB, %s]", enderecoInicial, tamanho, estado);
    }
}