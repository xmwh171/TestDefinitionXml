package multithread;

/**
 * @Description   return停止线程
 * @Author xiaohu
 * @Date 2019/2/13 13:24
 */
public class MyThread1 extends Thread {

        @Override
        public void run() {
            while (true) {
                if (this.isInterrupted()) {
                    System.out.println("ֹͣ停止了!");
                    return;
                }
                System.out.println("timer=" + System.currentTimeMillis());
            }
        }

        public static void main(String[] args) throws InterruptedException {
            MyThread1 t = new MyThread1();
            t.start();
            Thread.sleep(2000);
            t.interrupt();
         }

}
