package multithread;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/2/13 17:03
 */
public class ThreadA3 extends Thread {
    private Service2 service;
    public ThreadA3(Service2 service) {
        super();
        this.service = service;
    }
    @Override
    public void run() {
        service.printA();
    }
}
