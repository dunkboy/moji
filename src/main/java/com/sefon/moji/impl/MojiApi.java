package com.sefon.moji.impl;

import com.sefon.moji.IMojiApi;
import com.sefon.moji.utils.MojiUtils;
import fm.last.moji.MojiFileAttributes;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

/**
 * <p>Title: MojiApi</p>
 * <p>Description: MojiApi</p>
 * <p>Copyright:Copyright(c) sefon 2017</p>
 * <p>Company: 成都四方伟业软件股份有限公司</p>
 * <p>CreateTime: 2017/8/18 11:29</p>
 *
 * @author cb
 * @version 1.0
 **/
public class MojiApi implements IMojiApi
{
    private static Logger logger = org.apache.log4j.Logger.getLogger(MojiApi.class);

    static
    {
        PropertyConfigurator.configure(System.getProperty("user.dir") + File.separator + "log4j.properties");
    }

    public Boolean writeFile(String key, File localFile)
    {
        try
        {
            MojiUtils.writeFile(key, localFile);
            return true;
        }
        catch (Exception e)
        {
            logger.error("###写入MogiFile失败!", e);
            return false;
        }
    }

    public Boolean writeFile(String key, String storageClass, File localFile)
    {
        try
        {
            MojiUtils.writeFile(key, storageClass, localFile);
            return true;
        }
        catch (Exception e)
        {
            logger.error("###写入MogiFile失败!", e);
            return false;
        }
    }

    public Boolean writeFile(String key, String storageClass, InputStream is)
    {
        try
        {
            MojiUtils.writeFile(key, storageClass, is);
            return true;
        }
        catch (Exception e)
        {
            logger.error("###写入MogiFile失败!", e);
            return false;
        }
    }

    public Boolean writeFile(String key, InputStream is)
    {
        try
        {
            MojiUtils.writeFile(key, is);
            return true;
        }
        catch (Exception e)
        {
            logger.error("###写入MogiFile失败!", e);
            return false;
        }
    }

    public Boolean writeFileToLocal(String key, File file)
    {
        try
        {
            MojiUtils.writeFileToLocal(key, file);
            return true;
        }
        catch (Exception e)
        {
            logger.error("###写入本地文件失败!", e);
            return false;
        }
    }

    public Boolean isExist(String key)
    {
        try
        {
            return MojiUtils.exists(key);
        }
        catch (Exception e)
        {
            logger.error("###there was a problem communicating with MogileFS!", e);
            return null;
        }
    }

    public Boolean deleteFile(String key)
    {
        try
        {
            MojiUtils.deleteFile(key);
            return true;
        }
        catch (Exception e)
        {
            logger.error("###删除失败!", e);
            return false;
        }
    }

    public InputStream getInputStream(String key)
    {
        try
        {
            return MojiUtils.getMojiFile(key);
        }
        catch (Exception e)
        {
            logger.error("###获取文件流失败!", e);
            return null;
        }
    }

    public MojiFileAttributes getMojiFileAttributes(String key)
    {
        try
        {
            return MojiUtils.getMojiFileAttributes(key);
        }
        catch (Exception e)
        {
            logger.error("###获取文件属性失败!", e);
            return null;
        }
    }

    public List<URL> getHttpUrl(String key)
    {
        try
        {
            return MojiUtils.getMojiFilePaths(key);
        }
        catch (Exception e)
        {
            logger.error("###获取文件地址失败!", e);
            return null;
        }
    }
}
