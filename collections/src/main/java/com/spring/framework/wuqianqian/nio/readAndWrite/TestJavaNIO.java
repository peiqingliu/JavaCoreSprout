package com.spring.framework.wuqianqian.nio.readAndWrite;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * 使用nio读取数据的顺序为：
 * 任何时候读取数据，都不是直接从通道读取，而是从通道读取到缓冲区。所以使用NIO读取数据可以分为下面三个步骤：
 * 0.准备文件
 * 1.从FileInputStream获取Channel
 * 2.创建Buffer
 * 3.将数据从Channel读取到Buffer中
 * @author liupeqing
 * @date 2019/2/13 14:29
 */
public class TestJavaNIO {

    //读取文件
    public static void readNIO(){

        String pathFile = "D:\\logs\\test.txt";
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(pathFile);
            //获取管道
            /**
             * 一个Channel可以和文件或者网络Socket对应
             * 一头是文件或者网络，一头是buffer.
             */
            FileChannel fileChannel = inputStream.getChannel();
            /**
             * Buffer主要有三个属性
             * 容量（Capacity）：缓冲区能够容纳的数据元素的最大数量。这一个容量在缓冲区创建时被设定，并且永远不能改变。
             * 上界(Limit)：缓冲区的第一个不能被读或写的元素。或者说,缓冲区中现存元素的计数。
             * 位置(Position)：下一个要被读或写的元素的索引。位置会自动由相应的 get( )和 put( )函数更新。
             *
             * 缓冲区常用方法
             *
             * clear：将当前位置设置为0，限制设置为容量，目的是尽最大可能让字节，由通道读取到缓冲中
             *
             * flip：当前位置置为限制，然后将当前位置置为0，目的是将有数据部分的字节，由缓冲写入到通道中。通常用在读与写之间。
             *
             * 写数据到Buffer有两种方法：
             *
             * 1.从Channel中写数据到Buffer
             *
             * int bytesRead = inChannel.read(buf); //read into buffer.
             * 2.通过put写数据：
             *
             * buf.put(127);
             *
             */
            int capacity = 10;// 字节
            ByteBuffer byteBuffer = ByteBuffer.allocate(capacity);
            System.out.println("限制是：" + byteBuffer.limit() + "容量是：" + byteBuffer.capacity()
                    + "位置是：" + byteBuffer.position());
            int length = -1;
            while ((length = fileChannel.read(byteBuffer)) != -1){
                //每次都将限制设置为容量，相当于整个buffer都可以利用
                byteBuffer.clear();
                byte[] bytes = byteBuffer.array();
                System.out.write(bytes,0,length);
                System.out.println();
                System.out.println("限制是：" + byteBuffer.limit() + "容量是：" + byteBuffer.capacity()
                        + "位置是：" + byteBuffer.position());
            }
            fileChannel.close();

        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void readNIO2() {
        // 分配内存大小为10的缓存区
        ByteBuffer buffer = ByteBuffer.allocate(10);
        // 往buffer里写入数据
        for (int i = 5; i < 10; ++i) {
            int randomNumber = i;
            buffer.put((byte) randomNumber);
        }
        //限制是：10容量是：10位置是：5
        System.out.println("限制是：" + buffer.limit() + "容量是：" + buffer.capacity()
                + "位置是：" + buffer.position());
        // 将Buffer从写模式切换到读模式（必须调用这个方法）
        /**
         * 如果此处为clear()方法，则下面循环读取buffer数据，则是从位置为0的地方开始读取。从0-10，因为buffer的限制为10，后面从第六个开始，buffer总填充的为0
         * 如果此处调用buffer.flip().方法，此时 会将Position的值付给limit，而Position位置为0，此时读取的数据 只会到5，因为limit的值为5。会读取我们一开始存的数据。
         */
        buffer.flip();
        // 读取buffer里的数据
        while (buffer.hasRemaining()) {
            System.out.println("限制是：" + buffer.limit() + "容量是：" + buffer.capacity()
                    + "位置是：" + buffer.position());
            System.out.println(buffer.get());
        }
    }


    public static void writeNIO(){
        String filename = "D:\\out.txt";
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(filename);
            FileChannel fileChannel = fos.getChannel();
            ByteBuffer byteBuffer = Charset.forName("utf8").encode("你好你好你好你好你好！");
            // 字节缓冲的容量和limit会随着数据长度变化，不是固定不变的
            System.out.println("初始化容量和limit：" + byteBuffer.capacity() + ","
                    + byteBuffer.limit());
            int length = 0;
            while ((length = fileChannel.write(byteBuffer)) !=0){
                /*
                 * 注意，这里不需要clear，将缓冲中的数据写入到通道中后 第二次接着上一次的顺序往下读
                 */
                System.out.println("写入长度:" + length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将文件读取到buffer,然后写到文件中
     */
    public static void testReadAndWriteNIO(){
        String pathFile = "D:\\logs\\test.txt";
        FileInputStream fis = null;
        String fileName = "D:\\out_log.txt";
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(pathFile);
            FileChannel fisChannel = fis.getChannel();
            int capacity = 100;// 字节
            ByteBuffer byteBuffer = ByteBuffer.allocate(capacity);
            System.out.println("限制是：" + byteBuffer.limit() + "容量是：" + byteBuffer.capacity()+ "位置是：" + byteBuffer.position());
            int length = -1;
            fos = new FileOutputStream(new File(fileName));
            FileChannel outchannel = fos.getChannel();
            //边读边写
            while ( (length = fisChannel.read(byteBuffer)) != -1){
                //将当前位置置为limit，然后设置当前位置为0，也就是从0到limit这块，都写入到通道中
                //再从通道中写入文件
                byteBuffer.flip();
                int outlength =0;
                while ((outlength = outchannel.write(byteBuffer)) != 0){
                    System.out.println("读，"+length+"写,"+outlength);
                }
                //将当前位置置为0，然后设置limit为容量，也就是从0到limit（容量）这块，
                //都可以利用，通道读取的数据存储到
                //0到limit这块
                byteBuffer.clear();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        //readNIO();
        //writeNIO();
        testReadAndWriteNIO();
    }
}
