package fedorova_socket_lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Fedorova_Socket_Lab1 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            System.out.println("Сервер запущен и ожидает подключений...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Подключение от клиента " + clientSocket.getInetAddress().getHostAddress());

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(), StandardCharsets.UTF_8));
                String data = in.readLine();

                String[] values = data.split(",");
                if (values.length == 6) {
                    String a = values[0];
                    String b = values[1];
                    String c = values[2];
                    String d = values[3];
                    String x = values[4];
                    String y = values[5];

                    System.out.println("Получены данные: a = " + a + ", b = " + b + ", c = " + c + ", d = " + d + ", x = " + x + ", y = " + y);
                } else {
                    System.out.println("Ошибка: неверный формат данных");
                }

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
