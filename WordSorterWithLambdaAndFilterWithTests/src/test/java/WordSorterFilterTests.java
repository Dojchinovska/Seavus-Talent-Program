import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


class WordSorterFilterTests {

    private WordSorterFilterApplication wordSorterFilterApplication;
    List<String> testData = Arrays.asList("sodales", "purus", "purus", "tellus", "lorem", "lorem", "ipsum", "dolor", "et", "consectetur", "adipiscing", "elit");

    @BeforeEach
    void setUp() {
        wordSorterFilterApplication = new WordSorterFilterApplication();
    }

    @Test
    void fileExists() throws IOException {
        File file = new File("file.txt");
        Assertions.assertTrue(file.exists());
    }

    @Test
    void fileIsProcessed() throws IOException {
        List<String> list = wordSorterFilterApplication.processFile();
        Assertions.assertTrue(!list.isEmpty());
    }

    @Test
    void sortByAscTest() throws InvalidInputException {
        List<String> sortedByAsc = wordSorterFilterApplication.sortList(testData, "asc");
        Assertions.assertEquals(Arrays.asList("et", "elit", "purus", "purus", "lorem", "lorem", "ipsum", "dolor", "tellus", "sodales", "adipiscing", "consectetur"), sortedByAsc);
    }

    @Test
    void sortByDescTest() throws InvalidInputException {
        List<String> sortedByDesc = wordSorterFilterApplication.sortList(testData, "desc");
        Assertions.assertEquals(Arrays.asList("consectetur", "adipiscing", "sodales", "tellus", "purus", "purus", "lorem", "lorem", "ipsum", "dolor", "elit", "et"), sortedByDesc);
    }

    @Test
    void areUniqueTest() {
        List<String> uniqueWords = wordSorterFilterApplication.uniqueWords(testData);
        Assertions.assertEquals(Arrays.asList("sodales", "purus", "tellus", "lorem", "ipsum", "dolor", "et", "consectetur", "adipiscing", "elit"), uniqueWords);
    }

    @Test
    void filterMinMax() throws InvalidInputException {
        List<String> minMax = wordSorterFilterApplication.filterWords(testData, 2, 5);
        Assertions.assertEquals(Arrays.asList("purus", "purus", "lorem", "lorem", "ipsum", "dolor", "et", "elit"), minMax);

    }

    @Test
    void filterZeroMin() throws InvalidInputException {
        List<String> minMax = wordSorterFilterApplication.filterWords(testData, 0, 4);
        Assertions.assertEquals(Arrays.asList("et", "elit"), minMax);
    }

    @Test
    void filterZeroMax() throws InvalidInputException {
        List<String> minMax = wordSorterFilterApplication.filterWords(testData, 5, 0);
        Assertions.assertEquals(Arrays.asList("sodales", "purus", "purus", "tellus", "lorem", "lorem", "ipsum", "dolor", "consectetur", "adipiscing"), minMax);
    }

    @Test
    void filterZeroMinZeroMax() throws InvalidInputException {
        List<String> minMax = wordSorterFilterApplication.filterWords(testData, 0, 0);
        Assertions.assertEquals(Arrays.asList("sodales", "purus", "purus", "tellus", "lorem", "lorem", "ipsum", "dolor", "et", "consectetur", "adipiscing", "elit"), minMax);

    }

    @Test
    void sort_invalidInput() {
        Assertions.assertThrows(InvalidInputException.class, () -> wordSorterFilterApplication
                .sortList(testData, "random"), "Invalid input.");
    }

    @Test
    void filter_invalidInput() {
        Assertions.assertThrows(InvalidInputException.class, () -> wordSorterFilterApplication
                .filterWords(testData, 4, 2), "Invalid input.");
    }
}