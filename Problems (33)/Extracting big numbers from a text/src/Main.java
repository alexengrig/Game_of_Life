import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stringWithNumbers = scanner.nextLine();

        Pattern compile = Pattern.compile("\\d{10,}");
        Matcher matcher = compile.matcher(stringWithNumbers);
        while (matcher.find()) {
            String group = matcher.group();
            System.out.println(group + ":" + group.length());
        }
    }
}