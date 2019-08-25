package com.michjony.basic.util.nio.server;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.*;


/**
 * * 网络多客户端聊天室
 * * 功能1： 客户端通过Java NIO连接到服务端，支持多客户端的连接
 * * 功能2：客户端初次连接时，服务端提示输入昵称，如果昵称已经有人使用，提示重新输入，如果昵称唯一，则登录成功，之后发送消息都需要按照规定格式带着昵称发送消息
 * * 功能3：客户端登录后，发送已经设置好的欢迎信息和在线人数给客户端，并且通知其他客户端该客户端上线
 * * 功能4：服务器收到已登录客户端输入内容，转发至其他登录客户端。
 * user:Cherie
 * datetime;2019/8/25 18:20
 */
public class NIOServer {
    private static final String USER_EXIST = "用户已存在";
    // 用来记录在线人数，及昵称
    private HashSet<String> users = new HashSet<>();
    Charset charset = Charset.forName("UTF-8");
    private int port;
    private Selector selector = null;
    private static String USER_CONTENT_SPILIT = "#@#";


    NIOServer(int port) throws IOException {
        this.port = port;

        // 打开通道
        ServerSocketChannel server = ServerSocketChannel.open();

        server.bind(new InetSocketAddress(port));
        server.configureBlocking(false);

        selector = Selector.open();

        server.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务已启动，监听端口是:" + this.port);

    }

    public void listener() throws IOException {
        // 死循环监听
        while (true) {
            // 在轮询，有多少个选择器在排队
            int wait = selector.select();
            if (wait == 0) {
                continue;
            }
            // 取号，默认给他分配个号码（排队号码）
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = keys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                // 处理一个，号码就可以被消除了
                iterator.remove();
                // 处理逻辑
                process(key);
            }
        }
    }

    private void process(SelectionKey key) throws IOException {
        // 判断客户端确定进入，已经连接好了
        if (key.isAcceptable()) {
            ServerSocketChannel server = (ServerSocketChannel) key.channel();
            SocketChannel client = server.accept();
            // 非阻塞模式
            client.configureBlocking(false);
            // 注册选择器，并设置为读取模式，收到一个连接请求，然后起一个SocketChannel
            client.register(selector, SelectionKey.OP_READ);
            // 将此对应的channel设置为准备接受其它客户端请求
            key.interestOps(SelectionKey.OP_ACCEPT);
            client.write(charset.encode(("请输入你的昵称")));
        } else if (key.isConnectable()) {
            ServerSocketChannel server = (ServerSocketChannel) key.channel();
            SocketChannel client = server.accept();
            client.configureBlocking(false);


        } else if (key.isReadable()) {
            // 处理来自客户端的数据读取请求
            // 返回该SelectionKey对应的Channel，其中数据需要读取
            SocketChannel client = (SocketChannel) key.channel();
            ByteBuffer buff = ByteBuffer.allocate(1024);
            StringBuilder content = new StringBuilder();
            try {
                while (client.read(buff) > 0) {
                    buff.flip();
                    content.append(charset.decode(buff));
                }
                key.interestOps(SelectionKey.OP_READ);
            } catch (IOException e) {
                key.cancel();
                if (key.channel() != null) {
                    key.channel().close();
                }
            }
            if (content.length() > 0) {
                String[] arrayContent = content.toString().split(USER_CONTENT_SPILIT);
                // 注册用户
                if (null != arrayContent && arrayContent.length == 1) {
                    String nickName = arrayContent[0];
                    if (users.contains(nickName)) {
                        client.write(charset.encode(USER_EXIST));
                    } else {
                        users.add(nickName);
                        int onlineCount = onlineCount();
                        String message = "欢迎" + nickName + ";在线人数 " + onlineCount;
                        broadCast(null, message);
                    }
                } else if (arrayContent != null && arrayContent.length > 1) {
                    // 注册完了，发送消息
                    String nickName = arrayContent[0];
                    String message = content.substring(nickName.length() + USER_CONTENT_SPILIT.length());
                    message = nickName + " 说 " + message;
                    if (users.contains(nickName)) {
                        // 不回发给发送此内容的客户端
                        broadCast(client, message);
                    }
                }
            }
        }
    }

    private void broadCast(SocketChannel client, String message) throws IOException {
        // 广播到所有的SocketChannel 中
        for (SelectionKey key : selector.keys()) {
            SelectableChannel channel = key.channel();
            if (channel instanceof SocketChannel && client != channel) {
                SocketChannel target = (SocketChannel) channel;
                target.write(charset.encode(message));
            }
        }

    }

    private int onlineCount() {
        int res = 0;
        Set<SelectionKey> keys = selector.keys();
        for (SelectionKey key : keys) {
            SelectableChannel target = key.channel();
            if (target instanceof SocketChannel) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        new NIOServer(8888).listener();
    }
}
