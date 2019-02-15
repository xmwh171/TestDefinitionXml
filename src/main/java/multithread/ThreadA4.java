package multithread;

/**
 * @Description
 * 当方法wait()被执行后，锁自动被释放，但执行完notify()方法后，锁不会自动释放。必须执行完notify()方法所在的synchronized代码块后才释放。
 *
 * synchronized关键字可以将任何一个Object对象作为同步对象来看待，而Java为每个Object都实现了等待/通知（wait/notify）机制的相关方法，它们必须用在synchronized关键字同步的Object的临界区内。
 * 通过调用wait()方法可以使处于临界区内的线程进入等待状态，同时释放被同步对象的锁。
 * 而notify()方法可以唤醒一个因调用wait操作而处于阻塞状态中的线程，使其进入就绪状态。被重新唤醒的线程会视图重新获得临界区的控制权也就是锁，并继续执行wait方法之后的代码。
 * 如果发出notify操作时没有处于阻塞状态中的线程，那么该命令会被忽略。
 * 附：当线程呈wait状态时，对线程对象调用interrupt方法会出现InterrupedException异常。
 * @Author xiaohu
 * @Date 2019/2/14 16:37
 */
public class ThreadA4 extends Thread {

    private Object lock;

    public ThreadA4(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                if (MyList.size() != 5) {
                    System.out.println("wait begin "
                            + System.currentTimeMillis());
                    lock.wait();
                    System.out.println("wait end  "
                            + System.currentTimeMillis());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        try {
            Object lock = new Object();
            ThreadA4 a = new ThreadA4(lock);
            a.start();
            Thread.sleep(50);
            ThreadB4 b = new ThreadB4(lock);
            b.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
