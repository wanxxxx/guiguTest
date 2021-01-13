package IO;

import org.junit.Test;

import java.io.*;

/**
 * @author f
 * @version 1.0
 * @Date 2020/12/21
 * @Description
 */
public class SystemInOut {
    /*如果放在非main方法里，是输入不了东西的，这是idea本身的问题，eclipse可以放在test方法里*/
    public static void main(String[] args) {
        BufferedReader br = null;
        FileWriter fw = null;
        try {

            br = new BufferedReader(new InputStreamReader(System.in));
            fw = new FileWriter(new File("a.txt"));


            while (true) {
                System.out.println("请输入字符串");
                String data = br.readLine();
                if (data.equals("e") || data.equals("exit")) {
                    break;
                }
                            fw.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                fw.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
