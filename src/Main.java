import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static Leitor l = new Leitor();
    public static Simulador sim;
    public static void main(String[] args) throws IOException {
        menu(args[0]);
        for(Requisicao r : l.getListaDeRequisicoes()) { sim.run(r); }
    }

    public static void menu(String arquivo) throws IOException {

        l.le(arquivo);

        System.out.println("1. Particoes Fixas");
        System.out.println("2. Particoes Variaveis");
        System.out.println("0. Sair");

        int op = scan.nextInt();
        if(op == 1) { menuFixo(); }
        if(op == 2) { menuVariavel(); }
        if(op == 0) { return; }
    }

    public static void menuFixo() {
        System.out.println("Tamanho da memoria");
        int tamanhoDaMemoria = scan.nextInt();

        System.out.println("Tamanho das particoes");
        int tamanhoDaParticao = scan.nextInt();
        
        tamanhoDaMemoria = (int) Math.pow(2, tamanhoDaMemoria);
        tamanhoDaParticao = (int) Math.pow(2, tamanhoDaParticao);

        if(tamanhoDaMemoria / tamanhoDaParticao < 1) { 
            System.out.println("O tamanho de particao nao pode ser maior que a memoria");
            menuFixo();
        } else {
            sim = new Simulador(tamanhoDaMemoria, tamanhoDaParticao);
        }
    }

    public static void menuVariavel() {
        System.out.println("Tamanho da memoria");
        int tamanhoDaMemoria = scan.nextInt();
        System.out.println("Politica de alocacao");
        System.out.println("1. Best-Fit");
        System.out.println("2. Worst-FIt");
        int op = scan.nextInt();
        if(op == 1) { sim = new Simulador((int) Math.pow(2, tamanhoDaMemoria), new BestFit()); }
        if(op == 2) { sim = new Simulador((int) Math.pow(2, tamanhoDaMemoria), new WorstFit()); }
    }

}
