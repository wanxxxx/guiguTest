package IO;

import org.junit.Test;

import java.io.*;
import java.util.Date;

/**
 * @author f
 * @version 1.0
 * @Date 2020/12/20
 * @Description
 */
public class FileInputTest {
    @Test
    public void test() {
        File file = new File("C:\\Users\\f\\Desktop\\data\\file1");
        FileInputStream is = null;
        try {
            is = new FileInputStream(file);
            int read;
            while ((read = is.read()) != -1) {
                System.out.println((char) read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test2() {
        File file = new File("C:\\Users\\f\\Desktop\\data\\file1");
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            char[] read = new char[5];
            int len = fr.read(read);

            while (len != -1) {
                //System.out.println(read);
                String str = new String(read, 0, len);
                System.out.println(str);
                len = fr.read(read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    //复制文本文件
    public void test3() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader(new File("hello1.txt"));
            fw = new FileWriter(new File("hello2.txt"));
            char[] data = new char[5];
            int len;
            while ((len = fr.read(data)) != -1) {
                fw.write(data, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    //复制非文本文件，使用字节流不能使用字符流
    public void test4() {
        FileInputStream fr = null;
        FileOutputStream fw = null;
        try {
            fr = new FileInputStream(new File("华研标志-白色.png"));
            fw = new FileOutputStream(new File("华研标志-白色2.png"));
            byte[] data = new byte[5];
            int len;
            while ((len = fr.read(data)) != -1) {
                fw.write(data, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    //复制视频
    public void test5() {
        for (int i = 0; i < 5; i++) {


            FileInputStream fr = null;
            FileOutputStream fw = null;
            Date start = null;
            Date end = null;
            try {
                fr = new FileInputStream(new File("D:\\hi\\task11-\\task13\\1.mp3"));
                fw = new FileOutputStream(new File("D:\\hi\\task11-\\task13\\2.mp3"));
                byte[] data = new byte[1024];
                int len;
                start = new Date();
                while ((len = fr.read(data)) != -1) {
                    fw.write(data, 0, len);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    end = new Date();
                    System.out.println("Time spend " + (end.getTime() - start.getTime()));
                    fr.close();
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
