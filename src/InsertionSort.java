import java.util.Arrays;

/**
 * This insertion sort will be written in c code
 * @author James
 *
 */
public class InsertionSort extends Sorter {
	private int size;
	private int[] args;
	private int memAccess;
	static{
		System.setProperty("java.library.path", ".");
		System.loadLibrary("insertionsort");
	}
	//Driver
	public void sort(){
		System.loadLibrary("insertionsort");
		int[] result = insertsort(args);
		
		memAccess = result[result.length];
		args = Arrays.copyOfRange(result, 0, result.length-1);
	}
	
	
	private native int[] insertsort(int[] values);
	
	public int[] getArgs(){
		return args;
	}
	
	public void setArgs(int[] a){
		args = a;
	}

	@Override
	public int getMemAccess() {
		// TODO Auto-generated method stub
		return memAccess;
	}


}
