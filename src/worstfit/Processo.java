package worstfit;

public class Processo {
    private String nome;
    private int tamanho;

    public Processo(String nome, int tamanho) {
        this.nome = nome;
        this.tamanho = tamanho;
    }

    public String getNome() {
        return nome;
    }

    public int getTamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        return nome + " (" + tamanho + "KB)";
    }
}
