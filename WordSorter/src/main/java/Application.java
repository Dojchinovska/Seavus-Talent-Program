import org.apache.commons.io.FileUtils;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) throws IOException {

        File file = new File("file.txt");
        String content = FileUtils.readFileToString(file, "UTF-8");
        String[] words = content.split(" ");
        List<String> list = new ArrayList<>();

        System.out.println("Enter 'asc' for ascending and 'desc' for descending order: ");
        String sortBy = new Scanner(System.in).nextLine().toLowerCase();

        list = Arrays.stream(words)
                .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase())
                .collect(Collectors.toList());

        if (sortBy.equals("asc")) {
            Collections.sort(list, new AscendingLengthComparator());
        } else if (sortBy.equals("desc")) {
            Collections.sort(list, new DescendingLengthStringComparator());
        } else {
            System.out.println("Invalid input");
            return;
        }
        list.stream().distinct().forEach(System.out::println);
    }

    static class AscendingLengthComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return Integer.compare(o1.length(), o2.length());
        }
    }

    static class DescendingLengthStringComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return -Integer.compare(o1.length(), o2.length());
        }
    }
}
