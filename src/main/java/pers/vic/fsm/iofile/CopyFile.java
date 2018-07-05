package pers.vic.fsm.iofile;


import java.io.*;
import java.util.Objects;

/**
 * Create By Vic Xu on 7/5/2018
 */
public class CopyFile {

    public String[] getAndCopyFile(String source, String target) {
        BufferedInputStream inputStream = null;
        BufferedOutputStream outputStream = null;
        String[] result = new String[1];
        String notice = null;
        try {
//            Iterate through the files in the folder
            File oldFile = new File(source);
            File newFile = new File(target);
            if (!new File(target).exists())
                newFile.mkdir();
            if (oldFile.exists()) {
                File[] files = oldFile.listFiles();
//            Copy files
                for (File f : Objects.requireNonNull(files)) {
                    if (f.isDirectory())
                        getAndCopyFile(f.getAbsolutePath(), target + File.separator + f.getName());
                    else {
                        inputStream = new BufferedInputStream(new FileInputStream(f));
                        outputStream = new BufferedOutputStream(new FileOutputStream(target + File.separator + f.getName()));
                        int m;
                        while ((m = inputStream.read()) != -1) {
                            outputStream.write(m);
                        }
                        outputStream.flush();
                    }
                }
            } else {
                notice = "The folder have not file!";
                result[0] = notice;
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                Objects.requireNonNull(outputStream).close();
                Objects.requireNonNull(inputStream).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    //Ls
    public void showFileList(String source) {
        File file = new File(source);
        if (file.exists()) {
            File[] files = file.listFiles();
            System.out.println("Files List:");
            for (File f : files) {
                System.out.println(f.getName() + "\\t" + f.getAbsolutePath());
            }
        } else {
            System.out.println("Nothing");
        }
    }

    /**
     * remove file
     * rm+space+fileName
     *
     * @param source
     * @param fileName
     */
    public void removeFiles(String source, String fileName) {
        File file = new File(source);
        if (file.exists()) {
            File[] files = file.listFiles();
            boolean flag = false;
            for (File f : Objects.requireNonNull(files)) {
                if (f.getName().equals(fileName)) {
                    f.delete();
                    System.out.println("remove success");
                    flag = true;
                    break;
                }
            }
            if (!flag)
                System.out.println("No such file");
        } else {
            System.out.println("Nothing");
        }
    }

}
