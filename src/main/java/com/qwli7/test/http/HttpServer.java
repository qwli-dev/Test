package com.qwli7.test.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import javax.swing.*;

public class HttpServer implements IServer {

    private final int port;

    private final JTextArea jTextArea;
    private final EventLoopGroup bossGroup;
    private final EventLoopGroup workerGroup;
    private static Channel channel;

    public HttpServer(int port, JTextArea jTextArea) {
        this.port = port;
        this.jTextArea = jTextArea;
        this.bossGroup = new NioEventLoopGroup();
        this.workerGroup = new NioEventLoopGroup();
    }



    @Override
    public void start() throws Exception {

        try{

            ServerBootstrap bootstrap = new ServerBootstrap().group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childHandler(new HttpServerChannelInitializer(jTextArea));

            final ChannelFuture channelFuture = bootstrap.bind(port).sync();
            channel = channelFuture.channel();
            channel.closeFuture().sync();

        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    @Override
    public void shutDown() throws Exception {
        if(channel != null) {
            channel.close();
            channel = null;
            System.out.println("服务已经关闭.....");
        }

    }
}
