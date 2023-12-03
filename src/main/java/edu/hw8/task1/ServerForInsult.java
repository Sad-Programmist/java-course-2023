package edu.hw8.task1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerForInsult {

    private ServerForInsult() {

    }

    private static final int PORT = 8080;
    private static final int MAX_CONNECTIONS = 5;
    private static final int BUFFER_SIZE = 1024;

    private static final String[] INSULTS = {
        "Не переходи на личности там, где их нет",
        "Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами",
        "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма.",
        "Чем ниже интеллект, тем громче оскорбления"
    };

    @SuppressWarnings("UncommentedMain")
    public static void main(String[] args) {
        runServer();
    }

    @SuppressWarnings("RegexpSinglelineJava")
    private static void runServer() {
        try (ExecutorService executorService = Executors.newFixedThreadPool(MAX_CONNECTIONS)) {

            try (ServerSocket serverSocket = new ServerSocket(PORT)) {
                System.out.println("Сервер запущен. Ожидание подключений...");

                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    executorService.submit(() -> handleClient(clientSocket));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings("RegexpSinglelineJava")
    private static void handleClient(Socket clientSocket) {
        try (
            InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream()
        ) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                String clientMessage = new String(buffer, 0, bytesRead);
                System.out.println("Ваня: " + clientMessage);

                String serverResponse = getInsultResponse(clientMessage);
                outputStream.write(serverResponse.getBytes());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getInsultResponse(String clientMessage) {
        for (String insult : INSULTS) {
            if (insult.toLowerCase().contains(clientMessage.toLowerCase())) {
                return "Сервер: " + insult;
            }
        }
        return "Сервер: Я не знаю, как на это реагировать.";
    }
}
