public class StringFilter {
    public static String filterLetters(String input) {
        return input.replaceAll("[^a-zA-Z]+", "");
    }
}

