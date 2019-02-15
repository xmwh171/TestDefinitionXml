package multithread;

import java.io.PipedInputStream;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/2/14 18:22
 */
public class ThreadRead extends Thread {

    private ReadData read;
    private PipedInputStream input;

    public ThreadRead(ReadData read, PipedInputStream input) {
        super();
        this.read = read;
        this.input = input;
    }

    @Override
    public void run() {
        read.readMethod(input);
    }
}
