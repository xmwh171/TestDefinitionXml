package multithread;

import java.io.PipedOutputStream;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/2/14 18:22
 */
public class ThreadWrite extends Thread {

    private WriteData write;
    private PipedOutputStream out;

    public ThreadWrite(WriteData write, PipedOutputStream out) {
        super();
        this.write = write;
        this.out = out;
    }

    @Override
    public void run() {
        write.writeMethod(out);
    }
}
