import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class ReadWriteFile {

	public static void writeToFile(String filename, int[] size){
		PrintWriter writer = null;
		
		try {
			writer = new PrintWriter(filename, "UTF-8");
			for(int i:size){
				writer.write(String.valueOf(i) + ' ');
			}			
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			System.out.println("Error, unable to write to file");
		}
		finally {
			writer.close();
		}
		
	}
	
	public static int[] readFromFile(String filename){
		BufferedReader br = null;
		int[] numbers = null;
		try {
			br = new BufferedReader(new FileReader(filename));
			
			String[] values = br.readLine().split(" ");
			numbers = new int[values.length];
			for(int i = 0; i<values.length; i++){
				numbers[i] = Integer.parseInt(values[i]);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error, cannot read from file "+ filename);
		}
		finally{
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
			}
		}
		return numbers;
	}
}
