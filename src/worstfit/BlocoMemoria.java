package worstfit;

public class BlocoMemoria {
    private Processo processo;
    private int tamanho;
    private boolean ocupado;
    private int id;
    private static int contadorId = 0;

    public BlocoMemoria(int tamanho) {
        this.id = ++contadorId;
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
        if (ocupado) {
            return "Bloco " + id + " | Tamanho: " + tamanho + "KB | Ocupado por: " + processo.getNome();
        } else {
            return "Bloco " + id + " | Tamanho: " + tamanho + "KB | Livre";
        }
    }
}