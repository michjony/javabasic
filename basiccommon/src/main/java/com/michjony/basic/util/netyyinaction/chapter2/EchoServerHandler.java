package com.michjony.basic.util.netyyinaction.chapter2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.util.logging.Logger;

/**
 * echo服务器
 * 响应传入的消息，实现ChannelInboundHandler接口
 * 用来定义响应入站事件的方法
 * user:Cherie
 * datetime;2019/8/17 13:51
 */
@ChannelHandler.Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter {


    private static final Logger logger = Logger.getLogger("EchoServerHandler");

    // 读入入站消息
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in = (ByteBuf) msg;

        logger.info("server received : " + in.toString(CharsetUtil.UTF_8));
        // 将消息发送给客户端
        ctx.write(in);
    }

    /**
     * 通知ChannleInboundHandler最后一次对channelRead()的调用是，当前批量读取中的最后一条消息
     * @param ctx
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx){
        // 将消息刷新到客户端，同时关闭channel
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){
        logger.warning(cause.getMessage());
        ctx.close();
    }
}

