package netty.nio;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyServer {
    public static void main(String[] args) {

        //boss 充当接收新链接，并注册到内部selector的角色
        //worker boss接收到新链接后，会将链接注册到worker selector上，worker轮询查看哪些链接可读
        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();

        //Netty Server端启动的引导类
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap
                //绑定两个selector
                .group(boss, worker)
                //选择NIO模式，如果选择BIO模式，则是OioServerSocketChannel.class
                //NioServerSocketChannel类比于ServerSocket
                .channel(NioServerSocketChannel.class)
                //链接可读后，继续执行的业务逻辑
                //NioSocketChannel类比于Socket
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    protected void initChannel(NioSocketChannel ch) {
                        ch.pipeline().addLast(new FirstServerHandler());
                    }
                })
                .bind(8000);
        /**
         * Netty Server启动三个步骤
         * 1.创建引导类
         * 2.绑定线程模型
         * 3.指定IO模式
         * 4.绑定后续读写业务逻辑
         */
    }
}