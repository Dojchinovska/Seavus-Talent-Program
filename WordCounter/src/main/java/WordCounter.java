import org.apache.commons.io.FileUtils;

import java.io.*;

import java.util.*;

import static java.lang.System.*;
import static org.apache.commons.io.FileUtils.readFileToString;

public class WordCounter {
    public static void main(String[] args) throws IOException {

        File file = new File("file.txt");
        String content = FileUtils.readFileToString(file, "UTF-8");
        String[] words = content.split(" ");
        HashMap<String, Integer> m = new HashMap<String, Integer>();

        for (String word : words) {
            String tmp = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
            m.put(tmp, (m.containsKey(tmp) ? m.get(tmp) + 1 : 1));
        }

        for (HashMap.Entry<String, Integer> value : m.entrySet()) {
            out.println("<" + value.getKey() + "> : <" + value.getValue() + ">");
        }
    }
}
