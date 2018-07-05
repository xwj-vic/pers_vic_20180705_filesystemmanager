package pers.vic.fsm.ssh;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Create By Vic Xu on 7/5/2018
 */
public class TcpClient {

    public static void main(String[] args) {
        TcpClient client = new TcpClient();
        try {
            client.client("127.0.0.1", 9008);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void client(String ip, int port) throws IOException {
        Socket socket = new Socket(ip, port);
        ConnectPipe pipe = new ConnectPipe();
        BufferedReader reader = pipe.reader(socket);
        BufferedWriter writer = pipe.writer(socket);
        BufferedReader inputOrder = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!(line = inputOrder.readLine()).equals("bye")) {
            writer.write(line);
            writer.newLine();
            writer.flush();
            //Server response
            reader.lines().forEach(System.out::println);
        }
        writer.close();
        reader.close();
        inputOrder.close();
        socket.close();
    }
}
