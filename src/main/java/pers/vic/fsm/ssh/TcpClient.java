package pers.vic.fsm.ssh;

import java.io.*;
import java.net.Socket;

/**
 * Create By Vic Xu on 7/5/2018
 */
public class TcpClient {

    public static void main(String[] args) throws IOException {
        TcpClient client = new TcpClient();
        client.client("127.0.0.1", 9008);
    }

    public void client(String ip, int port) throws IOException {
        Socket socket = new Socket(ip, port);
        ConnectPipe pipe = new ConnectPipe();
        BufferedReader reader = pipe.reader(socket); //接收服务端
        BufferedWriter writer = pipe.writer(socket); //向服务端输出
        BufferedReader inputOrder = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!(line = inputOrder.readLine()).equals("bye")) {
            writer.write(line+"\n");
            writer.flush();
            //服务端返回
            reader.lines().forEach(System.out::println);
        }
        writer.close();
        reader.close();
        socket.close();
    }
}
