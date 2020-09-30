import org.apache.commons.io.FileUtils;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class WordSorterFilterApplication {

    public static List<String> processFile() throws IOException {

        File file = new File("file.txt");
        String content = FileUtils.readFileToString(file, "UTF-8");
        String[] words = content.split(" ");
        List<String> list = new ArrayList<>();

        return list = Arrays.stream(words)
                .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase())
                .collect(Collectors.toList());
    }

    public static List<String> filterWords(List<String> list, Integer min, Integer max) throws InvalidInputException {

        if (min > max && max != 0) throw new InvalidInputException("Invalid input.");

        List<String> filteredList = list.stream()
                .filter(word ->
                {
                    return (min == 0 ? true : word.length() >= min);
                })
                .filter(word ->
                {
                    return (max == 0 ? true : word.length() <= max);
                })
                .collect(Collectors.toList());

        return filteredList.stream().collect(Collectors.toList());

    }

    public static List<String> uniqueWords(List<String> list) {

        return list.stream().distinct().collect(Collectors.toList());
    }

    public static List<String> sortList(List<String> list, String sortBy) throws InvalidInputException {

        List<String> sortedList = new ArrayList<>();

        if (sortBy.equals("asc")) {
            sortedList = list.stream()
                    .sorted((Comparator.comparingInt(String::length)))
                    .collect(Collectors.toList());
        } else if (sortBy.equals("desc")) {
            sortedList = list.stream()
                    .sorted(((o1, o2) -> -(Integer.compare(o1.length(), o2.length()))))
                    .collect(Collectors.toList());

        } else throw new InvalidInputException("Invalid input.");

        return sortedList.stream().collect(Collectors.toList());
    }

    public static void main(String[] args) throws IOException, InvalidInputException {

        System.out.println("Enter 'asc' for ascending and 'desc' for descending order:");
        String sortBy = new Scanner(System.in).nextLine().toLowerCase();

        System.out.println("Enter minimum word length: ");
        int min = new Scanner(System.in).nextInt();
        System.out.println("Enter maximum word length: ");
        int max = new Scanner(System.in).nextInt();

        List<String> list = processFile();
        List<String> filtered = filterWords(list, min, max);
        List<String> sorted = sortList(filtered, sortBy);
        List<String> uniqueWords = uniqueWords(sorted);
        uniqueWords.stream().forEach(System.out::println);
    }
}
