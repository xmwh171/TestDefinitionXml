package multithread;

import java.util.Date;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/2/18 10:51
 */
public class WorkerThread implements Runnable {

    private String command;

    public WorkerThread(String s) {
            this.command = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Time = " + new Date());
       // processCommand();
        System.out.println(Thread.currentThread().getName() + " End. Time = " + new Date());
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}
