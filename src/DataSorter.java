import java.util.Timer;

public class DataSorter {
	
	static String primarySort = "Heapsort";
	static String[] backupSort = {"InsertionSort"};
	
	public static void main(String[] args) throws Exception  {
		
		if(args.length != 5){
			String error = "Invalid syntax "
					+ "Input argument should be: input filename "
					+ "output filename "
					+ "failure probabilies for primary invariants "
					+ "failure probabilies for secondary invariants "
					+ "time limit";
			throw new Exception(error);

		}
		
		//Main code
		int[] original;
		Sorting sort = null;

		String inputFileName = args[0];
		String outputFileName = args[1];
		Double primaryProb = Double.parseDouble(args[2]);
		Double secondaryProb = Double.parseDouble(args[3]);
		int timeout = Integer.parseInt(args[4]);
		
		//Read the values generated by DataGenerator.
		original = ReadWriteFile.readFromFile(inputFileName);

		//Run on primary invariant	
		sort = new Sorting(primarySort);
		sort(sort, original, timeout);
		
		//If acceptance test passed
		if(sort.isComplete() && !sort.isFailure(primaryProb) && sort.check()){
			ReadWriteFile.writeToFile(outputFileName, sort.getValues());
			System.out.println("Primary sort success:Return result");
			System.exit(0);
		}
	
		System.out.println("Primary sort failed, running backup sort now");
		
		//Primary sorting failed, run backup test now
		for(String s:backupSort){
			//Checkpoint, restore the original list
			original = ReadWriteFile.readFromFile(inputFileName);

			System.out.println("Running backup sort: "+ s);
			sort = new Sorting(s);
		
			sort(sort, original, timeout);
			if(sort.isComplete() && !sort.isFailure(secondaryProb) && sort.check()){
				ReadWriteFile.writeToFile(outputFileName, sort.getValues());
				System.out.println("backup sort: "+ s +", Return result");
				System.exit(0);
			}
			
		}
		
		System.out.println("No more back up soring, No files will be created.");
		throw new Exception("Failure Exception, no sorting had been done");
		
	}
	
	public static void sort(Sorting s, int[] original, int timeout){
		//Reference from watchdog driver method from eclass

		s.setValues(original);

		Timer t = new Timer();
		Watchdog w = new Watchdog(s);

		t.schedule(w, timeout);
		s.start();
		try{
			s.join();
			t.cancel();
		} catch(InterruptedException e){
			System.out.println("You are dead");
		}
	}
	
	public int checkSum(int[] args){
		int sum = 0;
		for(int i:args){
			sum += i;
		}
		return sum;
	}
}
