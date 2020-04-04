package ch.hslu.ad.sw07.joinandwait;

public class DemoJoinAndWait {
    private DemoJoinAndWait() {
    }

    public static void main(String[] args){
        Thread thread3 = new JoinAndWait("Thread 3", 4000, null);
        Thread thread2 = new JoinAndWait("Thread 2", 3000, thread3);
        Thread thread1 = new JoinAndWait("Thread 1", 2000, thread2);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
