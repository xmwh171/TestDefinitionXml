package multithread;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @Description  对象的属性修改类型原子类
 * @Author xiaohu
 * @Date 2019/2/18 12:49
 */
public class AtomicIntegerFieldUpdaterTest {

    /**
     * 要想原子地更新对象的属性需要两步。第一步，因为对象的属性修改类型原子类都是抽象类，所以每次使用都必须使用静态方法 newUpdater()创建一个更新器，并且需要设置想要更新的类和属性。
     * 第二步，更新的对象属性必须使用 public volatile 修饰符。
     * @param args
     */
    public static void main(String[] args) {
        AtomicIntegerFieldUpdater<User> a = AtomicIntegerFieldUpdater.newUpdater(User.class, "age");

        User user = new User("Java", 22);
        System.out.println(a.getAndIncrement(user));// 22
        System.out.println(a.get(user));// 23
    }
}
