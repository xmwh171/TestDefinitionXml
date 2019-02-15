package multithread;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/2/13 15:09
 */
public class ThreadA1 extends Thread {

    private PublicVar publicVar;

    public ThreadA1(PublicVar publicVar) {
        super();
        this.publicVar = publicVar;
    }

    @Override
    public void run() {
        super.run();
        publicVar.setValue("B", "BB");
    }
}
