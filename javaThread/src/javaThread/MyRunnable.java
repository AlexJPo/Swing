package javaThread;

public class MyRunnable implements Runnable {
	private int delay;
	private String title;
	private Thread thread;
	
	public MyRunnable(int delay, String title) {
		this.delay = delay;
		this.title = title;
		
		thread = new Thread(this);		
		thread.start();
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
