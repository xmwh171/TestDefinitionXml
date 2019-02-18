package multithread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description 基本类型原子类 AtomicInteger 类主要利用 CAS (compare and swap) + volatile 和 native 方法来保证原子操作，从而避免 synchronized 的高开销，执行效率大为提升。
 * @Author xiaohu
 * @Date 2019/2/18 11:26
 */
public class AtomicIntegerTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int temvalue = 0;
        AtomicInteger i = new AtomicInteger(0);
        temvalue = i.getAndSet(3);
        System.out.println("temvalue:" + temvalue + ";  i:" + i);//temvalue:0;  i:3
        temvalue = i.getAndIncrement();
        System.out.println("temvalue:" + temvalue + ";  i:" + i);//temvalue:3;  i:4
        temvalue = i.getAndAdd(5);
        System.out.println("temvalue:" + temvalue + ";  i:" + i);//temvalue:4;  i:9
    }
}
