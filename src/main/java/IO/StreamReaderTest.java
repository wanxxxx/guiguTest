package IO;

import org.junit.Test;

import java.io.*;

/**
 * @author f
 * @version 1.0
 * @Date 2020/12/21
 * @Description
 */
public class StreamReaderTest {
    @Test
    public void test1() throws IOException {

        FileInputStream fis = new FileInputStream("hello1.txt");
//        InputStreamReader isr = new InputStreamReader(fis);//使用系统默认的字符集
        //参数2指明了字符集，具体使用哪个字符集，取决于文件dbcp.txt保存时使用的字符集
        InputStreamReader isr = new InputStreamReader(fis, "GBK");//使用指定的字符集

        char[] cbuf = new char[20];
        int len;
        while ((len = isr.read(cbuf)) != -1) {
            String str = new String(cbuf, 0, len);
            System.out.print(str);
        }

        isr.close();

    }

    @Test
    //将复制文件换字符集
    public void test2() throws IOException {

        InputStreamReader isr = new InputStreamReader(new FileInputStream("hello1.txt"), "utf-8");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("hello2.txt"), "gbk");

        char[] cbuf = new char[5];
        int len;
        while ((len = isr.read(cbuf)) != -1) {
            osw.write(cbuf, 0, len);
        }
        osw.close();
        isr.close();

    }
}
