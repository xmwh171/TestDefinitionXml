package multithread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description  ReentrantLock（排他锁）具有完全互斥排他的效果，即同一时刻只允许一个线程访问
 * @Author xiaohu
 * @Date 2019/2/15 14:34
 */
public class ReentrantLockTest {

    public static void main(String[] args) {

        MyService service = new MyService();

        MyThread a1 = new MyThread(service);
        MyThread a2 = new MyThread(service);
        MyThread a3 = new MyThread(service);
        MyThread a4 = new MyThread(service);
        MyThread a5 = new MyThread(service);

        a1.start();
        a2.start();
        a3.start();
        a4.start();
        a5.start();

    }

    static public class MyService {

        private Lock lock = new ReentrantLock();

        public void testMethod() {
            lock.lock();
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("ThreadName=" + Thread.currentThread().getName() + (" " + (i + 1)));
                }
            } finally {
                lock.unlock();
            }
        }
    }

    static public class MyThread extends Thread {

        private MyService service;

        public MyThread(MyService service) {
            super();
            this.service = service;
        }

        @Override
        public void run() {
            service.testMethod();
        }
    }
}
