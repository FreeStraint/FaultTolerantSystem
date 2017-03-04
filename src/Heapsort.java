
public class Heapsort {
	//Get heapsort algorithm from http://www.sanfoundry.com/java-program-implement-heap-sort/
	private int size;
	private int[] args;

	public void sort(int[] values){
		args = values;
		heapify();
		for(int i = size; i>0; i--){
			swap(0, i);
			size =size - 1;
			MaxHeap(0);
		}
	}
	
	//Function to build a heap
	public void heapify(){
		size = args.length - 1;
		for(int i = size/2; i >= 0; i--){
			MaxHeap(i);
		}
	}
	//Function to swap the largest element of the leap to the end
	public void MaxHeap (int i){
		int left = 2*i;
		int right = 2*i + 1;
		int max;
		
		if(left <= size && args[left] > args[i]){
			max = left;
		}else{
			max = i;
		}
		if(right <= size && args[right] > args[max]){
			max = right;
		}
		
		if(max != i){
			swap(i, max);
			MaxHeap(max);
		}
	}

	
	public void swap(int a1, int a2){
		int temp = args[a1];
		args[a1] = args[a2];
		args[a2] = temp;
	}
	
	public int[] getValues(){
		return args;
	}
}
