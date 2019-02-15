package multithread;

/**
 * @Description  同步代码块
 * @Author xiaohu
 * @Date 2019/2/13 16:26
 */
public class Task {

    private String getData1;
    private String getData2;

    /**
     * 不在synchronized代码块中就异步执行，在synchronized代码块中就是同步执行
     */
    public void doLongTimeTask() {
        try {
            System.out.println("begin task");
            Thread.sleep(3000);
//            getData1 = "长时间处理任务后从远程返回的值1 threadName="
//                    + Thread.currentThread().getName();
//            getData2 = "长时间处理任务后从远程返回的值2 threadName="
//                    + Thread.currentThread().getName();
            String privateGetData1 = "长时间处理任务后从远程返回的值1 threadName="
                    + Thread.currentThread().getName();
            String privateGetData2 = "长时间处理任务后从远程返回的值2 threadName="
                    + Thread.currentThread().getName();
            synchronized (this) {
                getData1 = privateGetData1;
                getData2 = privateGetData2;
            }

            System.out.println(getData1);
            System.out.println(getData2);
            System.out.println("end task");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Task task = new Task();

        MyThread3 thread3 = new MyThread3(task);
        thread3.start();

        MyThread4 thread4 = new MyThread4(task);
        thread4.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long beginTime = CommonUtils.beginTime1;
        if (CommonUtils.beginTime2 < CommonUtils.beginTime1) {
            beginTime = CommonUtils.beginTime2;
        }

        long endTime = CommonUtils.endTime1;
        if (CommonUtils.endTime2 > CommonUtils.endTime1) {
            endTime = CommonUtils.endTime2;
        }

        System.out.println("耗时：" + ((endTime - beginTime) / 1000));
    }
}
