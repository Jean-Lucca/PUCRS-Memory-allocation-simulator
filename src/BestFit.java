import java.util.ArrayList;

public class BestFit implements Politica{

    @Override
    public int getIndice(ArrayList<Particao> memoria, Requisicao r) {
        int indice = -1;
        int aux = memoria.stream().mapToInt(p->p.getTamanho()).sum()+1;
        for(int i=0; i<memoria.size(); i++) {
            if(!memoria.get(i).isOcupado()) {
                if (memoria.get(i).getTamanho() >= r.getTamanho() 
                && memoria.get(i).getTamanho() < aux) {
                    aux = memoria.get(i).getTamanho();
                    indice = i;
                }
            }
        }
        return indice;
    }
    
}
