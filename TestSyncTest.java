package HeadFirst;
class TestSync implements Runnable {
	private int balance;
	public void run() {
		for(int i = 0; i < 50; i++) { // each thread runs 50 times
			increment();
			System.out.println(" balance is " + balance);
		}
	}
	
	public void increment() {
		int i = balance;
		balance = i + 1;
	}
}

public class TestSyncTest  {
	public static void main(String[] args) {
		TestSync job = new TestSync();
		Thread a = new Thread(job);
		Thread b = new Thread(job);
		a.start();
		b.start();
	}
}