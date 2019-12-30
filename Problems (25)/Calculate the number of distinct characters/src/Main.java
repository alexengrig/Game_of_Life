public static void main(String[] args) throws InterruptedException {
    final Scanner scanner = new Scanner(System.in);

    final String str = scanner.nextLine();

    final SlowStringProcessor processor = new SlowStringProcessor(str);
    processor.start();
    processor.join();
    System.out.println(processor.getNumberOfUniqueCharacters());
}