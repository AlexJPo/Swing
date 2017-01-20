package javaThread;

public class MyThread extends Thread {	
	private int delay;
	private String title;
	
	public MyThread(int delay, String title) {
		this.delay = delay;
		this.title = title;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(title + ": " + i);
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 
	}
}
