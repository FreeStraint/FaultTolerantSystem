import java.util.stream.IntStream;

public class SortCheck {

	public static boolean check(int[] unsort, int[] sorted){
		
		if(unsort.length != sorted.length){
			return false;
		}
		
		int oldS = IntStream.of(unsort).sum();
		int newS = IntStream.of(sorted).sum();
		if(oldS != newS){
			return false;
		}
		return true;
	}
}
