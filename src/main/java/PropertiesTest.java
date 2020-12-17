import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * @author f
 * @version 1.0
 * @Date 2020/12/16
 * @Description
 */
public class PropertiesTest {
    public static void main(String[] args) throws Exception {
        Properties properties=new Properties();
        properties.load(new FileInputStream("jdbc.properties"));
        String name = properties.getProperty("name");
        String password = properties.getProperty("password");
        System.out.println(name + password);

    }
}
