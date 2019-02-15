package multithread;

/**
 * @Description 对象与锁
 * @Author xiaohu
 * @Date 2019/2/13 14:15
 */
public class HasSelfPrivateNum {

    private int num = 0;

    /**
     * synchronized取得的锁都是对象锁
     * @param username
     */
    synchronized public void addI(String username) {
        try {
            if (username.equals("a")) {
                num = 100;
                System.out.println("a set over!");
                //如果去掉hread.sleep(2000)，那么运行结果就会显示为同步的效果
                Thread.sleep(2000);
            } else {
                num = 200;
                System.out.println("b set over!");
            }
            System.out.println(username + " num=" + num);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        // 多个对象多个锁
//        HasSelfPrivateNum numRef1 = new HasSelfPrivateNum();
//        HasSelfPrivateNum numRef2 = new HasSelfPrivateNum();
//        ThreadA athread = new ThreadA(numRef1);
//        athread.start();
//        ThreadB bthread = new ThreadB(numRef2);
//        bthread.start();

        // 多个线程访问一个对象
        HasSelfPrivateNum numRef1 = new HasSelfPrivateNum();
        ThreadA athread = new ThreadA(numRef1);
        athread.start();
        ThreadB bthread = new ThreadB(numRef1);
        bthread.start();
    }

}
