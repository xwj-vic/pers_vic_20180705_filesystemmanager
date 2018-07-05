package pers.vic.fsm.test;

import org.junit.Assert;
import org.junit.Test;
import pers.vic.fsm.iofile.FileOperation;

import java.util.List;

/**
 * Create by Vic Xu on 2018/7/5
 */
public class FileOperationTest {

    @Test
    public void getAndCopyFileTest() {
        FileOperation fileOperation = new FileOperation();
        String oldPath = "G:\\ITA\\JAVA";
        String newPath = "G:\\ITA\\JAVA2";
        List<String> list = fileOperation.getAndCopyFile(oldPath, newPath);
        Assert.assertTrue(list.size() ==0);
    }

    @Test
    public void showFileListTest() {
        FileOperation fileOperation = new FileOperation();
        String path = "G:\\ITA\\JAVA";
        List<String> list = fileOperation.showFileList(path);
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void removeFilesTest() {
        FileOperation fileOperation = new FileOperation();
        String path = "G:\\ITA\\JAVA";
//        List<String> list = fileOperation.removeFiles(path, "-r");
//        Assert.assertTrue(list.size() == 0);

        List<String> list1 = fileOperation.removeFiles(path, "-1vbnvb");
        Assert.assertTrue(list1.size() == 0);
    }
}
