<<<<<<< HEAD
=======
import java.util.Arrays;
>>>>>>> 3d2859d46741c399224a24346c17ff8771bbdc2b

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
		

		//Last element is memAccess
		memAccess = result[result.length-1];
		//convert int[] result to int[] args
		for(int i = 0; i<size; i++){
			args[i] = result[i];
			memAccess += 2;
		}

	}
	
	
	private native int[] insertsort(int[] values);
	
	public int[] getArgs(){
		return args;
	}
	
	public void setArgs(int[] a){
		args = a;
		size = args.length;

	}

	@Override
	public int getMemAccess() {
<<<<<<< HEAD
=======
		// TODO Auto-generated method stub
>>>>>>> 3d2859d46741c399224a24346c17ff8771bbdc2b
		return memAccess;
	}


}
