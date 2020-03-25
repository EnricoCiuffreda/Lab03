package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Dictionary {
	List <String> dizionario=new ArrayList<>();
	
	
	
	public Dictionary() {
	}

	public void loadDictionary(String language) {
		try {
			FileReader fr = null;
			if(language.equals("English")) {
				fr=new FileReader("C:\\Users\\Enrico\\git\\Lab03\\Lab03_SpellChecker\\src\\main\\resources\\English.txt");
			}
			if(language.equals("Italian")) {
				fr=new FileReader("C:\\Users\\Enrico\\git\\Lab03\\Lab03_SpellChecker\\src\\main\\resources\\Italian.txt");
			}
			   BufferedReader br=new BufferedReader(fr);
			   String word;
			   while((word = br.readLine()) != null) {
				   dizionario.add(word);
			   }
			   br.close();
			   fr.close();
		} catch(IOException e) {
			System.out.println("Errore nella lettura del file");
		}
	}
	
	public List <RichWord> spellCheckText(List <String> inputTextList){
		List <RichWord> correzione= new ArrayList<>();
		for(String s: inputTextList) {
			s=s.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]]","");
			s=s.toLowerCase();
			if(dizionario.contains(s)) {
				correzione.add(new RichWord(s,true));
			}
			if(!dizionario.contains(s)) {
				correzione.add(new RichWord(s,false));
			}
		}
		return correzione;
	}
	
	public List <String> divisione(String testo){
		List <String> stampa=new ArrayList <>();
		String scomposto[]=testo.split(" ");
		for(int i=0; i<scomposto.length;i++) {
			stampa.add(scomposto[i]);
		}
		return stampa;
	}

	public List<String> getDizionario() {
		return dizionario;
	}

	public void setDizionario(List<String> dizionario) {
		this.dizionario = dizionario;
	}
	
	public List <RichWord> spellCheckTextLinear(List <String> inputTextList){
		List <RichWord> correzione= new ArrayList<>();
		for(String s: inputTextList) {
			s=s.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]]","");
			s=s.toLowerCase();
		boolean trovato=false;
		for(String dizio:this.dizionario) {
			if(trovato==false) {
				if(s.equals(dizio)) {
					trovato=true;
				}
			}
			
		}
			if(trovato==true) {
				correzione.add(new RichWord(s,true));
			}
			if(trovato==false) {
				correzione.add(new RichWord(s,false));
			}
		
		}
		return correzione;
	}
	
	
	
	
	public List <RichWord> spellCheckTextDichotomic(List <String> inputTextList){
		List <RichWord> correzione= new ArrayList<>();
		for(String s: inputTextList) {
			s=s.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]]","");
			s=s.toLowerCase();
		boolean trovato=false;
		int minimo=0;
		int massimo=dizionario.size()-1;
		int indice=0;
		do {
		indice=(massimo+minimo)/2;
		if(s.compareTo(dizionario.get(indice))==0) {
			trovato=true;
		}
		if(s.compareTo(dizionario.get(indice))>0) {
			minimo=indice+1;
		}
		else if(s.compareTo(dizionario.get(indice))<0) {
			massimo=indice-1;
		}
		}while(trovato==false && minimo<=massimo);
			if(trovato==true) {
				correzione.add(new RichWord(s,true));
			}
			if(trovato==false) {
				correzione.add(new RichWord(s,false));
			}
		
		}
		return correzione;
	}


	
	
	


}
