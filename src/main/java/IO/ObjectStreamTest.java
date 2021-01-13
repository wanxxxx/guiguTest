package IO;

import Reflection.Person;
import org.junit.Test;

import java.io.*;
import java.nio.file.Path;

/**
 * @author f
 * @version 1.0
 * @Date 2020/12/21
 * @Description
 */
public class ObjectStreamTest {

    /**
     * 将对象序列化
     * 也就是：内存中的对象--->存储中的文件、通过网络传输出去
     */
    @Test
    public void ObjectOutputStreamTest() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
            oos.writeObject(new String("这是一个字符串"));
            oos.writeObject(new Person("方希", 23));
            oos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @Test
    public void ObjectInputStreamTest() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.dat"));
        String s = (String) ois.readObject();
        Person p = (Person) ois.readObject();
        System.out.println(s);
        System.out.println(p);
    }
}
