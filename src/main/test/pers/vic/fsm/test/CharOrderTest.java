package pers.vic.fsm.test;

import org.junit.Assert;
import org.junit.Test;
import pers.vic.fsm.order.CharOrder;

/**
 * Create by Vic Xu on 2018/7/5
 */
public class CharOrderTest {

    @Test
    public void handleTest() {
        String keyWord = "ls G:\\ITA\\JAVA";
        CharOrder charOrder = new CharOrder(keyWord);
        Assert.assertTrue(charOrder.handle().size() > 0);
    }

    @Test
    public void handleTest1() {
        String keyWord = "cp G:\\ITA\\JAVA G:\\ITA\\JAVA2";
        CharOrder charOrder = new CharOrder(keyWord);
        Assert.assertTrue(charOrder.handle().size() == 0);
    }

    @Test
    public void handleTest2() {
        String keyWord = "rm G:\\ITA\\JAVA";
        CharOrder charOrder = new CharOrder(keyWord);
        Assert.assertTrue(charOrder.handle().size() == 0);
    }
}
