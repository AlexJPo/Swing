package javaThread;

public class JavaThread {

	public static void main(String[] args) {
		/*Thread t1 = new MyThread(700, "t1");
		Thread t2 = new MyThread(950, "t2");
		
		t1.start();
		t2.start();*/
		
		new MyRunnable(700, "First");
		new MyRunnable(900, "Second");
	}
}
