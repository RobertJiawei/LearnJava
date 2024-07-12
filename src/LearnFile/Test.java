package LearnFile;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// get the number of each type of file in a directory.

public class Test {
    public static void main(String[] args) {
        File file = new File("/Users/wjw/School/Programming practice/LearnJava/LearnJava/src");
        System.out.println(getCount(file));
    }

    // count number of a file type
    public static HashMap<String, Integer> getCount(File f) {
        HashMap<String, Integer> hm = new HashMap<>();

        File[] files = f.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String name = file.getName();
                    String[] arr = name.split("\\.");
                    if (arr.length >= 2) {
                        String endName = arr[arr.length - 1];
                        if (hm.containsKey(endName)) {
                            int count = hm.get(endName);
                            count++;
                            hm.put(endName, count);
                        } else {
                            hm.put(endName, 1);
                        }
                    }
                } else {
                    HashMap<String, Integer> sumMap = getCount(file);
                    Set<Map.Entry<String, Integer>> entries = sumMap.entrySet();
                    for (Map.Entry<String, Integer> entry : entries) {
                        String key = entry.getKey();
                        int value = entry.getValue();
                        if (hm.containsKey(key)) {
                            hm.put(key, hm.get(key) + value);
                        } else {
                            hm.put(key, value);
                        }
                    }
                }
            }
        }
        return hm;
    }
}
