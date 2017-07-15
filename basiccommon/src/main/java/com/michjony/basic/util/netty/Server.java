package com.michjony.basic.util.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class Server {

	private static int PORT = 8888;
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("server");
		//处理IO操作的多线程事件循环器，用于接收Client端的连接
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		//处理业务的事件处理器 
		EventLoopGroup workGroup = new NioEventLoopGroup();
		//创建一个辅助类，对Server端进行一些配置
		ServerBootstrap b = new ServerBootstrap();
		//绑定两个处理器
		b.group(bossGroup, workGroup)
		//指定使用NioServerSocketChannel通道
		.channel(NioServerSocketChannel.class)
		//一定要使用childHandler绑定具体的事件处理器
		.childHandler(new ChannelInitializer<SocketChannel>(){
			@Override
			protected void initChannel(SocketChannel ch) throws Exception {
				//将服务端的处理器添加进来 
				//此处理器是实际业务处理逻辑
				ch.pipeline().addLast(new DiscardSeverHanlder());
			}
		})
		//服务器端TCP内核模块维护2个队列，称为A B
		//client(connect:syn) -> server  
		//server(syn:ack) -> client
		//server将客户端连接加入到A队列中，然后 client(ack:ack) -> server
		//TCP内核把客户端连接从A队列移动到B队列中，连接完成，应用程序的accept就会返回
		//a+b的长度之和称为backlog ，当大于设定的128时就会拒绝此请求
		//设置TCP缓存区
		.option(ChannelOption.SO_BACKLOG, 128)
		//保持连接
		.option(ChannelOption.SO_KEEPALIVE, true);
		
		ChannelFuture future = b.bind(PORT).sync();
		future.channel().closeFuture().sync();
		bossGroup.shutdownGracefully();
		workGroup.shutdownGracefully();
	}
}
