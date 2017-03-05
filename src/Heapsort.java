
/**
 * 
 * Heapsort reference from http://www.sanfoundry.com/java-program-implement-heap-sort/
 * Heapsort class just do the sorting, and nothing else
 *
 */
public class Heapsort extends Sorter {
	private int size;
	private int[] args;
	int memAccess;
	
	public Heapsort(){
		super();
		memAccess = 0;
	}
	public void sort(){
		//args = values;
		heapify();
		for(int i = size; i>0; i--){
			//variable i access twice, assignment and decrement
			memAccess +=2;
			swap(0, i);
			size =size - 1;
			//size decrement
			memAccess += 1;
			MaxHeap(0);
		}
	}
	
	//Function to build a heap
	public void heapify(){
		size = args.length - 1;
		memAccess += 2;
		
		for(int i = size/2; i >= 0; i--){
			//Variable i access once, assignment and decrement
			memAccess +=2;
			MaxHeap(i);
		}
	}
	//Function to swap the largest element of the leap to the end
	public void MaxHeap (int i){
		int left = 2*i;
		memAccess += 2;
		int right = 2*i + 1;
		memAccess += 2;
		int max;
		
		if(left <= size && args[left] > args[i]){
			memAccess += 4;
			max = left;
			memAccess += 2;
		}else{
			memAccess += 2;
			max = i;
		}
		if(right <= size && args[right] > args[max]){
			max = right;
			memAccess += 2;
		}
		
		if(max != i){
			swap(i, max);
			MaxHeap(max);
		}
	}
	
	public void swap(int a1, int a2){
		int temp = args[a1];
		memAccess += 2;
		args[a1] = args[a2];
		memAccess += 2;
		args[a2] = temp;
		memAccess += 2;
	}
	@Override
	public void setArgs(int[] a) {
		// TODO Auto-generated method stub
		args = a;
	}
	@Override
	public int[] getArgs() {
		// TODO Auto-generated method stub
		return args;
	}
	
	public int getMemAccess(){
		return memAccess;
	}

}
