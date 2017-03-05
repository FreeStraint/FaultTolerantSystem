import java.util.Random;

public class PrimarySort extends Sorting {

	Heapsort h;
	
	
	public PrimarySort(){
		super();
		h = new Heapsort();
	}
	
	public void sort(){
		setComplete(false);
		h.sort();
		setComplete(true);
	}

	public void setValues(int[] args){
		h.setArgs(args);
	}
	
	public int[] getValues(){
		return h.getArgs();
	}
	
	public boolean isFailure(double prob){
		
		int memAccess = h.getMemAccess();
		System.out.println(memAccess);
		double hazard = memAccess * prob;
		double rand = new Random().nextDouble();
		
		//Within the range of [0.5, 0.5+hazard]
		if(rand >= 0.5 && rand <= hazard+0.5){
			return true;
		}
		return false;
	}
}
