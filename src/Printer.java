import java.util.Map;

public class Printer {
//    5. Також вивести статистику в консоль.
//    2. Якщо книга є, то потрібно порахувати 10 найбільш популярних слів
    public void printStatistics(Map<String, Integer> wordCount) {
        System.out.println("10 popular words:");
        wordCount.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(10)
                .forEach(entry -> System.out.println(entry.getKey() + " = " + entry.getValue()));
        System.out.println("Sum of unique words: " + wordCount.size());
    }
}

