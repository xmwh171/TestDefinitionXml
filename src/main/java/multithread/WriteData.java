package multithread;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/2/14 18:23
 */
public class WriteData {

    public void writeMethod(PipedOutputStream out) {
        try {
            System.out.println("write :");
            for (int i = 0; i < 300; i++) {
                String outData = "" + (i + 1);
                out.write(outData.getBytes());
                System.out.print(" outData="+outData);
            }
            System.out.println();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
