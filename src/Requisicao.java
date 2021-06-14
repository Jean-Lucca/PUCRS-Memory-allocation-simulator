public class Requisicao {
    private String comando;
    private String id;
    private int tamanho;

    public Requisicao(String comando, String id, int tamanho) {
        this.comando = comando;
        this.id = id;
        this.tamanho = tamanho;
    }

    public Requisicao(String comando, String id) {
        this.comando = comando;
        this.id = id;
    }
    
    public String getComando() {
        return comando;
    }

    public String getId() {
        return id;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setComando(String comando) {
        this.comando = comando;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        if(comando.equals("OUT")) { return "("+comando+", "+id+")";}
        return "("+comando+", "+id+", "+tamanho+")";
    }
}
