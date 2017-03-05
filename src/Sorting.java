
public abstract class Sorting extends Thread {
	
	private boolean complete;
	
	public void run(){
		this.sort();
	}
	
	public abstract void sort();
	public boolean isComplete(){
		return complete;
	}
	
	public abstract void setValues(int[] values);
	public abstract int[] getValues();
	
	public void setComplete(boolean b){
		complete = b;
	}
	public abstract boolean isFailure(double prob);

}
