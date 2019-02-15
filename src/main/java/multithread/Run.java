package multithread;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @Description  管道输入/输出流    Question : 有什么用？
 * 管道输入/输出流主要用于线程之间的数据传输，而且传输的媒介为内存
 * 面向字节： PipedOutputStream、 PipedInputStream
 * 面向字符: PipedWriter、 PipedReader
 * @Author xiaohu
 * @Date 2019/2/14 18:25
 */
public class Run {

    public static void main(String[] args) {

        try {
            WriteData writeData = new WriteData();
            ReadData readData = new ReadData();

            PipedInputStream inputStream = new PipedInputStream();
            PipedOutputStream outputStream = new PipedOutputStream();

            // 通过outputStream.connect(inputStream)或inputStream.connect(outputStream)使两个管道流产生链接，这样就可以将数据进行输入与输出了
            // inputStream.connect(outputStream);
            outputStream.connect(inputStream);

            ThreadRead threadRead = new ThreadRead(readData, inputStream);
            threadRead.start();

            Thread.sleep(2000);

            ThreadWrite threadWrite = new ThreadWrite(writeData, outputStream);
            threadWrite.start();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
