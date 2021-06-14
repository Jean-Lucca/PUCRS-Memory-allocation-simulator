import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Leitor {
    
	private LinkedList<Requisicao> listaDeRequisicoes;
	
	public Leitor() {
		listaDeRequisicoes = new LinkedList<Requisicao>();
	}
	
    public void le(String path) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String linha = buffRead.readLine();

		while (true) {
			if (linha != null) {

				if(linha.charAt(0) == 'I') {
                    listaDeRequisicoes.add(novaEntrada(linha));
                }
                
                if(linha.charAt(0) == 'O') {
                    listaDeRequisicoes.add(novaSaida(linha));
                }

				linha = buffRead.readLine();

			} else {
				break;
			}
		}
		buffRead.close();
	}

    public Requisicao novaEntrada(String linha) {
        String parsed[] = parse(linha).split(",");
        int indice =  Integer.valueOf(parsed[1].trim());
        return new Requisicao("IN", parsed[0].trim(), indice);
    }

    public Requisicao novaSaida(String linha) {
        return new Requisicao("OUT", parse(linha));
    }

    public static String parse(String linha) {
        return linha.substring(linha.indexOf("(")+1, linha.indexOf(")"));
    }

    public LinkedList<Requisicao> getListaDeRequisicoes() {
        return listaDeRequisicoes;
    }
}
