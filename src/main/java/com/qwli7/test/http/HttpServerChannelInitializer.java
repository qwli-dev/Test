package com.qwli7.test.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

import javax.swing.*;

public class HttpServerChannelInitializer extends ChannelInitializer<SocketChannel> {

    private final JTextArea jTextArea;

    public HttpServerChannelInitializer(JTextArea jTextArea) {
        this.jTextArea = jTextArea;
    }

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        final ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast(new HttpServerCodec());
        pipeline.addLast(new HttpServerHandler(jTextArea));
    }
}
