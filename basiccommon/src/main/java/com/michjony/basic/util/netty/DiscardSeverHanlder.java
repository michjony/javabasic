package com.michjony.basic.util.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;

/**
 * 继承 ChannelHandlerAdapter类 ,此类实现了ChannelHandler接口
 * 参考 http://ifeve.com/netty5-user-guide/
 * @ClassName: DiscardSeverHanlder
 * @author Michael-jony
 * @date 2017年7月15日 上午10:02:34
 */
public class DiscardSeverHanlder extends ChannelHandlerAdapter {

	/**
	 * Object 一定是netty中的ByteBuf类型
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		//((ByteBuf) msg).release();
		try {
			//do something
			ByteBuf buf =  (ByteBuf) msg;
			byte[] bytes = new byte[buf.readableBytes()];
			buf.readBytes(bytes);
			System.out.println("Server : " + new String(bytes,"utf-8"));
		} finally {
			//release
			ReferenceCountUtil.release(msg);
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

}
