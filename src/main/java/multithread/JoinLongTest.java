package multithread;

/**
 * @Description
 * join(long millis)、join(long millis, int nanos)两个具有超时特性的方法。这两个超时方法表示，如果线程thread在指定的超时时间没有终止，那么将会从该超时方法中返回。
 * Thread.sleep(long millis)不会释放锁，threadTest.join(long millis)会释放锁
 * @Author xiaohu
 * @Date 2019/2/14 18:42
 */
public class JoinLongTest {

    public static void main(String[] args) {
        try {
            MyThread threadTest = new MyThread();
            threadTest.start();

            threadTest.join(2000);// 只等2秒
            //Thread.sleep(2000);

            System.out.println("  end timer=" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static public class MyThread extends Thread {

        @Override
        public void run() {
            try {
                System.out.println("begin Timer=" + System.currentTimeMillis());
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
