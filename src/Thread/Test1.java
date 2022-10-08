package Thread;


import org.apache.commons.io.FileUtils;

import java.io.File;

import java.io.IOException;
import java.net.URL;

/**
 * 目的： 通过多线程同步来进行图片下载
 */
public class Test1 extends Thread{

    private String url;
    private String file;

    public Test1(String url,String file)
    {
        this.url = url;
        this.file = file;
        System.out.println("下载"+file);
    }

    @Override
    public void run()
    {
        Downloader downloader = new Downloader();
        downloader.downloader(url,file);
    }

    public static void main(String[] args) {
        Test1 t1 =  new Test1("https://i0.hdslb.com/bfs/sycp/creative_img/202203/4ba3ceca66686956cc8970a12f54af35.jpg@.webp","1.jpg");
        Test1 t2 =  new Test1("https://i0.hdslb.com/bfs/sycp/creative_img/202201/d5c1066867bbcc53e6dbdeeb6fdc8f7c.jpg@.webp","2.jpg");
        Test1 t3 =  new Test1("https://i0.hdslb.com/bfs/sycp/creative_img/202209/2160e3c690caad216e3b245a53db8ed7.jpg@.webp","3.jpg");
        //同时执行3条线程，理论上不算安顺序执行
        t1.start(); //通过start开辟新的线程，执行run（）。执行下载
        t2.start();
        t3.start();
    }
}

class Downloader
{
    public void downloader(String url,String file)
    {
        try {
            FileUtils.copyURLToFile(new URL(url),new File(file));    //拷贝一个url对应图片 到 文件
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("下载出现问题");
        }
    }
}