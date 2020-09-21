import org.apache.commons.io.FileUtils;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) throws IOException {

        File file = new File("file.txt");
        String content = FileUtils.readFileToString(file, "UTF-8");
        String[] words = content.split(" ");
        List<String> list = new ArrayList<>();

        System.out.println("Enter 'asc' for ascending and 'desc' for descending order: ");
        String sortBy = new Scanner(System.in).nextLine().toLowerCase();

        System.out.println("Enter minimum word length: ");
        int min = new Scanner(System.in).nextInt();
        System.out.println("Enter maximum word length: ");
        int max = new Scanner(System.in).nextInt();

        Stream<String> stream = list.stream();

        list = Arrays.stream(words)
                .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase())
                .filter(word ->
                {
                    return (min == 0 ? word.length() <= max : word.length() >= min);
                })
                .filter(word ->
                {
                    return (max == 0 ? word.length() >= min : word.length() <= max);
                })
                .collect(Collectors.toList());

        if (sortBy.equals("asc")) {
            list = list.stream()
                    .distinct()
                    .sorted(((o1, o2) -> Integer.compare(o1.length(), o2.length())))
                    .collect(Collectors.toList());
        } else if (sortBy.equals("desc")) {
            list = list.stream()
                    .distinct()
                    .sorted(((o1, o2) -> -Integer.compare(o1.length(), o2.length())))
                    .collect(Collectors.toList());
        } else {
            System.out.println("Invalid input");
            return;
        }
        list.stream().distinct().forEach(System.out::println);
    }
}
