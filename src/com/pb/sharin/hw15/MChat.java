package com.pb.sharin.hw15;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;

public class MChat {
    private JButton btnMsgSend;
    private JTextField fieldMsg;
    private JTextField fieldClientName;
    private JPanel MChat;
    private JButton btnClose;
    private JTextArea histMsg;
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public MChat() throws IOException {

        try {
            //параметры для подключения к серверу
            this.socket = new Socket("localhost", 1234);

            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);

            //поток для получения сообщений с сервера
            new Thread(() -> {
                while (true) {
                    try {
                        String fromServer = reader.readLine();
                        //allMsg = allMsg + fromServer;
                        histMsg.append(fromServer);
                        // добавляем строку перехода
                        histMsg.append("\n");

                    } catch (IOException e) {
                        writer.println(fieldClientName.getText() + " вышел из чата!");
                        writer.flush();
                        histMsg.append("Соединение с сервером прервано");
                        histMsg.append("\n");
                        //System.exit(0);
                        break;

                    }
                }
            }).start();

            //Отправка сообщений по нажатию на кнопку "Отправить"
            btnMsgSend.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    //логин и текст сообщения
                    String message = fieldClientName.getText() + ": " + fieldMsg.getText();
                    writer.println(message);
                    writer.flush();
                    fieldMsg.setText("");
                }
            });

            // добавляем обработчик события закрытия окна клиентского приложения
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing(e);
                    try {
                        writer.println(fieldClientName.getText() + " вышел из чата!");

                        writer.flush();
                        writer.close();
                        reader.close();
                        socket.close();
                    } catch (IOException exc) {
                        System.exit(0);
                    }
                }
            });

        } catch (IOException e) {
            //  ex.printStackTrace();
            //если сервер выключен приложение загрузится но в чате будет сообщение
            System.err.println("Ошибка подключения к ЧАТ серверу.");
            histMsg.append("Соединение с сервером НЕ установлено.\nЗакройте приложение.");
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("hw15 \"GUI Java\"");
        //интерфейс и его параметры

        JFrame frame = new JFrame("MChat");
        frame.setContentPane(new MChat().MChat);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setTitle("hw15_CHat");
        frame.setVisible(true);
        frame.setBounds(600, 300, 600, 500);
    }
}
