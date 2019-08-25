package com.michjony.basic.util.nio.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * user:Cherie
 * datetime;2019/8/25 18:20
 */
public class NIOClient {

    private final InetSocketAddress serverAddress = new InetSocketAddress("localhost", 8888);

    private static String USER_CONTENT_SPILIT = "#@#";

    Selector selector = null;

    SocketChannel client = null;

    private String nickName = "";

    private Charset charset = Charset.forName("UTF-8");

    private static final String USER_EXIST = "用户已存在";


    public NIOClient() throws IOException {
        client = SocketChannel.open(serverAddress);
        client.configureBlocking(false);
        // 开门接客
        selector = Selector.open();
        client.register(selector, SelectionKey.OP_READ);

    }

    public static void main(String[] args) throws IOException {
        NIOClient nioClient = new NIOClient();
        nioClient.session();
    }

    public void session() {
        // 开启一个线程从服务器读取数据
        new Reader().start();
        // 开启一个线程往服务器写数据
        new Writer().start();
    }

    private class Writer extends Thread {

        @Override
        public void run() {
            try {
                Scanner scanner = new Scanner(System.in);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if ("".equals(line)) {
                        continue;
                    }
                    if ("".equals(nickName)) {
                        nickName = line;
                        line = nickName + USER_CONTENT_SPILIT;
                    } else {
                        line = nickName + USER_CONTENT_SPILIT + line;
                    }
                    client.write(charset.encode(line));
                }
                scanner.close();
            } catch (Exception e) {
                System.out.println("e:" + e.getMessage());
            }
        }
    }

    private class Reader extends Thread {

        @Override
        public void run() {
            try {
                // 轮询
                while (true) {
                    int readyChannels = selector.select();
                    if (readyChannels == 0) {
                        continue;
                    }
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        iterator.remove();
                        process(key);
                    }
                }
            } catch (IOException e) {
                System.err.println("e:" + e.getMessage());
            }
        }
    }

    private void process(SelectionKey key) throws IOException {
        // 使用nio读取channel中的数据
        if (key.isReadable()) {
            SocketChannel sc = (SocketChannel) key.channel();
            ByteBuffer buff = ByteBuffer.allocate(1024);
            String content = "";

            while (sc.read(buff) > 0) {
                buff.flip();
                content += charset.decode(buff);
            }
            if (USER_EXIST.equals(content)) {
                nickName = "";
            }
            System.out.println(content);
            key.interestOps(SelectionKey.OP_READ);
        }
    }
}
