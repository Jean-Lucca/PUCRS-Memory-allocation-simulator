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
