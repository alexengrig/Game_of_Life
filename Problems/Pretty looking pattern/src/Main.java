import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] chars = new char[4][];
        for (int i = 0; i < 4; i++) {
            String line = scanner.nextLine();
            chars[i] = line.toCharArray();
        }
        boolean pretty = true;
        for (int i = 0; pretty && i < chars.length - 1; i++) {
            for (int j = 0; j < chars[i].length - 1; j++) {
                char ch = chars[i][j];
                if (ch == chars[i + 1][j] &&
                        ch == chars[i][j + 1] &&
                        ch == chars[i + 1][j + 1]) {
                    pretty = false;
                    break;
                }
            }
        }
        System.out.println(pretty ? "YES" : "NO");
    }
}