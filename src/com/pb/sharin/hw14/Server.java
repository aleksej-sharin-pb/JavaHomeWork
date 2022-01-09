package com.pb.sharin.hw14;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    static class Handler implements Runnable {
        private final Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + ": Получен запрос от клиента");
                //==============================================================================================
                BufferedReader in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter    out = new PrintWriter(socket.getOutputStream(), true);
                                      // BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                String clientMessage;
                //==============================================================================================
                // цикл ожидания сообщений от клиента, при close - отключение клиента
                //==============================================================================================
                System.out.println("Ожидаем сообщений");
                while ((clientMessage = in.readLine()) != null) {
                    if ("close".equalsIgnoreCase(clientMessage)) {
                        break;
                    }
                    out.println("Сервер: "+ (LocalDateTime.now().toString()) + " " + clientMessage);
                    System.out.println(Thread.currentThread().getName() + " -> " + clientMessage);
                }
               //==============================================================================================
                System.out.println("Закрываем соединение с клиентом в потоке " + Thread.currentThread().getName());
                out.close();
                in.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (Exception ex) {
                    // ignore
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        //==============================================================================================
        System.out.println("hw14 \"Client/Server\"");
        int port = 1234;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Сервер запущен на порту : " + port);
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        //==============================================================================================
        // В цикле ждем запроса клиента
        while (true) {
            Socket clientSocket = serverSocket.accept();
            threadPool.submit(new Handler(clientSocket));
        }
    }
}