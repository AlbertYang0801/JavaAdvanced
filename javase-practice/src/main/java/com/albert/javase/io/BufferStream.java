package com.albert.javase.io;

import org.junit.Test;

import java.io.*;

/**
 * 缓冲流的练习
 *
 * @author yangjunwei
 * @date 2021/9/8 4:08 下午
 */
public class BufferStream {

    @Test
    public void testBufferIo() {
        String path = "src/main/java/com/albert/javase/io/file/hello.jpg";
        String outputPath = "src/main/java/com/albert/javase/io/file/newhello.jpg";

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            //1.创建字节输入流和字节输出流
            fileInputStream = new FileInputStream(path);
            fileOutputStream = new FileOutputStream(outputPath);

            //2.创建对应的缓冲流
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            //3.创建字节数组
            byte[] bytes = new byte[1024];
            int length;
            while ((length = bufferedInputStream.read(bytes)) != -1) {
                //缓冲区写入
                bufferedOutputStream.write(bytes, 0, length);
            }
            System.out.println("复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (bufferedOutputStream != null) {
//                    bufferedOutputStream.flush();
                    //缓冲区的流对象在关闭流之前，会自动刷新缓冲区
                    bufferedOutputStream.close();
                }
                //关闭带缓冲区的流对象，会自动关闭节点流
//                fileInputStream.close();
//                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


}
