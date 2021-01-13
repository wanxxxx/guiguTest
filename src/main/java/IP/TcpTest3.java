package IP;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author f
 * @version 1.0
 * @Date 2020/12/21
 * @Description 服务器接收文件后，反馈信息给客户端 .
 */
public class TcpTest3 {

    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        InputStream is = null;
        FileInputStream fr = null;
        ByteArrayOutputStream baos = null;
        try {
            //获取ip和端口号
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 8899);
            //获取一个输出流，输出数据
            os = socket.getOutputStream();
            //获取要传输的文件
            fr = new FileInputStream(new File("华研标志-白色.png"));
            //写数据
            byte[] buffer = new byte[5];
            int len;
            while ((len = fr.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
            //图片传完后，服务器也不会停止接收信息，会一直“阻塞”，等待客户端传数据
            //所以需要手动停止客户端的传输
            socket.shutdownOutput();
            //接收服务器信息
            is = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            System.out.println(baos.toString());
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
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }
    }

    @Test
    public void server() {
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        FileOutputStream fw = null;
        OutputStream os = null;
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
            System.out.println("图片传输完成");
            //服务器反馈信息给客户端
            os = socket.getOutputStream();
            os.write("服务器已成功接收文件".getBytes());

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
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}

