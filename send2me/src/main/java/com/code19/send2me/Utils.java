package com.code19.send2me;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by gh0st on 2016/12/5.
 */

public class Utils {
    public static void closeIO(Closeable... closeables) {
        if (null == closeables || closeables.length <= 0) {
            return;
        }
        for (Closeable cb : closeables) {
            try {
                if (null == cb) {
                    continue;
                }
                cb.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean writeFile(String filename, String content, boolean append) {
        boolean isSuccess = false;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(filename, append));
            bufferedWriter.write(content);
            isSuccess = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeIO(bufferedWriter);
        }
        return isSuccess;
    }
}
