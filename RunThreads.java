package HeadFirst;
public class RunThreads implements Runnable {
	public static void main(String[] args) {
		RunThreads runner = new RunThreads(); //Make a runnable instance
		Thread alpha = new Thread(runner);
		Thread beta = new Thread(runner); //Make two threads with the same Runnable
		alpha.setName("Alpha Thread");
		beta.setName("Beta Thread"); //Name the threads
		alpha.start();
		beta.start(); //start the threads
	}
	
	/* Each thread will run through this loop
	 * printing its name each time	 */
	
	public void run() {
		for(int i = 0; i < 25; i++) {
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + " is Running...");
		}
	}
}