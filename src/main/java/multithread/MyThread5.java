package multithread;

/**
 * @Description   volatile无法保证对变量原子性的，要保证数据的原子性还是要使用synchronized关键字
 * @Author xiaohu
 * @Date 2019/2/14 9:30
 */
public class MyThread5  extends Thread {

    volatile public static int count;

    private static void addCount() {
        for (int i = 0; i < 100; i++) {
            count=i;
        }
        System.out.println("count=" + count);

    }
    @Override
    public void run() {
        addCount();
    }

    public static void main(String[] args) {
        MyThread5[] mythreadArray = new MyThread5[100];
        for (int i = 0; i < 100; i++) {
            mythreadArray[i] = new MyThread5();
        }

        for (int i = 0; i < 100; i++) {
            mythreadArray[i].start();
        }

    }

//    volatile关键字是线程同步的轻量级实现，所以volatile性能肯定比synchronized关键字要好。
//    但是volatile关键字只能用于变量而synchronized关键字可以修饰方法以及代码块。
//    synchronized关键字在JavaSE1.6之后进行了主要包括为了减少获得锁和释放锁带来的性能消耗而引入的偏向锁和轻量级锁以及其它各种优化之后执行效率有了显著提升，实际开发中使用synchronized关键字还是更多一些。
//    多线程访问volatile关键字不会发生阻塞，而synchronized关键字可能会发生阻塞
//    volatile关键字能保证数据的可见性，但不能保证数据的原子性。synchronized关键字两者都能保证。
//    volatile关键字用于解决变量在多个线程之间的可见性，而ynchronized关键字解决的是多个线程之间访问资源的同步性。
    //  volatile和synchronized的作用和区别是什么 : https://blog.csdn.net/huideveloper/article/details/80632111

    // Question：为什么count会产生结果不等于99的数？是因为Cpu切换导致单个线程中操作未执行完就被打断?
}
