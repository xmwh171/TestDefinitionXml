package multithread;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/2/13 16:27
 */
public class MyThread4 extends Thread {
    private Task task;
    public MyThread4(Task task) {
        super();
        this.task = task;
    }
    @Override
    public void run() {
        super.run();
        CommonUtils.beginTime2 = System.currentTimeMillis();
        task.doLongTimeTask();
        CommonUtils.endTime2 = System.currentTimeMillis();
    }
}
