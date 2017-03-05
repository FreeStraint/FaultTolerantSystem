import java.util.Arrays;

/**
 * This insertion sort will be written in c code
 * @author James
 *
 */
public class InsertionSort extends Sorter {
	private int size;
	private int[] args;
	
	static{
		System.setProperty("java.library.path", ".");
		System.loadLibrary("insertionsort");
	}
	//Driver
	public void sort(){
		System.loadLibrary("insertionsort");
		int[] result = insertsort(args);
		
		System.out.println(Arrays.toString(result));
		//String s = insertsort();
		//System.out.println("s: "+s);
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
		return 0;
	}


}
