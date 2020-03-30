package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {

	private List<WordEnhanced> dizionario;
	
	public AlienDictionary() {
		dizionario = new ArrayList<>();
	}
	
	public void addWord(String alienWord, String translation) {
		WordEnhanced a = cercaWord(alienWord);
		if(a!=null) {
			if(!a.getTranslation().contains(translation))
				a.getTranslation().add(translation);
		}
		a = new WordEnhanced(alienWord, translation);
		dizionario.add(a);
	}
	
	public WordEnhanced cercaWord(String alienWord) {
		for(WordEnhanced a : dizionario) {
			if(a.getAlienWord().compareTo(alienWord)==0) {
				return a;
			}
		}
		return null;
	}
	
	public String translateWord (String alienWord) {
		if(alienWord.contains("?")) {
			String temp1 = alienWord.substring(0, alienWord.indexOf("?"));
			String temp2 = alienWord.substring(alienWord.indexOf("?")+1);
			ArrayList<String> temp = new ArrayList<>();
			for(WordEnhanced b : dizionario) {
				if(b.getAlienWord().contains(temp1) && b.getAlienWord().contains(temp2)) {
					temp.addAll(b.getTranslation());
				}
			}
			String s = "";
			for(String b : temp) {
				s += b+"\n";
			}
			return s;
		}
		
		
		WordEnhanced a = cercaWord(alienWord);
		if(a==null) {
			return null;
		}
		String s = "";
		for(String b : a.getTranslation()) {
			s += b+"\n";
		}
		return s;
	}

	public List<WordEnhanced> getDizionario() {
		return dizionario;
	}

	
	
}
