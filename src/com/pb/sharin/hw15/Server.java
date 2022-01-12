package com.pb.sharin.hw15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Server {
    public static void main(String[] args) throws Exception {
        int port = 1234;
        ServerSocket serverSocket = new ServerSocket(port);

        ExecutorService pool = Executors.newFixedThreadPool(10);

        List<ClientHandler> handlers = Collections.synchronizedList(new ArrayList<>());

        System.out.println("Сервер запустился на порту " + port);

        //===============================================================================================
        // Мониторим подключение новых пользователей чата
        //===============================================================================================
        while (true) {
            Socket socket = serverSocket.accept();
            ClientHandler handler = new ClientHandler(socket, handlers);
            handlers.add(handler);
            System.out.println("Клиент " + handler.getCurrentIndex() + " подключился");
            pool.submit(handler);
        }
    }

    static class ClientHandler implements Runnable {

        private static final AtomicInteger INDEX = new AtomicInteger(0);

        private final Socket socket;
        private final BufferedReader reader;
        private final PrintWriter writer;
        private final List<ClientHandler> clientHandlers;
        private final int currentIndex;

        public int getCurrentIndex() {
            return currentIndex;
        }

        public ClientHandler(Socket socket, List<ClientHandler> clientHandlers) {
            this.currentIndex = INDEX.incrementAndGet();
            this.socket = socket;
            this.clientHandlers = clientHandlers;
            try {
                this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                this.writer = new PrintWriter(socket.getOutputStream(), true);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }

        //сообщения на сервере о подключении/отключении пользователей,
        //вызов метода по отправки сообщений пользователям чата
        @Override
        public void run() {
            try {
                for (ClientHandler handler : clientHandlers) {
                    handler.sendMessage("Новое подключение.", currentIndex);
                }
                String message;

                while ((message = reader.readLine()) != null) {
                    for (ClientHandler handler : clientHandlers) {
                        handler.sendMessage(message, currentIndex);
                    }
                }
            } catch (Exception ex) {
                //если отключение прошло с ошибкой
                for (ClientHandler handler : clientHandlers) {
                    handler.sendMessage("(Клиент " + currentIndex + ") Собеседник вышел из чата.", currentIndex);
                }
                clientHandlers.remove(this);
                System.out.println("Клиент " + currentIndex + " отключился");
                try {
                    socket.close(); //закрываем подключение
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //метод для отправки сообщений клиентам
        public void sendMessage(String message, int clientIndex) {
            try {
                //шаблон для отправки времени сообщения
                SimpleDateFormat formatDate = new SimpleDateFormat("hh:mm:s"); //dd-MM-yy hh:mm:s

                //доп проверка, если Клиент не изменил имя по дефолту - сообщение отправляем под номером клиента
                //если пользователь указал логин - в сообщении будет его логин
                if (message.matches("Клиент(.*)")) {
                    writer.println(formatDate.format(new Date()) + "(Клиент " + clientIndex + ") " + message);
                } else writer.println(formatDate.format(new Date()) + " " + message);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}