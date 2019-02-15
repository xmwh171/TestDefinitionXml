package multithread;

/**
 * @Description  用runnable创建线程
 * @Author xiaohu
 * @Date 2019/2/13 10:45
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("MyRunnable");
    }

    public static void main(String[] args) {
        MyRunnable m = new MyRunnable();
        Thread t = new Thread(m);
        t.start();
        System.out.println("over");
    }
}
