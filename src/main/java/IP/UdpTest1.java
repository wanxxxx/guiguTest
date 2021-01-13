package IP;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 * @author f
 * @version 1.0
 * @Date 2020/12/22
 * @Description
 */
public class UdpTest1 {
    public static void main(String[] args) {
        UdpTest1 u = new UdpTest1();
        u.receiver();
        u.sender();
    }
    @Test
    public void sender() {
        DatagramSocket socket = null;
        DatagramPacket packet = null;
        InetAddress inet = null;
        try {
            socket = new DatagramSocket();
            inet = InetAddress.getLocalHost();
            String str="UDP数据报";
            byte[] data = str.getBytes();
            packet = new DatagramPacket(data, 0, data.length, inet, 9090);
            socket.send(packet);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }

    @Test
    public void receiver() {
        DatagramSocket socket = null;
        DatagramPacket packet = null;
        InetAddress inet = null;
        try {
            socket = new DatagramSocket(9090);

            byte[] buffer=new byte[100];
            packet = new DatagramPacket(buffer,0,buffer.length);

            socket.receive(packet);
            System.out.println(new String(packet.getData(),0, packet.getLength()));

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}
