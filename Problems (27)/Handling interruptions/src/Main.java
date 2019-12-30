class CounterThread extends Thread {

    @Override
    public void run() {
        long counter = 0;

        while (true) {
            counter++;
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                System.out.println("It was interrupted");
                break;
            }
            if (isInterrupted()) {
                System.out.println("It was interrupted");
                break;
            }
        }
    }
}