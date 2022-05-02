package HeadFirst;
class BankAccount {
	private int balance = 100; //The account starts with a balance of $100
	public int getBalance() {
		return balance;
	}
	public void withdraw(int amount) {
		balance = balance - amount;
	}
}

/* There's only one instance of the RyanAndMonicaJob.
 * Both threads will access this account */

public class RyanAndMonicaJob implements Runnable { 
	private BankAccount account = new BankAccount();

	public static void main(String[] args) {
		RyanAndMonicaJob theJob = new RyanAndMonicaJob(); //instantiate the runnable (job)
		Thread one = new Thread(theJob);
		Thread two = new Thread(theJob); //Make two threads giving each thread the same runnable job
		one.setName("Ryan");
		two.setName("Monica");
		one.start();
		two.start();
	}
	
	/* In the run() method, a thread loops through and tries to make
	 * a withdrawal with each iteration. After the withdrawal, it checks 
	 * the balance once again to see if the account is overdrawn. */
	
	public void run() {
		for (int x = 0; x < 10; x++) {
			makeWithdrawal(10);
			if(account.getBalance() < 0) {
				System.out.println("Overdrawn");
			}
		}
	}

private synchronized void makeWithdrawal (int amount) {
	if(account.getBalance() >= amount) {
		System.out.println(Thread.currentThread().getName() + " is about to withdraw..");
		try {
			System.out.println(Thread.currentThread().getName() + " is going to sleep..zzz..");
			Thread.sleep(500);
		}catch(InterruptedException ex) {ex.printStackTrace();}
		System.out.println(Thread.currentThread().getName() + "woke up !!");
		account.withdraw(amount);
		System.out.println(Thread.currentThread().getName() + " completes the withdrawal");
	}
	else {
		System.out.println("Sorry... not enough for " + Thread.currentThread().getName());
	}
  }
}