import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the title of the book. \n For example: Animal Farm a Fairy Story.txt : ");
        String userInput = scanner.nextLine();
        String bookName = StringFilter.filterLetters(userInput);

        StatisticsProvider bookStatisticsProvider =
                BookStatisticsFactory.createProvider();

        try {
            Map<String, Integer> wordCountMap =
                    bookStatisticsProvider.getStatistics(bookName);

            Printer statisticsPrinter = new Printer();
            statisticsPrinter.printStatistics(wordCountMap);

        } catch (Exception e) {
            switch (e.getClass().getSimpleName()) {
                case "BookNotFoundException":
                    System.err.println(e.getMessage());
                    break;
                case "IOException":
                    e.printStackTrace();
                    break;
                default:
                    e.printStackTrace();
                    break;
            }
        }
    }
}
