import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextDriver {



	public static void main(String[] args) {

		if(args.length < 1) {
			System.out.println("Usage: java TextDriver <inputfile>");
			System.exit(0);
		}

		File input = new File(args[0]);
		Scanner reader = null;
		try {
			reader = new Scanner(input);
		}
		catch(FileNotFoundException e) {
			System.out.println("Input File " + args[0] + " does not exist");
			System.exit(0);
		}


		List<String> paragraph = new ArrayList<String>();
		while(reader.hasNext()) {
			paragraph.add(reader.next());
		}
		reader.close();


		// analyze smogRating
		SmogRating p1SMOG = new SmogRating(paragraph);
		double p1smogRating = p1SMOG.rating();

		System.out.println("SMOG: " + p1smogRating);

		for(int i=0; i<paragraph.size(); i++) {
			System.out.println(paragraph.get(i));
		}
	}
}