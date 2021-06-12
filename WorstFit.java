import java.util.ArrayList;

public class WorstFit implements Politica{

    @Override
    public int getIndice(ArrayList<Particao> memoria, Requisicao r) {
        int indice = -1;
        int aux = 0;
        for(int i=0; i<memoria.size(); ++i){
            if (!memoria.get(i).isOcupado()){
                if(memoria.get(i).getTamanho() >= r.getTamanho()
                    && memoria.get(i).getTamanho() > aux){
                    aux = memoria.get(i).getTamanho();
                    indice = i;
                }
            }
        }
        return indice;
    }
    
}
