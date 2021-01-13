package IP;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author f
 * @version 1.0
 * @Date 2020/12/21
 * @Description 客户端发送文件，服务器端保存
 */
public class TcpTest2 {

    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fr = null;
        try {
            //获取ip和端口号
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 8899);
            //获取一个输出流，输出数据
            os = socket.getOutputStream();
            //获取要传输的文件
            fr = new FileInputStream(new File("华研标志-白色.png"));
            //写数据
            byte[] data = new byte[5];
            int len;
            while ((len = fr.read(data)) != -1) {
                os.write(data, 0, len);
            }
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
            if (fr != null) {
                try {
                    fr.close();
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
        FileOutputStream fw = null;
        try {
            ss = new ServerSocket(8899);
            socket = ss.accept();
            is = socket.getInputStream();
            fw = new FileOutputStream(new File("华研标志-白色2.png"));
            byte[] buffer = new byte[20];
            int len;
            while ((len = is.read(buffer)) != -1) {
                fw.write(buffer, 0, len);
            }

            System.out.println("");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                //5.关闭资源
                try {
                    fw.close();
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

