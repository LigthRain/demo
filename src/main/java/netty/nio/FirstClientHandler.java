package netty.nio;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;


public class FirstClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf buffer = getButeBuf(ctx);
        ctx.channel().writeAndFlush(buffer);
    }

    private ByteBuf getButeBuf(ChannelHandlerContext ctx) {
        ByteBuf buffer = ctx.alloc().buffer();
        byte[] bytes = "保持好奇心".getBytes(StandardCharsets.UTF_8);
        buffer.writeBytes(bytes);
        return buffer;
    }


    public static void main(String[] args) {
        int a1 = 1;
        int a2 = 2;
        int a3 = 3;
        int a4 = 3;
        int a5 = 1;
        int a6 = 1;
    }

}
