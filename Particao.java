public class Particao {
    
    private String id;
    private int tamanho;
    private int espacoOcupado = 0;
    private boolean ocupado = false;
    
    public Particao(String id, int tamanho, boolean ocupado){
        this.ocupado = ocupado;
        this.id = id;
        this.tamanho = tamanho;
        this.espacoOcupado = tamanho;
    }

    public Particao(String id, int tamanho){
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

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
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