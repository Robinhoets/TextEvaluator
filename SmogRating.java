import java.lang.*;

public class SmogRating {
	
	private List<String> paragraph;
	public int numOfSentences = 0;

	public SmogRating(List<String> paragraph) {
		this.paragraph = paragraph;
	}

	private int polysyllables(List<String> paragraph) {
		int numOfPolysyllables = 0;

		for(int j = 0; j < paragraph.size(); j++) {

			int vowels = 0;
			// get next word in paragraph 	
			String word = paragraph.get(j);
			// split word into an array
			String[] wordArray = word.split("");




			/*--------------------- need to account for 'y' with no vowels next to it -----------*/


			for(int i = 0; i < wordArray.length; i++) {

				// check to see how many vowels are in the word
				// account for diphthongs(two vowels in a row) -> only add 1 for diphthongs
				// if word ends in e, do not increase vowels
				if(wordArray[i].equals("a") || wordArray[i].equals("e") || 
				   wordArray[i].equals("i") || wordArray[i].equals("o") || 
				   wordArray[i].equals("u")) 
				{

					if(
					   wordArray[i].equals(wordArray[i-1])
					  ) 
					{
						vowels = vowels;
					}
					else if(wordArray[wordArray.length-1].equals("e")) {
						vowels = vowels;
					}
					else{
						vowels++;
					}
				}

				if(wordArray[i].equals("."))	{
					numOfSentences++;
				}				
			}

			// increase count of words with polysyllables
			if(vowels >= 3) {
				numOfPolysyllables++;
			}			
		}	
		return numOfPolysyllables;	
	}


	public double rating() {

		int polysylInParagraph = polysyllables(paragraph);
		double grade = (1.0430 * Math.sqrt(polysylInParagraph * (30/numOfSentences) ) )    +   3.1291;
		return grade;

	}

}