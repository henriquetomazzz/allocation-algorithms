package QuickFit;

public class BlocoMemoria {
    private int idProcesso;
    int tamanho;
    private int enderecoInicial;

    public BlocoMemoria(int idProcesso, int tamanho, int enderecoInicial) {
        this.idProcesso = idProcesso;
        this.tamanho = tamanho;
        this.enderecoInicial = enderecoInicial;
    }

    // Getters e Setters
    public int getIdProcesso() { return idProcesso; }
    public int getTamanho() { return tamanho; }
    public int getEnderecoInicial() { return enderecoInicial; }

    public void setIdProcesso(int idProcesso) { this.idProcesso = idProcesso; }


    public void liberar() {
        this.idProcesso = 0;
    }

    @Override
    public String toString() {
        String status = (idProcesso == 0) ? "LIVRE" : "OCUPADO (P" + idProcesso + ")";
        return String.format("[End: %d, Tam: %d KB, Status: %s]", enderecoInicial, tamanho, status);
    }
}