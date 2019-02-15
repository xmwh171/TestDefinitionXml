package multithread;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/2/13 17:04
 */
public class ThreadC extends Thread {
    private Service2 service;
    public ThreadC(Service2 service) {
        super();
        this.service = service;
    }
    @Override
    public void run() {
        service.printC();
    }
}
