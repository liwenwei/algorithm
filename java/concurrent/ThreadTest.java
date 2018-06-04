
public class ThreadTest {

	private static int i = 10;
	private static Object object = new Object();

	public static void main(String[] args) {

		// Sleep
		Thread a = new Thread(new MySleepThread());
		Thread b = new Thread(new MySleepThread());
		a.start();
		b.start();

		// Join
		Thread c = new Thread(new MyJoinThread());
		c.start();
		try {
			System.out.println("线程" + Thread.currentThread().getName() + "等待");
			c.join();
			System.out.println("线程" + Thread.currentThread().getName() + "继续执行");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// interrupt
		Thread d = new Thread(new MyInterrupedThread());
		try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
             
        }
        d.interrupt();
	}

	/**
	 * Sleep相当于让线程睡眠， 交出CPU，让CPU去执行其他任务，但sleep不会释放锁
	 * 
	 * @author liwenwei
	 *
	 */
	public static class MySleepThread implements Runnable {

		@Override
		public void run() {
			synchronized (object) {
				i++;
				System.out.println("i:" + i);
				try {
					System.out.println("Thread " + Thread.currentThread().getName() + " is sleeping");
					Thread.sleep(10000);
				} catch (InterruptedException e) {

				}

				System.out.println("Thread " + Thread.currentThread().getName() + " wake up");
				i++;
				System.out.println("i:" + i);
			}
		}

	}

	public static class MyJoinThread implements Runnable {

		@Override
		public void run() {
			System.out.println("进入线程 " + Thread.currentThread().getName());
			try {
				Thread.currentThread().sleep(5000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			System.out.println("线程 " + Thread.currentThread().getName() + " 执行完毕");
		}

	}
	
	public static class MyInterrupedThread implements Runnable{
        @Override
        public void run() {
            try {
                System.out.println("进入睡眠状态");
                Thread.currentThread().sleep(10000);
                System.out.println("睡眠完毕");
            } catch (InterruptedException e) {
                System.out.println("得到中断异常");
            }
            System.out.println("run方法执行完毕");
        }
    }
}
