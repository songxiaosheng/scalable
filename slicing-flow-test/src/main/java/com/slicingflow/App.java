package com.slicingflow;

import com.slicingflow.zerocopy.NioClientHandler;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        System.out.println( "Hello World!" );
        RandomAccessFile randomAccessFile = new RandomAccessFile("README.md","rw");
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8000));

        Selector selector = Selector.open();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
        new Thread(new NioClientHandler(selector)).start();

        FileChannel channel = randomAccessFile.getChannel();
        channel.transferTo(1,10,socketChannel);
//        socketChannel.write(Charset.forName("UTF-8").encode(nickname + " : " + request));
//        socketChannel.
    }
}
