public static void printCurrentThreadInfo() {
    Thread current = Thread.currentThread();
    System.out.println("name: " + current.getName());
    System.out.println("priority: " + current.getPriority());
}