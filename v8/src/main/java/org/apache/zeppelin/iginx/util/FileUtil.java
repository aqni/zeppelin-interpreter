package org.apache.zeppelin.iginx.util;

import java.io.*;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtil {
  private static final Logger LOGGER = LoggerFactory.getLogger(FileUtil.class);

  /**
   * 检查系统目录中是否加载了依赖文件
   *
   * @param path
   * @return
   */
  public static boolean isDirectoryLoaded(String path) {
    File directory = new File(path);
    if (!directory.exists()) {
      LOGGER.warn("提供的文件不是一个目录，或者目录不存在");
      return false;
    }
    return directory.isDirectory() && directory.list().length != 0;
  }

  /**
   * 将jar包中的文件复制到系统目录下
   *
   * @param jarPath
   * @param directoryInJar
   * @param targetDirectory
   * @throws IOException
   */
  public static void extractDirectoryFromJar(
      String jarPath, String directoryInJar, String targetDirectory) throws IOException {
    File jarFile = new File(jarPath);
    try (JarFile jar = new JarFile(jarFile)) {
      Enumeration<JarEntry> entries = jar.entries();
      while (entries.hasMoreElements()) {
        JarEntry entry = entries.nextElement();
        String name = entry.getName();
        if (name.startsWith(directoryInJar)) {
          File targetFile = new File(targetDirectory + name.substring(directoryInJar.length()));
          if (entry.isDirectory()) {
            // 创建目录
            targetFile.mkdirs();
          } else {
            // 创建文件
            targetFile.getParentFile().mkdirs();
            try (InputStream is = jar.getInputStream(entry);
                OutputStream os = new FileOutputStream(targetFile)) {
              // 复制文件内容
              byte[] buffer = new byte[4096];
              int len;
              while ((len = is.read(buffer)) > 0) {
                os.write(buffer, 0, len);
              }
            }
          }
        }
      }
    }
  }
}
