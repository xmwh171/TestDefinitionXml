package multithread;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/2/13 16:27
 */
public class MyThread3 extends Thread {
    private Task task;
    public MyThread3(Task task) {
        super();
        this.task = task;
    }
    @Override
    public void run() {
        super.run();
        CommonUtils.beginTime1 = System.currentTimeMillis();
        task.doLongTimeTask();
        CommonUtils.endTime1 = System.currentTimeMillis();
    }
}
