import java.util.Random;

public class BackupSort extends Sorting{

	InsertionSort is;
	
	public BackupSort(String sort){
		super();
//		try {
//			bs = (Sorter)Class.forName(sort).getConstructor().newInstance();
//		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
//				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
//			
//		}
		is = new InsertionSort();
	}
	public void sort() {
		setComplete(false);
		is.sort();
		setComplete(true);
	}
	
	@Override
	public void setValues(int[] values) {
		is.setArgs(values);		
	}
	@Override
	public int[] getValues() {
		// TODO Auto-generated method stub
		return is.getArgs();
	}
	@Override
	public boolean isFailure(double prob) {
		
		int memAccess = is.getMemAccess();
		double hazard = memAccess * prob;
		double rand = new Random().nextDouble();
		
		//Within the range of [0.5, 0.5+hazard]
		if(rand >= 0.5 && rand <= hazard+0.5){
			return true;
		}
		return false;
	}

}
