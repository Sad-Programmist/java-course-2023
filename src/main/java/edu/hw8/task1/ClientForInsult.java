package edu.hw8.task1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientForInsult {

    private ClientForInsult() {

    }

    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 8080;
    private static final int BUFFER_SIZE = 1024;

    @SuppressWarnings("UncommentedMain")
    public static void main(String[] args) {
        runClient();
    }

    @SuppressWarnings("RegexpSinglelineJava")
    private static void runClient() {
        try (Socket socket = new Socket(SERVER_HOST, SERVER_PORT)) {
            System.out.println("Подключено к серверу. Можете начинать общение.");

            Scanner scanner = new Scanner(System.in);
            try (
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream()
            ) {
                while (true) {
                    System.out.print("Введите ключевое слово: ");
                    String message = scanner.nextLine();
                    outputStream.write(message.getBytes());

                    byte[] buffer = new byte[BUFFER_SIZE];
                    int bytesRead = inputStream.read(buffer);
                    if (bytesRead != -1) {
                        String serverResponse = new String(buffer, 0, bytesRead);
                        System.out.println(serverResponse);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
