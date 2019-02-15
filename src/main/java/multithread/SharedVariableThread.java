package multithread;

/**
 *
 * @author SnailClimb
 * @date 2018年10月30日
 * @Description: 多个线程之间共享变量线程不安全的情况
 */
public class SharedVariableThread extends Thread {
    private int count = 5;

    @Override
    public void run() {    //  加synchronized可解决实例变量共享问题
        super.run();
        System.out.println("当前线程"+SharedVariableThread.currentThread().getName() + "，count=" + count);
        count--;
        System.out.println("由 " + SharedVariableThread.currentThread().getName() + " 计算，count=" + count);
    }

    public static void main(String[] args) {

        SharedVariableThread mythread = new SharedVariableThread();
        // 下列线程都是通过mythread对象创建的
        Thread a = new Thread(mythread, "A");
        Thread b = new Thread(mythread, "B");
        Thread c = new Thread(mythread, "C");
        Thread d = new Thread(mythread, "D");
        Thread e = new Thread(mythread, "E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }

    // Question:为什么会产生这种输出结果？

    /*
        其中一种运算结果：
        当前线程A，count=5
        由 A 计算，count=4
        当前线程D，count=5
        当前线程C，count=4
        由 C 计算，count=2
        当前线程E，count=2
        由 E 计算，count=1
        当前线程B，count=4
        由 B 计算，count=0
        由 D 计算，count=3

        分析：
        count   thread   subCount
        5       A、D     4、3
        4       C、B     2、0
        3
        2       E        1
        1
        A start  D start  A-   c=4   A print
        C start  B start  D-   c=3   D print(D线程此时输出，但是在控制台被乱序了?java中的编译器和处理器可以对指令进行重新排序?)  C-  c=2  C print
        E start  E-  c=1  E print
        B-  c=0  B print
     */


    /**
     * 我们以decl（递减指令）为例，这是一个典型的"读－改－写"过程，涉及两次内存访问。设想在不同CPU运行的两个进程都在递减某个计数值，可能发生的情况是：
     ⒈ CPU A(CPU A上所运行的进程，以下同）从内存单元把当前计数值⑵装载进它的寄存器中；
     ⒉ CPU B从内存单元把当前计数值⑵装载进它的寄存器中。
     ⒊ CPU A在它的寄存器中将计数值递减为1；
     ⒋ CPU B在它的寄存器中将计数值递减为1；
     ⒌ CPU A把修改后的计数值⑴写回内存单元。
     ⒍ CPU B把修改后的计数值⑴写回内存单元。
     我们看到，内存里的计数值应该是0，然而它却是1。如果该计数值是一个共享资源的引用计数，每个进程都在递减后把该值与0进行比较，从而确定是否需要释放该共享资源。
     这时，两个进程都去掉了对该共享资源的引用，但没有一个进程能够释放它--两个进程都推断出：计数值是1，共享资源仍然在被使用。
     */
}