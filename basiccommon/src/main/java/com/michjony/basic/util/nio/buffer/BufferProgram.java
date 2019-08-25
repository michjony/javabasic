package com.michjony.basic.util.nio.buffer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * user:Cherie
 * datetime;2019/8/25 21:54
 */
public class BufferProgram {

    public static void main(String[] args) throws Exception {
        FileInputStream fin = new FileInputStream("");
        // 创建文件的操作管道
        FileChannel fc = fin.getChannel();

        // 分配一个10字节大小的缓冲区，byte数组长度为10
        ByteBuffer buffer = ByteBuffer.allocate(10);
        System.out.println("初始化buffer");
        // 先读一下
        fc.read(buffer);
        buffer.flip();
        System.out.println("调用flip()");
    }
}
