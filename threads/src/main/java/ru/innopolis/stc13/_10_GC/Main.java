package ru.innopolis.stc13._10_GC;

import ru.innopolis.stc13.threads.threadPoll.FindWordTask;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    public static void main(String[] args) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Queue<String> queue = new ConcurrentLinkedQueue<>();
        int flag = 0;
        for (int i = 0; i < 100_0000000; i++) {
            flag++;
            int finalFlag = flag;
            new Thread() {
                @Override
                public void run() {
                    try {
                        queue.add(generateSentense(10000));
                        if ((finalFlag % 7) == 0) {
                            String delete = queue.poll();
                            if (queue == null) {
                                new RuntimeException("Очередь пуста!!!");
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }

    public static String generateSentense(int size) {
        Random random = new Random();
        String result = "";
        String litters = "abcdefghijklmnopqrstuvwxyz";
        for (int i=0; i<size; i++) {
            result += litters.charAt(random.nextInt(litters.length()));
        }
        return result;
    }
}
