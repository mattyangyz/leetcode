package Concurrent;

public class BuildingH2O {

    private Object lock = new Object();
    private int count = 0;

    public BuildingH2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        synchronized (lock) {

            while (count == 2) {
                lock.wait();
            }
            releaseHydrogen.run();
            count++;
            lock.notifyAll();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        synchronized (lock) {
            while (count == 0) {
                lock.wait();
            }
            releaseOxygen.run();
            count = 0;
            lock.notifyAll();
        }
    }

}
