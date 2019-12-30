public static void startRunnables(Runnable[] runnables) {
    for(int i = 0; i < runnables.length; i++) {
        new Thread(runnables[i]).start();
    }
}