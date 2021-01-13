package IO;

import org.junit.Test;

import java.io.*;

/**
 * @author f
 * @version 1.0
 * @Date 2020/12/21
 * @Description
 */

public class BufferedIOTest {
    @Test
    public void test() {
        File fr = new File("华研标志-白色.png");
        File fw = new File("华研标志-白色2.png");
        //节点流（文件流）
        FileInputStream fis = null;
        FileOutputStream fos = null;
        //缓冲流（处理流）
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            fis = new FileInputStream(fr);
            fos = new FileOutputStream(fw);
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            byte[] buffer = new byte[5];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //先关闭外层
                bis.close();
                bos.close();
                fis.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test2() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("hello1.txt")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("hello2.txt")));

        String data = null;
        while ((data = br.readLine()) != null) {
            System.out.println(data);
            bw.write(data);
            bw.newLine();
        }
        br.close();
        bw.close();

    }
}
