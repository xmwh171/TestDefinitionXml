package multithread;

/**
 * @Description volatile修饰的成员变量在每次被线程访问时，都强迫从主存（共享内存）中重读该成员变量的值。
 * 而且，当成员变量发生变化时，强迫线程将变化值回写到主存（共享内存）。这样在任何时刻，两个不同的线程总是看到某个成员变量的同一个值，这样也就保证了同步数据的可见性。
 * @Author xiaohu
 * @Date 2019/2/13 18:30
 */
public class RunThread extends Thread{

    private boolean isRunning = true;
    volatile int m;
    public boolean isRunning() {
        return isRunning;
    }
    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    @Override
    public void run() {
        System.out.println("进入run了");
        while (isRunning == true) {
            int a=2;
            int b=3;
            int c=a+b;
            m=c;
          //  System.out.println("m="+m);
            // 加上这一行输出不会出现死循环，是因为JVM会尽力保证内存的可见性，即便这个变量没有加同步关键字。
            // 换句话说，只要CPU有时间，JVM会尽力去保证变量值的更新。这种与volatile关键字的不同在于，volatile关键字会强制的保证线程的可见性。
            // 而不加这个关键字，JVM也会尽力去保证可见性，但是如果CPU一直有其他的事情在处理，它也没办法。
            // 最开始的代码，一直处于死循环中，CPU处于一直占用的状态，这个时候CPU没有时间，JVM也不能强制要求CPU分点时间去取最新的变量值。
            // 而加了输出或者sleep语句之后，CPU就有可能有时间去保证内存的可见性，于是while循环可以被终止。
        }
        System.out.println(isRunning);
        System.out.println(m);
        System.out.println("线程被停止了！");
    }

    public static void main(String[] args) throws InterruptedException {
        RunThread thread = new RunThread();

        thread.start();
        Thread.sleep(1000);
        System.out.println("准备赋值");
        thread.setRunning(false);
        System.out.println("已经赋值为false");
    }
}

