package ch.hslu.ad.sw01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AhaBeispiel {

    public static void main(String[] args){
        task(1000);
        logger.info("task1 calls:" + task1calls);
        logger.info("task2 calls:" + task2calls);
        logger.info("task3 calls:" + task3calls);
    }

    private final static Logger logger = LogManager.getLogger(AhaBeispiel.class);
    private static int task1calls = 0;
    private static int task2calls = 0;
    private static int task3calls = 0;

    public static void task(final int n) {
        task1();
        task1();
        task1();
        task1();
        for (int i = 0; i < n; i++) {
            task2();
            task2();
            task2();
            for (int j = 0; j < n; j++) {
                task3();
                task3();
            }
        }
    }

    public static void task1() {
        try{
            Thread.sleep(5);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        task1calls++;
    }

    public static void task2() {
        try{
            Thread.sleep(5);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        task2calls++;
    }

    public static void task3() {
        try{
            Thread.sleep(5);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        task3calls++;
    }
}
