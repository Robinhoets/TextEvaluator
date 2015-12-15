public class SentenceLength {
	
	private List<String> paragraph;
	private double wordCount;
	private double periodCount;

	public SentenceLength(List<String> paragraph) {
		this.paragraph = paragraph;
	}

	private void breakUp(List<String> paragraph) {
	
		for(int i=0; i<paragraph.size(); i++) {

			// get next word in paragraph 	
			String word = paragraph.get(i);
			// split word into an array
			String[] wordArray = word.split("");

			for(int j=0; j<wordArray.length; j++) {

				if(wordArray[j].equals("."))
					periodCount++;
			}
			wordCount++;

		}		
	}


	public double rating() {

		breakUp(paragraph);
		return (wordCount/periodCount);
	}
	
}