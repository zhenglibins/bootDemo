
public class volatileTest {

	public static void main(String[] args) throws InterruptedException {
		Bank bank = new Bank();
		UserOper u1 = new UserOper(bank);
		UserOper u2 = new UserOper(bank);
		new Thread(u1).start();
		new Thread(u2).start();
		System.out.println(Thread.activeCount());
		Thread.sleep(1000);
		while(Thread.activeCount()==1) {
			System.out.println("最终数量="+bank.getMoney());
			break;
		}
	}

}
class Bank{
	private int money = 100;
	private String lock = "lock";
	public  void add() {
		synchronized(lock) {
			money ++;
		}

	}
	public void substract() {
		money --;
	}
	public int getMoney() {
		return money;
	}
}

class UserOper implements Runnable{
	private Bank bank;
	public UserOper(Bank bank ) {
		this.bank = bank;
	}
	public void run() {

		for(int i = 0 ; i <1000000;i++) {
			bank.add();
		}
		System.out.println(bank.getMoney());
	}

}