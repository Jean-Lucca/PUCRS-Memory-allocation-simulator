public class Particao {
    
    private String id;
    private int tamanho;
    private int espacoOcupado = 0;
    private int indice = -1;
    private boolean ocupado = false;
    
    public Particao(int indice, String id, int tamanho, boolean ocupado){
        this.indice = indice;
        this.ocupado = ocupado;
        this.id = id;
        this.tamanho = tamanho;
        this.espacoOcupado = tamanho;
    }

    public Particao(String id, int tamanho){
        this.indice = -1;
        this.ocupado = true;
        this.id = id;
        this.tamanho = tamanho;
        this.espacoOcupado = tamanho;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public String getId() {
        return id;
    }

    public int getTamanho() {
        return tamanho;
    }

    public int getIndice() {
        return indice;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    
    public void setIndice(int indice) {
        this.indice = indice;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public void setEspacoOcupado(int espacoOcupado) {
        this.espacoOcupado = espacoOcupado;
    }
    public int getEspacoOcupado() {
        return espacoOcupado;
    }
}