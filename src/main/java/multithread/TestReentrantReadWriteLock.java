package multithread;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/2/15 15:41
 */
public class TestReentrantReadWriteLock {

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void read() {
        try {
            try {
                lock.readLock().lock();
                System.out.println("获得读锁" + Thread.currentThread().getName()
                        + " " + System.currentTimeMillis());
                Thread.sleep(5000);
            } finally {
                lock.readLock().unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void write() {
        try {
            try {
                lock.writeLock().lock();
                System.out.println("获得写锁" + Thread.currentThread().getName()
                        + " " + System.currentTimeMillis());
                Thread.sleep(5000);
            } finally {
                lock.writeLock().unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static public class ThreadA extends Thread{
        private TestReentrantReadWriteLock testLock;

        public ThreadA(TestReentrantReadWriteLock testLock) {
            super();
            this.testLock = testLock;
        }

        @Override
        public void run() {
            testLock.read();
        }
    }


    static public class ThreadB extends Thread{
        private TestReentrantReadWriteLock testLock;

        public ThreadB(TestReentrantReadWriteLock testLock) {
            super();
            this.testLock = testLock;
        }

        @Override
        public void run() {
            testLock.write();
        }
    }

    /**
     * 读写锁维护了两个锁，一个是读操作相关的锁也成为共享锁，一个是写操作相关的锁 也称为排他锁。通过分离读锁和写锁，其并发性比一般排他锁有了很大提升。
     * 多个读锁之间不互斥，读锁与写锁互斥，写锁与写锁互斥（只要出现写操作的过程就是互斥的）。
     * @param args
     */
    public static void main(String[] args) {
        TestReentrantReadWriteLock testReentrantReadWriteLock = new TestReentrantReadWriteLock();
        ThreadA threadA = new ThreadA(testReentrantReadWriteLock);
        threadA.setName("A");
        threadA.start();

        ThreadB threadB = new ThreadB(testReentrantReadWriteLock);
        threadB.setName("B");
        threadB.start();

        ThreadA[] threadAS = new ThreadA[3];
        ThreadB[] threadBS = new ThreadB[3];

        for(int i=0; i<3; i++){
            threadAS[i] = new ThreadA(testReentrantReadWriteLock);
            threadBS[i] = new ThreadB(testReentrantReadWriteLock);
            threadAS[i].start();
            threadBS[i].start();
        }

    }
}
