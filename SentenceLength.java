public class SentenceLength {
	
	private List<String> paragraph;
	private int wordCount;
	private int periodCount;

	public SentenceLength(List<String> paragraph) {
		this.paragraph = paragraph;
	}

	private void breakUp(List<String> paragraph) {
	
		for(int i=0; i<paragraph.size(); i++) {

			if(paragraph.get(i) != ".")
				wordCount++;
			if(paragraph.get(i) == ".")
				periodCount++;
		}		
	}


	public double rating() {

		breakUp(paragraph);
		return wordCount/periodCount;
	}
	
}