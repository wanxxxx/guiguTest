package IP;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author f
 * @version 1.0
 * @Date 2020/12/22
 * @Description
 */
public class UrlTest {
    public static void main(String[] args) {
        URL url = null;
        URLConnection urlConnection = null;
        InputStream is=null;
        FileOutputStream fos=null;
        try {
            url = new URL("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2184374374,1234398023&fm=26&gp=0.jpg");
            urlConnection = url.openConnection();
            urlConnection.connect();
            is= urlConnection.getInputStream();
            fos = new FileOutputStream(new File("2.png"));
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            System.out.println("下载完成");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (urlConnection != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
