package multithread;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/2/13 14:39
 */
public class ThreadB extends Thread {

    private HasSelfPrivateNum numRef;

    public ThreadB(HasSelfPrivateNum numRef) {
            super();
            this.numRef = numRef;
        }

        @Override
        public void run() {
            super.run();
            numRef.addI("b");
        }
}
