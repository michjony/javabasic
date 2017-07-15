package com.michjony.basic.util.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class Client {
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("client");
		EventLoopGroup group = new NioEventLoopGroup();
		Bootstrap b = new Bootstrap();
		b.group(group)
		//指定使用NioSocketChannel通道
		.channel(NioSocketChannel.class)
		//一定要使用handler绑定具体的事件处理器
		.handler(new ChannelInitializer<SocketChannel>(){
			@Override
			protected void initChannel(SocketChannel ch) throws Exception {
				//将服务端的处理器添加进来 
				//此处理器是实际业务处理逻辑
				ch.pipeline().addLast(new ClientHandler());
			}
		});
		
		ChannelFuture future = b.connect("127.0.0.1",8888).sync();
		//写入ByteBuf
		future.channel().write(Unpooled.copiedBuffer("hello".getBytes()));
		//刷新
		future.channel().flush();
		
		future.channel().closeFuture().sync();
		group.shutdownGracefully();
		
	}
}
