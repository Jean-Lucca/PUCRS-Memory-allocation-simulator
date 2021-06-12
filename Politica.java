import java.util.ArrayList;

public interface Politica {
    int getIndice(ArrayList<Particao> memoria, Requisicao r);
}
