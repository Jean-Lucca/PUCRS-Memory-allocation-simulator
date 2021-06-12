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

import java.io.IOException;
import java.util.LinkedList;
import java.util.*;

public class App {

    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        menu();

    }

    public static void menu() throws IOException{

        Reader r =  new Reader();
        System.out.println("Digite o nome do arquivo a ser lido:");
        r.read(scan.next()+".txt");
        ArrayList<Pair<Character, Integer>>  rl = r.getRequestList();
        FixedPartition fx =  new FixedPartition();
        fx.doFixedPartition(rl, 16, 4);
    }
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Reader {

	private ArrayList<Pair<Character, Integer>> requestList;
	
	public Reader() {
		requestList = new ArrayList<Pair<Character, Integer>>();
	}
	
    public void read(String path) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String linha = "";
		while (true) {
			if (linha != null) {
				String request = linha.trim().toLowerCase();

				if(request.contains("in")){
					Integer value = Integer.parseInt(request.split(",")[1].replace(")",""));
					requestList.add(new Pair<Character,Integer>(request.charAt(3), value));
				}
				else if(request.contains("out")){
					requestList.add(new Pair<Character,Integer>(request.charAt(4), 0));
				}
			}
			else
				break;
			linha = buffRead.readLine();
		}
		buffRead.close();
	}

	
	public ArrayList<Pair<Character, Integer>> getRequestList() {
		return requestList;
	}

	public void clearRequestList() {
		requestList.clear();
	}
	
}

public class Pair<T, U> {
    private T key;
    private U value;

    public Pair(T key, U value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public U getValue() {
        return value;
    }

    public void setValue(U value) {
        this.value = value;
    }

    public String toString() {
        return "("+key+","+value+")";
    }
}
