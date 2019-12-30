public class Main {

    public static void main(String[] args) {
        WorkerThread workerThread1 = new WorkerThread();
        workerThread1.setName("worker-1");
        WorkerThread workerThread2 = new WorkerThread();
        workerThread2.setName("worker-2");
        workerThread1.start();
        workerThread2.start();
    }
}