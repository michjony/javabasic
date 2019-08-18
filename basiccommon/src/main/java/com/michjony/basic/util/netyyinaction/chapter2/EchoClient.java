package com.michjony.basic.util.netyyinaction.chapter2;

import java.util.logging.Logger;

/**
 * Echo 客户端
 * 1.连接到服务器
 * 2.发送一个或者多个消息
 * 3.对于每个消息，等待并接收从服务器发回的相同的消息
 * 4.关闭连接
 * user:Cherie
 * datetime;2019/8/17 14:40
 */
public class EchoClient {

    private static  final  Logger logger = Logger.getLogger("EchoClient");
    private final String host;
    private final int port;

    public EchoClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public static void main(String[] args) {
        if (args.length!=2){
            logger.warning("Usage: " + EchoClient.class.getSimpleName() +"<host> <port>");
        return ;
        }

        String host = args[0];
        int port = Integer.parseInt(args[1]);
        new EchoClient(host,port).start();
    }

    private void start() {
    }
}


