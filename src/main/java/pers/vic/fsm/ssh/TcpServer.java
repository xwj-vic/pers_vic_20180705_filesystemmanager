package pers.vic.fsm.ssh;

import pers.vic.fsm.order.CharOrder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Create By Vic Xu on 7/5/2018
 */
public class TcpServer {

    public static void main(String[] args) throws IOException {
        TcpServer server = new TcpServer();
        server.server(9008);
    }

    public void server(int port) throws IOException {
        ServerSocket server = new ServerSocket(port);
        Socket socket = server.accept();
        System.out.println("client " + socket.hashCode() + " connected");
        ConnectPipe pipe = new ConnectPipe();
        BufferedReader reader = pipe.reader(socket); //接收客户端
        final BufferedWriter writer = pipe.writer(socket); //向客户端输出
        String line;
//        接手客户端请求处理
        while (!(line = reader.readLine()).equals("bye")) {
//            CharOrder charOrder = new CharOrder(line);
//            charOrder.handle();
            //具体处理逻辑
            String[] strings = new String[] {"a","b","c","d"};
//            List<String> list = new ArrayList<>();
//            list.add("a");
//            list.add("b");
//            for (String s : list) {
//                writer.write(s + "\n");
//                writer.flush();
//            }
            for (String s : strings) {
                writer.write(s + "\n");
                writer.flush();
            }
        }
        writer.close();
        reader.close();
        socket.close();
    }
}
