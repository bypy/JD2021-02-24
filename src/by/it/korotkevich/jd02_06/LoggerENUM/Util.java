package by.it.korotkevich.jd02_06.LoggerENUM;

import java.io.File;

public class Util {
    public static File getFile(Class<?> aClass, String fileName) {
        String packageName = aClass.getPackageName();
        String root = System.getProperty("user.dir");
        String dir = root + File.separator + "src" + File.separator + packageName.replace(".", File.separator);
        return new File(dir, fileName);
    }
}
