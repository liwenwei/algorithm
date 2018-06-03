
public class Account {
	private int balance;

	public Account(int balance) {
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}

	public synchronized void add(int num) {
		balance += num;
	}

	public synchronized void withDraw(int num) {
		balance -= num;
	}

	public static void main(String[] args) throws InterruptedException {
		Account account = new Account(2000);
		
		Thread a = new Thread(new AddThread(account, 20), "addThread");
		Thread b = new Thread(new WithDrawThread(account, 20), "withDrawThread");
		a.start();
		b.start();
		a.join();
		b.join();
		
		System.out.println(account.getBalance());
	}
	
	static class AddThread implements Runnable {
		Account account;
		int amount;

		public AddThread(Account account, int amount) {
			this.account = account;
			this.amount = amount;
		}

		@Override
		public void run() {
			for (int i = 0; i < 200000; i++) {
				account.add(amount);
			}
		}
	}
	
	static class WithDrawThread implements Runnable {
		Account account;
		int amount;

		public WithDrawThread(Account account, int amount) {
			this.account = account;
			this.amount = amount;
		}
		
		@Override
		public void run() {
			for (int i = 0; i < 100000; i++) {
				account.withDraw(amount);
			}
		}
		
	}
}
