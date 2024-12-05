package org.apache.zeppelin.iginx.util;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileUtil {
  public static void writeToFile(String content, String filePath) {
    try (FileOutputStream fos = new FileOutputStream(filePath);
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        BufferedWriter writer = new BufferedWriter(osw)) { // 使用BufferedWriter提高效率

      writer.write(content);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
