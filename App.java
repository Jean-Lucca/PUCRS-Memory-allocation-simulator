import java.io.IOException;
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
