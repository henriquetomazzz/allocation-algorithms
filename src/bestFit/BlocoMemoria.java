package bestFit;

public class BlocoMemoria {
    private int id;
    private int tamanho;
    private boolean ocupado;
    private Processo processo;

    public BlocoMemoria(int id, int tamanho) {
        this.id = id;
        this.tamanho = tamanho;
        this.ocupado = false;
        this.processo = null;
    }

    public int getId() {
        return id;
    }

    public int getTamanho() {
        return tamanho;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public Processo getProcesso() {
        return processo;
    }

    public void alocar(Processo p) {
        this.processo = p;
        this.ocupado = true;
    }

    public void liberar() {
        this.processo = null;
        this.ocupado = false;
    }

    @Override
    public String toString() {
        if (ocupado)
            return "Bloco " + id + " Tamanho: " + tamanho + " Ocupado por: " + processo.getNome();
        else
            return "Bloco " + id + " Tamanho: " + tamanho + " Livre";
    }
}