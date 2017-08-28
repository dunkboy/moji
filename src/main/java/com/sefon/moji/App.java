package com.sefon.moji;

import com.sefon.moji.impl.MojiApi;
import fm.last.moji.MojiFile;
import fm.last.moji.MojiFileAttributes;
import fm.last.moji.spring.SpringMojiBean;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * Hello world!
 */
public class App
{
    public static void main(String[] args) throws IOException
    {
        System.out.println("Hello World!");
        File testFile = new File("D:\\n\\mogilefs\\moji\\src\\main\\java\\com\\sefon\\moji\\123.txt");
        File testLocalFile = new File("D:\\n\\mogilefs\\moji\\src\\main\\java\\com\\sefon\\moji\\666.txt");
        MojiApi mojiApi = new MojiApi();

//        System.out.println(mojiApi.writeFile("test",testFile));//测试上传文件

        //获取url
//        List<URL> test = mojiApi.getHttpUrl("test");
//        for (URL url : test)
//        {
//            System.out.println(url.toString());
//        }

        //下载mogilefs
//        mojiApi.writeFileToLocal("test",testLocalFile);

        //mogilefs属性
//        MojiFileAttributes test = mojiApi.getMojiFileAttributes("test");
//        System.out.println(test.toString());

        //删除文件
//        mojiApi.deleteFile("test");

    }
}
