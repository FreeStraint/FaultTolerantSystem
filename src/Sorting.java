import java.util.Random;
import java.util.stream.IntStream;

public class Sorting extends Thread {
	
	private boolean complete;
	private Sorter sorter = null;
	private int oldL;
	private int oldS;
	
	public Sorting(String sortType){
		if(sortType.equals("Heapsort")){
			sorter = new Heapsort();
		}
		if(sortType.equals("InsertionSort")){
			sorter = new InsertionSort();
		}
	}
	public void run(){
		this.sort();
	}
	
	public void sort(){
		setComplete(false);
		sorter.sort();
		setComplete(true);
	};
	public boolean isComplete(){
		return complete;
	}
	
	public void setValues(int[] values){
		sorter.setArgs(values);
		this.oldL = values.length;
		this.oldS = IntStream.of(values).sum();
	};
	public int[] getValues(){
		return sorter.getArgs();
	};
	
	public void setComplete(boolean b){
		complete = b;
	}
	public boolean isFailure(double prob){
		
		int memAccess = sorter.getMemAccess();
		double hazard = memAccess * prob;
		double rand = new Random().nextDouble();
		
		//Within the range of [0.5, 0.5+hazard]
		if(rand >= 0.5 && rand <= hazard+0.5){
			return true;
		}
		return false;
	};
	
	//Checksum and check length
	public boolean check(){
		int[] sorted = getValues();
		if(this.oldL != sorted.length){
			return false;
		}

		int newS = IntStream.of(sorted).sum();
		if(oldS != newS){
			return false;
		}
		return true;
	}

}
