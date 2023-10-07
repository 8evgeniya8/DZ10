import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class Writer {
    // Записати статистику, яку ви вище отримали, в файл (слово -> кількість разів),
    // в кінці - загальна кількість слів (назва файлу типу {bookName}_statistic.txt).
    public void writeStatistics(String bookName, Map<String, Integer> wordCountMap) throws IOException {
        try (FileWriter fileWriter = new FileWriter
                ("src/" + bookName.replace(".", "_") + "_statistics.txt");
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
//              якщо вибирати між конкатенацією рядків та String.format
            for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
                String line = String.format("%s -> %d", entry.getKey(), entry.getValue());
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }

            String formatted = String.format("Total unique words: %d", wordCountMap.size());
            bufferedWriter.write(formatted);
        }
        System.out.println("Statistics saved : " + bookName.replace(".", "_") + " _statistics.txt");
    }
}