package multithread;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/2/13 16:47
 */
public class ThreadB2 extends Thread {
    private Service1 service;
    private MyObject object;

    public ThreadB2(Service1 service, MyObject object) {
        super();
        this.service = service;
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        service.testMethod1(object);
    }

}
