import java.util.ArrayList;
import java.util.List;

/**
 * 生产者/消费者模式是一种很经典的线程同步模型，很多时候，并不是光保证某个共享资源互斥就够的，
 * 多线程之间都是有协作的
 * @author liwenwei
 *
 */
public class Plate {
	private List<Object> eggs = new ArrayList<Object>();

	public synchronized Object getEgg() {
		while (eggs.size() == 0) {
			try {
				/*
				 * 如果一个线程获得了锁lock，进入的同步快，执行lock.wait()，那么这个
				 * 线程就会进入到这个lock的阻塞队列中
				 */
				wait();
			} catch (InterruptedException e) {
			}
		}
		Object egg = eggs.get(0);
		eggs.clear();// 清空盘子
		/*
		 * 如果调用lock.notify()则会通知阻塞队列的某个线程进入就绪队列
		 */
		notify();// 唤醒阻塞队列的某线程到就绪队列
		System.out.println("拿到鸡蛋");
		return egg;
	}

	public synchronized void putEgg(Object egg) {
		while (eggs.size() > 0) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		eggs.add(egg);
		notify();
		System.out.println("放鸡蛋");
	}

	static class AddThread extends Thread {
		private Plate plate;
		private Object egg = new Object();

		public AddThread(Plate plate) {
			this.plate = plate;
		}

		public void run() {
			for (int i = 0; i < 5; i++) {
				plate.putEgg(egg);
			}
		}
	}

	static class GetThread extends Thread {
		private Plate plate;

		public GetThread(Plate plate) {
			this.plate = plate;
		}

		public void run() {
			for (int i = 0; i < 5; i++) {
				plate.getEgg();
			}
		}
	}
	
	public static void main(String[] args) {
		try {  
            Plate plate=new Plate();  
            Thread add=new Thread(new AddThread(plate));  
            Thread get=new Thread(new GetThread(plate));  
            add.start();  
            get.start();  
            add.join();  
            get.join();  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
        System.out.println("测试结束");  
	}
}
