package pers.vic.fsm.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pers.vic.fsm.iofile.FileOperation;

import java.util.Collections;
import java.util.List;

/**
 * Create By Vic Xu on 7/5/2018
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
public class CharOrder {

    private String keyWord;

    public List<String> handle() {
        FileOperation fileOperation = new FileOperation();
        String[] keys = splits();
        switch (keys[0]) {
            case "cp":
                return fileOperation.getAndCopyFile(keys[1], keys[2]);
            case "rm":
                if (keys.length == 3)
                    return fileOperation.removeFiles(keys[2], keys[1]);
                else
                    return fileOperation.removeFiles(keys[1], "");
            case "ls":
                return fileOperation.showFileList(keys[1]);
            default:
                return Collections.emptyList();
        }
    }

    public String[] splits() {
        return this.keyWord.split(" ");
    }
}
