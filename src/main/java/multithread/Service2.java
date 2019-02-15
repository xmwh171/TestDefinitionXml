package multithread;

/**
 * @Description  静态同步synchronized方法与synchronized(class)代码块
 * @Author xiaohu
 * @Date 2019/2/13 17:01
 */
public class Service2 {

    public static void printA() {
        synchronized (Service2.class) {
            try {
                System.out.println(
                        "线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "进入printA");
                Thread.sleep(3000);
                System.out.println(
                        "线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "离开printA");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    synchronized public static void printB() {
        System.out.println("线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "进入printB");
        System.out.println("线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "离开printB");
    }

    synchronized public void printC() {
        System.out.println("线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "进入printC");
        System.out.println("线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "离开printC");
    }

    /**
     * 静态同步synchronized方法与synchronized(class)代码块持有的锁一样，都是Class锁，Class锁对对象的所有实例起作用。synchronized关键字加到非static静态方法上持有的是对象锁。
     * 类锁和对象锁是两个不一样的锁，控制着不同的区域，它们是互不干扰的。同样，线程获得对象锁的同时，也可以获得该类锁，即同时获得两个锁，这是允许的。
     * Question：
     * @param args
     */
    public static void main(String[] args) {
        Service2 service = new Service2();
        ThreadA3 a = new ThreadA3(service);
        a.setName("A");
        a.start();

        ThreadB3 b = new ThreadB3(service);
        b.setName("B");
        b.start();

        ThreadC c = new ThreadC(service);
        c.setName("C");
        c.start();

    }
}
