import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BookProcessor implements StatisticsProvider {
//    перевірка на присутність файла
    @Override
    public Map<String, Integer> getStatistics(String bookName) throws IOException {
        Path bookPath = Paths.get("src", bookName);
        if (!Files.exists(bookPath)) {
            throw new IOException("Book not found: " + bookName);
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(bookPath.toString()))) {
            return countWords(bufferedReader);
        }
    }

    // Рахувати слова
    public Map<String, Integer> countWords(BufferedReader reader) throws IOException {
        Map<String, Integer> wordCountMap = new HashMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(new BufferedReader(reader))) {
//             роботи з регулярними виразами можлива з використанням патернів
//            здається через патерн splitAsStream було б краще
            bufferedReader.lines()
                    .flatMap(line -> Arrays.stream(line.split("[^a-zA-Z]+")))
                    .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase())
                    .filter(word -> word.length() > 2)
                    .forEach(word -> wordCountMap.merge(word, 1, Integer::sum));
        }
        return wordCountMap;
    }
}

