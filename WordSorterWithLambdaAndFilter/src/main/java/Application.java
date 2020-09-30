import org.apache.commons.io.FileUtils;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) throws IOException, InvalidInputException {

        File file = new File("file.txt");
        String content = FileUtils.readFileToString(file, "UTF-8");
        String[] words = content.split(" ");
        List<String> list = new ArrayList<>();

        System.out.println("Enter 'asc' for ascending and 'desc' for descending order:");
        String sortBy = new Scanner(System.in).nextLine().toLowerCase();

        System.out.println("Enter minimum word length: ");
        int min = new Scanner(System.in).nextInt();
        System.out.println("Enter maximum word length: ");
        int max = new Scanner(System.in).nextInt();

        if(min > max & max != 0) throw new InvalidInputException();

            list = Arrays.stream(words)
                .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase())
                .filter(word ->
                {
                    return (min == 0 ? true : word.length() >= min);
                })
                .filter(word ->
                {
                    return (max == 0 ? true : word.length() <= max);
                })
                .collect(Collectors.toList());

        if (sortBy.equals("asc")) {
            list = list.stream()
                    .sorted(((o1, o2) -> Integer.compare(o1.length(), o2.length())))
                    .collect(Collectors.toList());
        } else if (sortBy.equals("desc")) {
            list = list.stream()
                    .sorted(((o1, o2) -> -Integer.compare(o1.length(), o2.length())))
                    .collect(Collectors.toList());
        } else {
            System.out.println("Invalid input.");
            return;
        }

        list.stream().distinct().forEach(System.out::println);
    }
}
