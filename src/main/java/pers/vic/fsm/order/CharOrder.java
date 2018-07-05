package pers.vic.fsm.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pers.vic.fsm.iofile.CopyFile;

/**
 * Create By Vic Xu on 7/5/2018
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
public class CharOrder {

    private String keyWord;

    public void handle() {
        CopyFile copyFile = new CopyFile();
        String[] keys = splits();
        switch (keys[0]) {
            case "cp":
                copyFile.getAndCopyFile(keys[1], keys[2]);
                break;
            case "rm":
                copyFile.removeFiles(keys[1],keys[2]);
                break;
            case "ls":
                copyFile.showFileList(keys[0]);
                break;
            default:
                break;
        }
    }

    public String[] splits() {
        return this.keyWord.split(" ");
    }
}
