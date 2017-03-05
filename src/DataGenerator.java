import java.util.Random;

public class DataGenerator {

	public static void main(String[] args) throws Exception {
		if(args.length == 2){
			String filename = args[0];
			int size = Integer.parseInt(args[1]);
			
			int[] numbers = generateRandomIntegers(size);
			
			ReadWriteFile.writeToFile(filename, numbers);
			
		}
		if(args.length != 2){
			String errorMsg = "Invalid syntax, please enter a filename and then a integer";
			throw new Exception(errorMsg);
		}
	}
	
	public static int[] generateRandomIntegers(int size){
		int [] numbers = new int[size];
		Random r = new Random();
		for(int i = 0; i<size; i++){
			numbers[i] = r.nextInt();
		}
		
		return numbers;
	}
}
