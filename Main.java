import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static Leitor l = new Leitor();
    public static Simulador sim;
    public static void main(String[] args) throws IOException {
        menu();
        for(Requisicao r : l.getListaDeRequisicoes()) { sim.run(r); }
        sim.mostrarMemoria();
    }

    public static void menu() throws IOException {

        System.out.println("Nome do arquivo");
        l.le(scan.next()+".txt");

        System.out.println("1. fixo");
        System.out.println("2. variavel");
        System.out.println("0. sair");

        int op = scan.nextInt();
        if(op == 1) { menuFixo(); }
        if(op == 2) { menuVariavel(); }
        if(op == 0) { return; }
    }

    public static void menuFixo() {
        System.out.println("Tamanho da memoria");
        int tamanhoDaMemoria = scan.nextInt();
        System.out.println("Tamaho das particoes");
        int tamanhoDaParticao = scan.nextInt();
        if(tamanhoDaMemoria / tamanhoDaParticao < 0) { System.out.println("não cabe filho"); }
        else {
            System.out.println("memoria"+tamanhoDaMemoria);
            System.out.println("part"+tamanhoDaParticao);
            sim = new Simulador(tamanhoDaMemoria, tamanhoDaParticao);
        }
    }

    public static void menuVariavel() {
        System.out.println("Tamanho da memoria");
        int tamanhoDaMemoria = scan.nextInt();
        System.out.println("Politica");
        System.out.println("1. Best-Fit");
        System.out.println("2. Worst-FIt");
        System.out.println("0. Sair");
        int op = scan.nextInt();
        if(op == 1) { sim = new Simulador(tamanhoDaMemoria, new BestFit()); }
        if(op == 2) { sim = new Simulador(tamanhoDaMemoria, new WorstFit()); }
    }

}
