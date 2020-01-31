import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String part = scanner.nextLine();
        int count = 0;
        int index = -1;
        while ((index = line.indexOf(part, index + 1)) >= 0) {
            ++count;
        }
        System.out.println(count);
    }
}