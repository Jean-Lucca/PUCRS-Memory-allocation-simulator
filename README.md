import java.util.ArrayList;

public class FixedPartition {
    public void doFixedPartition(ArrayList<Pair<Character, Integer>> rl, Integer tamanho, Integer n){
        ArrayList<Pair<Character, Integer>> lst  = new ArrayList<Pair<Character, Integer>>();
        for (int i=0; i < rl.size(); i ++){
            if(rl.get(i).getValue() == 0){
                System.out.println("OUT("+rl.get(i).getKey()+")");
            }
            else{
                lst.add(new Pair<Character,Integer>(rl.get(i).getKey(), rl.get(i).getValue()));
                lst.add(new Pair<Character,Integer>(rl.get(i).getKey(), tamanho/n - rl.get(i).getValue()));
                String aux = "";
                for (int j=0; j < lst.size(); j ++){
                    if(j%2 != 0){
                        aux = aux + "|" + lst.get(j).getValue();
                    }
                }
                System.out.println("IN("+rl.get(i).getKey()+","+rl.get(i).getValue()+")  :" + aux);

            }
        }
    }
}
