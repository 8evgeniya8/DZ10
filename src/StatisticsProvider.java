import java.io.IOException;
import java.util.Map;

public interface StatisticsProvider {
    Map<String, Integer> getStatistics(String bookName) throws IOException;
}
