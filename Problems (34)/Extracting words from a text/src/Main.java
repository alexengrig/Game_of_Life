import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern compile = Pattern.compile("\\w*program\\w*", Pattern.CASE_INSENSITIVE);
        Matcher matcher = compile.matcher(text);
        while (matcher.find()) {
            int start = matcher.start();
            String group = matcher.group();
            System.out.println(start + " " + group);
        }
    }
}