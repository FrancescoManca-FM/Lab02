package it.polito.tdp.alien;

import java.util.*;

public class WordEnhanced {
		private String alienWord;
		private List<String> translation;
		
		public WordEnhanced(String alienWord, String translation) {
			this.alienWord = alienWord;
			this.translation = new ArrayList<>();
			this.translation.add(translation);
		}
		
		
		@Override
		public boolean equals(Object obj) {
			String s = ((String)obj).toLowerCase();
			return super.equals(s);
		}


		public String getAlienWord() {
			return alienWord;
		}


		public void setAlienWord(String alienWord) {
			this.alienWord = alienWord;
		}


		public List<String> getTranslation() {
			return translation;
		}

		
		
	
}
