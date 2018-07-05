package pers.vic.fsm.iofile;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Create By Vic Xu on 7/5/2018
 */
public class FileOperation {

    /**
     * recursion
     * @param source
     * @param target
     * @return
     */
    public List<String> getAndCopyFile(String source, String target) {
        BufferedInputStream inputStream = null;
        BufferedOutputStream outputStream = null;
        List<String> resultList = new ArrayList<>();
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
                        getAndCopyFile(f.getAbsolutePath(), target + File.separator + f.getName()); //recursion
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
            } else
                resultList.add("The folder have not file!");
            return resultList;
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
        return resultList;
    }

    //Ls
    public List<String> showFileList(String source) {
        File file = new File(source);
        List<String> resultList = new ArrayList<>();
        if (file.exists()) {
            File[] files = file.listFiles();
            for (File f : files)
                resultList.add(f.getAbsolutePath());
        } else
            resultList.add("cannot find the file");
        return resultList;
    }

    /**
     * remove file
     * rm+space+fileName
     *recursion
     * @param path
     */
    public List<String> removeFiles(String path, String... r) {
        File file = new File(path);
        List<String> resultList = new ArrayList<>();
//        delete folds
        if (file.isDirectory() && r[0].equals("-r")) {
            File[] itemFile = file.listFiles();
            for (File p : Objects.requireNonNull(itemFile)) {
                if (p.isDirectory())
                    removeFiles(p.getAbsolutePath(), "-r"); //recursion
                else
                    p.delete();
            }
            file.delete();
        } else
            resultList.add("this is a folder");

//        delete file
        if (file.exists() && r[0].equals(""))
            file.delete();
        else
            resultList.add("cannot find the file");
        return resultList;
    }

}
