package IP;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author f
 * @version 1.0
 * @Date 2020/12/21
 * @Description 服务器接收客户端传输的消息，并打印到控制台
 */
public class TcpTest1 {
    public static void main(String[] args) throws UnknownHostException {

        InetAddress iad = InetAddress.getByName("www.atguigu.com");
        InetAddress iploc = InetAddress.getLocalHost();
        System.out.println(iad);
        System.out.println(iploc);
    }

    @Test
    public void client() {
        InetAddress inet = null;
        Socket socket = null;
        OutputStream os = null;
        try {
            inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet, 8899);
            os = socket.getOutputStream();
            os.write("你好，我是客户端".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }
    }

    @Test
    public void server() throws IOException {
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            ss = new ServerSocket(8899);
            socket = ss.accept();
            is = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[20];
            int len;
            while ((len = is.read(buffer)) != -1) {
               /* String str = new String(buffer, 0, len);
                System.out.println(str);*/
                baos.write(buffer, 0, len);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (baos != null) {
                //5.关闭资源
                try {
                    baos.close();
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
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}

