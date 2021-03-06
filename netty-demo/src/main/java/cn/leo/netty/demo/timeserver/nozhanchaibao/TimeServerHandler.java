package cn.leo.netty.demo.timeserver.nozhanchaibao;

import java.util.Date;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class TimeServerHandler extends ChannelHandlerAdapter {
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		// ByteBuf buf = (ByteBuf) msg;
		// byte[] req = new byte[buf.readableBytes()];
		// buf.readBytes(req);
		// System.out.println(new String(req, "UTF-8") + "\n");

		System.out.println((String) msg);

		String str = new Date().toString() + System.getProperty("line.separator");
		ByteBuf resp = Unpooled.copiedBuffer(str.getBytes());
		ctx.writeAndFlush(resp);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		ctx.close();
	}
}
