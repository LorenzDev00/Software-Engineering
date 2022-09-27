package Calculator2;

public class Main {
	public static void main(String[] args) {
		Readfile r = new Readfile();
		r.openFile();
		r.readFile();
		r.closeFile();
	}

}
