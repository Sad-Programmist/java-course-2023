package edu.hw6.task6;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task6 {

    private static final String FORMAT = "%-10s%-8s%s%n";
    private final static Logger LOGGER = LogManager.getLogger();

    private Task6() {
    }

    public static void scanPorts(int startPort, int endPort) {
        if (startPort < 0 && endPort < 0) {
            return;
        }
        printInfo();

        try (Selector selector = Selector.open()) {
            for (int port = startPort; port <= endPort; port++) {
                try {
                    ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
                    serverSocketChannel.socket().bind(new InetSocketAddress(port));
                    serverSocketChannel.configureBlocking(false);
                    serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
                } catch (IOException e) {
                    printPortInfo("TCP ", port, Service.getServiceByPort(port));
                }

                try {
                    DatagramChannel datagramChannel = DatagramChannel.open();
                    datagramChannel.socket().bind(new InetSocketAddress(port));
                    datagramChannel.configureBlocking(false);
                    datagramChannel.register(selector, SelectionKey.OP_READ);
                } catch (IOException e) {
                    printPortInfo("UDP ", port, Service.getServiceByPort(port));
                }
            }
        } catch (IOException e) {
            LOGGER.error(e);
        }
    }

    @SuppressWarnings("RegexpSinglelineJava")
    public static void printPortInfo(String protocol, int port, String service) {
        System.out.printf(FORMAT, protocol, port, service);
    }

    @SuppressWarnings("RegexpSinglelineJava")
    public static void printInfo() {
        System.out.printf(FORMAT, "Protocol", "Port", "Service");
    }

    public static void runTask6(int startPort, int endPort) {
        scanPorts(startPort, endPort);
    }
}
