package multithread;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/2/14 18:21
 */
public class ReadData {

    public void readMethod(PipedInputStream input) {
        try {
            System.out.println("read  :");
            byte[] byteArray = new byte[20];
            int readLength = input.read(byteArray);
            while (readLength != -1) {
                String newData = new String(byteArray, 0, readLength);
                System.out.print(" newData="+newData);
                readLength = input.read(byteArray);
            }
            System.out.println();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
