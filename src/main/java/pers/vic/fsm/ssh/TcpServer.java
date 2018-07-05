package pers.vic.fsm.ssh;

import pers.vic.fsm.order.CharOrder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 * Create By Vic Xu on 7/5/2018
 */
public class TcpServer {

    public static void main(String[] args) {
        TcpServer server = new TcpServer();
        try {
            server.server(9008);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void server(int port) throws IOException {
        ServerSocket server = new ServerSocket(port);
        while (true) {
            Socket socket = server.accept();
            System.out.println("client " + socket.hashCode() + " connected");
            ConnectPipe pipe = new ConnectPipe();
            BufferedReader reader = pipe.reader(socket);
            final BufferedWriter writer = pipe.writer(socket);
            String line;
            while (!(line = reader.readLine()).equals("bye")) {
                CharOrder charOrder = new CharOrder(line);
                List<String> list = charOrder.handle();
                for (String s : list) {
                    writer.write(s);
                    writer.newLine();
                    writer.flush();
                }
            }
            writer.close();
            reader.close();
            socket.close();
        }
    }
}
