import java.util.ArrayList;

public class Simulador {
    private ArrayList<Particao> memoria;
    private Politica politica;
    private int tamanhoDaParticao = -1;

    public Simulador(int tamanhoDaMemoria, Politica politica) {
        this.memoria = new ArrayList<>();
        this.memoria.add(new Particao("INIT",tamanhoDaMemoria , false));
        this.politica = politica;
    }

    //cria particoes fixas
    public Simulador(int tamanhoDaMemoria, int tamanhoDaParticao) {
        this.memoria = new ArrayList<>();
        this.tamanhoDaParticao = tamanhoDaParticao;
        for(int i=0;i<tamanhoDaMemoria/tamanhoDaParticao;i++) {
            this.memoria.add(i, new Particao("INIT",tamanhoDaParticao , false));
            memoria.get(i).setEspacoOcupado(0);
        }
    }

    public void run(Requisicao r) {
        System.out.println("Requisicao: "+r);
        if(r.getComando().equals("IN")) {
            if(tamanhoDaParticao != -1) {
                if(alocarMemoriaFixa(r) == -1) {
                    System.out.println("Não cabe");
                }
            } else {
                if(alocarMemoria(r) == -1) {
                    System.out.println("Não cabe ");
                }
            }
        }

        if(r.getComando().equals("OUT")) {
            if(tamanhoDaParticao != -1) {
                if(desalocarMemoriaFixa(r) == -1) {
                    System.out.println("inexistente bixo");
                }
            } else {
                if(desalocarMemoria(r) == -1) {
                    System.out.println("inexistente bixo");
                }
            }
        }
        if(tamanhoDaParticao != -1) {
            mostrarMemoriaFixa();
        } else {
            mostrarMemoria();
        }
    }

    //adiciona requisicao na primeira particao possivel sem redimensionar as particoes
    public int alocarMemoriaFixa(Requisicao r) {
        for(Particao p : memoria) {
            if(r.getTamanho() <= p.getTamanho() && p.getEspacoOcupado() == 0) {
                p.setEspacoOcupado(r.getTamanho());
                p.setId(r.getId());
                return 1;
            }
        }
        return -1;
    }

    //remove sem redimensionar as particoes
    public int desalocarMemoriaFixa(Requisicao r) {
        for(Particao p : memoria) {
            if(p.getId().equals(r.getId())) {
                p.setEspacoOcupado(0);
                return 1;
            }
        }
        return -1;
    }

    public int alocarMemoria(Requisicao r) {
        //procura o indice para inserir a particao na memoria de acordo com a politica selecionada
        Particao p = new Particao(r.getId(), r.getTamanho());
        int indice = politica.getIndice(memoria, r);
        
        if (indice == -1) {
            //não cabe
            return -1;
        }
        //particiona
        int resto = memoria.get(indice).getTamanho() - r.getTamanho();
        memoria.remove(indice);
        memoria.add(indice, p);
        if(resto != 0) {
            //se nao cabe direitinho cria uma particao nova vazia
            memoria.add(indice+1, new Particao("vazio", resto, false));
        }
        return indice;
    }

    //percorre a memoria e remove uma particao
    public int desalocarMemoria(Requisicao r) {
        for(Particao p : memoria) {
            if(p.getId().equals(r.getId()) && p.isOcupado()) {
                p.setOcupado(false);
                desfragmentar();
                return 1;
            }
        }
        return -1;
    }

    //Se tiver duas particoes vazias apaga uma e dimensiona o tamnho da outra
    public void desfragmentar() {
        for(int i=0; i<memoria.size()-1; i++) {
            if(!memoria.get(i).isOcupado()
               && !memoria.get(i+1).isOcupado()) {
                memoria.get(i).setTamanho(memoria.get(i+1).getTamanho() + 
                memoria.get(i).getTamanho());
                memoria.get(i).setEspacoOcupado(memoria.get(i+1).getEspacoOcupado() + 
                memoria.get(i).getEspacoOcupado());
                memoria.remove(i+1);
                i--;
            }
        }
    }

    //que coisa feia puta merda
    public void mostrarMemoriaFixa() {
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        for(Particao p : memoria) {
            int i =0;
            while(i < p.getTamanho()) {
                if(i < p.getEspacoOcupado()) {
                    tmp.add(1);
                } else {
                    tmp.add(0);
                }
                i++;
            }
        }

        int acc =0;
        ArrayList<Integer> aux = new ArrayList<Integer>();
        for(int i=0;i<tmp.size();i++) {
            if(tmp.get(i) == 0) {
                acc++;
            }

            if(tmp.get(i) == 1) {
                if(acc!=0) { aux.add(acc); }
                acc = 0;
            }
        }
        aux.add(acc);
        
        for(int i : aux) {
            System.out.print("| "+i+" |");
        }
        System.out.println();
        aux = new ArrayList<Integer>();
    }

    public void mostrarMemoria() {
        System.out.println("------------------");
        for(Particao p : memoria) {
            if(!p.isOcupado()) {
                System.out.print("| "+p.getTamanho()+" |");
            }
        }
        System.out.println();
    }
}
