package com.slicingflow.zerocopy;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;


public class NioServer {

    /**
     *
     */
    public void start() throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8000));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("server start");
        for (; ; ) {
            int readyChannels = selector.select();
            if (readyChannels == 0) {
                continue;
            }
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                iterator.remove();
                if (selectionKey.isAcceptable()) {
                    acceptHandler(selectionKey, selector);
                }
                if (selectionKey.isReadable()) {
                    readHandler(selectionKey, selector);
                }
            }
        }
    }

    /**
     *
     */
    private void acceptHandler(SelectionKey selectionKey,
                               Selector selector)
            throws IOException {
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
        SocketChannel socketChannel = serverSocketChannel.accept();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
        socketChannel.write(Charset.forName("UTF-8").encode("<==== welcome ====>"));
    }

    /**
     *
     */
    private void readHandler(SelectionKey selectionKey,
                             Selector selector)
            throws IOException {
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        String request = "";
        while (socketChannel.read(byteBuffer) > 0) {
            byteBuffer.flip();
            request += Charset.forName("UTF-8").decode(byteBuffer);
        }
        socketChannel.register(selector, SelectionKey.OP_READ);
        if (request.length() > 0) {
            broadCast(selector, socketChannel, request);
        }
    }

    private void broadCast(Selector selector,
                           SocketChannel sourceChannel, String request) {
        Set<SelectionKey> selectionKeySet = selector.keys();
        selectionKeySet.stream().forEach(selectionKey -> {
            Channel targetChannel = selectionKey.channel();

            if (targetChannel instanceof SocketChannel
                    && targetChannel != sourceChannel) {
                try {
                    ((SocketChannel) targetChannel).write(
                            Charset.forName("UTF-8").encode(request));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) throws IOException {
        NioServer nioServer = new NioServer();
        nioServer.start();
    }
}