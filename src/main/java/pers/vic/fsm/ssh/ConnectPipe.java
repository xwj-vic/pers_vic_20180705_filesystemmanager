package pers.vic.fsm.ssh;

import java.io.*;
import java.net.Socket;

/**
 * Create By Vic Xu on 7/5/2018
 */
public class ConnectPipe {


    public BufferedReader reader(Socket socket) throws IOException {
        return new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public BufferedWriter writer(Socket socket) throws IOException {
        return new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }
}
