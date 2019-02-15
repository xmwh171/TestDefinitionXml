package multithread;

/**
 * @Description 可重入锁
 * @Author xiaohu
 * @Date 2019/2/13 16:00
 */
public class Service extends Thread{

    /**
     * 比如一个线程获得了某个对象的锁，此时这个对象锁还没有释放，当其再次想要获取这个对象的锁的时候还是可以获取的
     * 当存在父子类继承关系时，子类是完全可以通过“可重入锁”调用父类的同步方法
     * 注：如果父类有一个带synchronized关键字的方法，子类继承并重写了这个方法，但是同步不能继承，所以还是需要在子类方法中添加synchronized关键字。
     */

    synchronized public void service1() {
        System.out.println("service1");
        service2();
    }

    synchronized public void service2() {
        System.out.println("service2");
        service3();
    }

    synchronized public void service3() {
        System.out.println("service3");
        service4();
    }

    synchronized public void service4() {
        HasSelfPrivateNum h = new HasSelfPrivateNum();
        h.addI("a");
        System.out.println("service4");
    }

    @Override
    public void run() {
        Service service = new Service();
        service.service1();
    }

    public static void main(String[] args) {
        Service t = new Service();
        t.start();
    }
}
