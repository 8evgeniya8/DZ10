public class BookStatisticsFactory {
    public static StatisticsProvider createProvider() {
        return new BookProcessor();
    }
}
