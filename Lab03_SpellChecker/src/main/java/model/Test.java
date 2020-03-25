package model;

import java.util.List;

public class Test {
	
	private void run() {
		Dictionary dizionario=new Dictionary();
		dizionario.loadDictionary("Italian");
		System.out.println(dizionario.getDizionario().get(900));
		String verifica="ciao mi chiamo enrico, e ho 21 anni ma sjhkgsehjsdjkbk sdihfsike hsdfdohdaoi ciao";
		List <String> stringadivisa=dizionario.divisione(verifica);
		List <RichWord> stampa=dizionario.spellCheckText(stringadivisa);
		for(RichWord r:stampa) {
			if(r.isCorretto()==true) {
				System.out.println("la parola "+r+" è scritta correttamente\n");
			}
			else
				System.out.println("la parola "+r+" è scritta male\n");
		}
	}
	

	public static void main(String[] args) {
		Test prova=new Test();
		prova.run();
		// TODO Auto-generated method stub
	}

}
