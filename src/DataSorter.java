
public class DataSorter {

	public static void main(String[] args) {
		
		int[] original;
		
		if(args.length == 5){
			//Main code
			String inputFileName = args[0];
			String outputFileName = args[1];
			Double primaryProb = Double.parseDouble(args[2]);
			Double secondaryProb = Double.parseDouble(args[3]);
			int timtout = Integer.parseInt(args[4]);
			
			//Run Primary variant
			original = ReadWriteFile.readFromFile(inputFileName);
			Heapsort h = new Heapsort();
			h.sort(original);
			
			int[] result = h.getValues();
			ReadWriteFile.writeToFile(outputFileName, result);
			
		}
		else{
			System.out.println("Invalid syntax");
			System.out.println("Input argument should be: input filename "
					+ "output filename "
					+ "failure probabilies for primary invariants "
					+ "failure probabilies for secondary invariants "
					+ "time limit");
		}
		
	}
}
