package pers.vic.fsm.test;

import org.junit.Assert;
import org.junit.Test;
import pers.vic.fsm.ssh.TcpClient;
import pers.vic.fsm.ssh.TcpServer;

import java.io.IOException;

/**
 * Create by Vic Xu on 2018/7/5
 */
public class TcpTest {

    @Test
    public void tcpServerTest() {
        TcpServer server = new TcpServer();
        try {
            server.server(9008);
            Assert.assertTrue(true);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.assertTrue(false);
        }
    }

    @Test
    public void tcpClientTest() {
        TcpClient client = new TcpClient();
        try {
            client.client("127.0.0.1", 9008);
            Assert.assertTrue(true);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.assertTrue(false);
        }
    }
}
