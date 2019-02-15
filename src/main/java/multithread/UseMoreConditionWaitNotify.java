package multithread;

/**
 * @Description 使用多个Condition实例实现等待/通知机制
 * @Author xiaohu
 * @Date 2019/2/15 14:53
 */
public class UseMoreConditionWaitNotify {

    public static void main(String[] args) throws InterruptedException {

        MyServiceMoreCondition service = new MyServiceMoreCondition();

        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();

        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();

        Thread.sleep(3000);

        service.signalAll_A();

    }
    static public class ThreadA extends Thread {

        private MyServiceMoreCondition service;

        public ThreadA(MyServiceMoreCondition service) {
            super();
            this.service = service;
        }

        @Override
        public void run() {
            service.awaitA();
        }
    }
    static public class ThreadB extends Thread {

        private MyServiceMoreCondition service;

        public ThreadB(MyServiceMoreCondition service) {
            super();
            this.service = service;
        }

        @Override
        public void run() {
            service.awaitB();
        }
    }
}
