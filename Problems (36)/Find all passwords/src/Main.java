import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile("password[\\s:]*\\w+", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        if (!matcher.find()) {
            System.out.println("No passwords found.");
            return;
        }
        do {
            System.out.println(extractPassword(matcher.group()));
        } while (matcher.find());
    }

    private static String extractPassword(String text) {
        Matcher matcher = Pattern.compile("password[\\s:]*", Pattern.CASE_INSENSITIVE).matcher(text);
        if (matcher.find()) {
            return text.substring(matcher.end());
        }
        throw new IllegalArgumentException();
    }
}