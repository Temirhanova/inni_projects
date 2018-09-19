package ru.innopolis.stc13._8_sockets.homeWork.client;

import ru.innopolis.stc13._8_sockets.homeWork.main.Const;
import ru.innopolis.stc13._8_sockets.homeWork.main.Resender;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
/*    String ip;

    public Client(String ip) {
        this.ip = ip;
    }*/
    public Client () {
        Scanner scan = new Scanner(System.in);
        try (Socket socket = new Socket(Const.ip, Const.port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true)){
            System.out.println("Введите свой ник:");
            out.println(scan.nextLine());
            String str = "";
            while (!str.equals("exit")){
                str = scan.nextLine();
                out.println(str);
            }
            Resender resender = new Resender(in);
            resender.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
