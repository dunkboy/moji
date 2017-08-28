package com.sefon.moji.utils;

import fm.last.moji.MojiFile;
import fm.last.moji.MojiFileAttributes;
import fm.last.moji.spring.SpringMojiBean;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.List;

/**
 * <p>Title: MojiUtils</p>
 * <p>Description: MojiUtils</p>
 * <p>Copyright:Copyright(c) sefon 2017</p>
 * <p>Company: 成都四方伟业软件股份有限公司</p>
 * <p>CreateTime: 2017/8/18 11:21</p>
 *
 * @author cb
 * @version 1.0
 **/
public class MojiUtils
{

    private static SpringMojiBean moji;

    /**
     * <p>Description:SpringMojiBean初始化</p>
     * <p>Copyright:Copyright(c)2017</p>
     * <p>Company: 成都四方</p>
     * <p>CreateTime:2017/8/18 12:51</p>
     * <p>@author cb</p>
     *
     * @return void description
     * @version 1.0
     */
    static
    {
        moji = new SpringMojiBean();
        moji.setAddressesCsv(PropertyReader.getValue("moji.tracker.address"));
        moji.setDomain(PropertyReader.getValue("moji.domain"));
        moji.setMaxIdle(Integer.valueOf(PropertyReader.getValue("moji.pool.max.idle")));
        moji.setMaxActive(Integer.valueOf(PropertyReader.getValue("moji.pool.max.active")));
        moji.initialise();
        moji.setTestOnBorrow(Boolean.valueOf(PropertyReader.getValue("moji.pool.test.on.borrow")));
    }

    /**
     * 写mogiFile文件1
     */
    public static void writeFile(String key, File localFile) throws Exception
    {
        MojiFile mojiFile = moji.getFile(key);
        moji.copyToMogile(localFile, mojiFile);
    }

    /**
     * 写mogiFile文件2
     */
    public static void writeFile(String key, String storageClass, File localFile) throws Exception
    {
        MojiFile mojiFile = moji.getFile(key, storageClass);
        moji.copyToMogile(localFile, mojiFile);
    }

    /**
     * 写mogiFile文件3
     */
    public static void writeFile(String key, String storageClass, InputStream is) throws Exception
    {
        MojiFile mojiFile = moji.getFile(key, storageClass);
        OutputStream stream = mojiFile.getOutputStream();
        try
        {
            byte[] b = new byte[4096];
            int len;
            while ((len = is.read(b)) != -1)
            {
                stream.write(b, 0, len);
            }
        }
        finally
        {
            stream.flush();
            stream.close();
            is.close();
        }
    }

    /**
     * 写mogiFile文件4
     */
    public static void writeFile(String key, InputStream is) throws Exception
    {
        MojiFile mojiFile = moji.getFile(key);
        OutputStream stream = mojiFile.getOutputStream();
        try
        {
            byte[] b = new byte[4096];
            int len;
            while ((len = is.read(b)) != -1)
            {
                stream.write(b, 0, len);
            }
        }
        finally
        {
            stream.flush();
            stream.close();
            is.close();
        }
    }

    /**
     * 写本地文件
     */
    public static void writeFileToLocal(String key, File file) throws Exception
    {
        MojiFile mojiFile = moji.getFile(key);
        mojiFile.copyToFile(file);
    }

    /**
     * 删除mogifile文件
     */
    public static void deleteFile(String key) throws Exception
    {
        MojiFile mojiFile = moji.getFile(key);
        mojiFile.delete();
    }

    /**
     * 判断mogifile文件是否存在
     */
    public static Boolean exists(String key) throws Exception
    {
        MojiFile mojiFile = moji.getFile(key);
        return mojiFile.exists();
    }

    /**
     * 获取mogifile文件流
     */
    public static InputStream getMojiFile(String key) throws Exception
    {
        MojiFile mojiFile = moji.getFile(key);
        return mojiFile.getInputStream();
    }

    /**
     * 获取mogifile文件属性
     */
    public static MojiFileAttributes getMojiFileAttributes(String key) throws Exception
    {
        MojiFile mojiFile = moji.getFile(key);
        return mojiFile.getAttributes();
    }

    /**
     * 获取mogifile urls
     */
    public static List<URL> getMojiFilePaths(String key) throws Exception
    {
        MojiFile mojiFile = moji.getFile(key);
        return mojiFile.getPaths();
    }


}
