package ru.innopolis.stc13._8_sockets.homeWork.main;

import java.io.BufferedReader;
import java.io.IOException;

public class Resender extends Thread {
    private boolean stoped = false;
    private BufferedReader in=null;

    public Resender(BufferedReader in) {
        this.in = in;
    }

    public void setStop(){
        stoped = true;
    }

    @Override
    public void run() {
        try {
            while (!stoped) {
                String str = in.readLine();
                System.out.println(str);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при получении сообщения.");
            e.printStackTrace();
        }
    }
}
