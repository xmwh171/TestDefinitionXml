package multithread;

/**
 * @Description synchronized（object）代码块间使用
 *
 *  synchronized方法一样，synchronized(this)代码块也是锁定当前对象的,其他线程执行对象中synchronized同步方法和synchronized(this)代码块时呈现同步效果;
 *  如果两个线程使用了同一个“对象监视器”,运行结果同步，否则不同步.
 * @Author xiaohu
 * @Date 2019/2/13 16:45
 */
public class Service1 {

    public void testMethod1(MyObject object) {
        synchronized (object) {
            try {
                System.out.println("testMethod1 ____getLock time="
                        + System.currentTimeMillis() + " run ThreadName="
                        + Thread.currentThread().getName());
                Thread.sleep(2000);
                System.out.println("testMethod1 releaseLock time="
                        + System.currentTimeMillis() + " run ThreadName="
                        + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // 使用同一个“对象监视器”object
//        Service1 service = new Service1();
//        MyObject object = new MyObject();
//        ThreadA2 a = new ThreadA2(service, object);
//        a.setName("a");
//        a.start();
//        ThreadB2 b = new ThreadB2(service, object);
//        b.setName("b");
//        b.start();


        // 使用不同对象监视器
        Service1 service = new Service1();
        MyObject object1 = new MyObject();
        MyObject object2 = new MyObject();
        ThreadA2 a = new ThreadA2(service, object1);
        a.setName("a");
        a.start();
        ThreadB2 b = new ThreadB2(service, object2);
        b.setName("b");
        b.start();
    }
}
