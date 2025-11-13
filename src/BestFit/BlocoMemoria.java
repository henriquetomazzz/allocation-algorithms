public class BlocoMemoria {
    private int id;
    private int tamanho;
    private boolean alocado;
    private int idProcessoAlocado;

    public BlocoMemoria(int id, int tamanho) {
        this.id = id;
        this.tamanho = tamanho;
        this.alocado = false;
        this.idProcessoAlocado = -1;
    }

    public int getId() {
        return id;
    }

    public int getTamanho() {
        return tamanho;
    }

    public boolean isAlocado() {
        return alocado;
    }

    public void setAlocado(boolean alocado) {
        this.alocado = alocado;
    }

    public int getIdProcessoAlocado() {
        return idProcessoAlocado;
    }

    public void setIdProcessoAlocado(int idProcessoAlocado) {
        this.idProcessoAlocado = idProcessoAlocado;
    }

    public String toString() {
        return "Bloco " + id + " [Tamanho: " + tamanho + ", Alocado: " + (alocado ? "Sim, Processo " + idProcessoAlocado : "Não") + "]";
    }
}