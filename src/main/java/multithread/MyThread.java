package multithread;


/**
 *
 * @author SnailClimb
 * @date 2018年10月30日
 * @Description: 多个线程之间不共享变量线程安全的情况
 */
public class MyThread extends Thread {

    private int count = 5;

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 200; i++) {
            System.out.println("i=" + (i + 1));
        }
    }
    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(2);
            System.out.println("sleeped");
            thread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
    }
}
