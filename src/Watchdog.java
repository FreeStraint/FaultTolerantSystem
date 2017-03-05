import java.util.TimerTask;

/**
 * Watchdog reference from sample codes from eclass
 *
 */
public class Watchdog extends TimerTask  {

	Thread watched;
	
	public Watchdog(Thread target){

		watched = target;
	}
	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		// TODO Auto-generated method stub
		watched.stop();
	}

}
