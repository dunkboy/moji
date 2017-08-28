package com.sefon.moji;

import fm.last.moji.MojiFileAttributes;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

/**
 * <p>Title: IMojiApi</p>
 * <p>Description: IMojiApi</p>
 * <p>Copyright:Copyright(c) sefon 2017</p>
 * <p>Company: 成都四方伟业软件股份有限公司</p>
 * <p>CreateTime: 2017/8/18 11:28</p>
 *
 * @author cb
 * @version 1.0
 **/
public interface IMojiApi
{

    /**
     * <p>Description:根据key写入文件</p>
     * <p>Copyright:Copyright(c)2017</p>
     * <p>Company: 成都四方</p>
     * <p>CreateTime:2017/8/18 13:35</p>
     * <p>@author cb</p>
     *
     * @param key       根据key+domain定位文件 在一个domain中key必须唯一
     * @param localFile 本地文件
     * @return java.lang.Boolean description
     * @version 1.0
     */
    Boolean writeFile(String key, File localFile);

    /**
     * <p>Description:根据key和class写入文件</p>
     * <p>Copyright:Copyright(c)2017</p>
     * <p>Company: 成都四方</p>
     * <p>CreateTime:2017/8/18 13:35</p>
     * <p>@author cb</p>
     *
     * @param key       根据key+domain定位文件 在一个domain中key必须唯一
     * @param key       storage class
     * @param localFile 本地文件
     * @return java.lang.Boolean description
     * @version 1.0
     */
    Boolean writeFile(String key, String storageClass, File localFile);

    /**
     * <p>Description:根据key和class写入文件</p>
     * <p>Copyright:Copyright(c)2017</p>
     * <p>Company: 成都四方</p>
     * <p>CreateTime:2017/8/18 13:35</p>
     * <p>@author cb</p>
     *
     * @param key 根据key+domain定位文件 在一个domain中key必须唯一
     * @param key storage class
     * @param is  流文件
     * @return java.lang.Boolean description
     * @version 1.0
     */
    Boolean writeFile(String key, String storageClass, InputStream is);

    /**
     * <p>Description:根据key写入文件</p>
     * <p>Copyright:Copyright(c)2017</p>
     * <p>Company: 成都四方</p>
     * <p>CreateTime:2017/8/18 13:35</p>
     * <p>@author cb</p>
     *
     * @param key 根据key+domain定位文件 在一个domain中key必须唯一
     * @param is  流文件
     * @return java.lang.Boolean description
     * @version 1.0
     */
    Boolean writeFile(String key, InputStream is);

    /**
     * <p>Description:将mojiFile文件写入本地</p>
     * <p>Copyright:Copyright(c)2017</p>
     * <p>Company: 成都四方</p>
     * <p>CreateTime:2017/8/18 13:35</p>
     * <p>@author cb</p>
     *
     * @param key  根据key+domain定位文件 在一个domain中key必须唯一
     * @param file 本地文件
     * @return java.lang.Boolean description
     * @version 1.0
     */
    Boolean writeFileToLocal(String key, File file);

    /**
     * <p>Description:根据key判断文件是否存在</p>
     * <p>Copyright:Copyright(c)2017</p>
     * <p>Company: 成都四方</p>
     * <p>CreateTime:2017/8/18 13:35</p>
     * <p>@author cb</p>
     *
     * @param key 根据key+domain定位文件 在一个domain中key必须唯一
     * @return java.lang.Boolean description
     * @version 1.0
     */
    Boolean isExist(String key);

    /**
     * <p>Description:根据key删除文件</p>
     * <p>Copyright:Copyright(c)2017</p>
     * <p>Company: 成都四方</p>
     * <p>CreateTime:2017/8/18 13:35</p>
     * <p>@author cb</p>
     *
     * @param key 根据key+domain定位文件 在一个domain中key必须唯一
     * @return java.lang.Boolean description
     * @version 1.0
     */
    Boolean deleteFile(String key);

    /**
     * <p>Description:获取MojiFile输入流</p>
     * <p>Copyright:Copyright(c)2017</p>
     * <p>Company: 成都四方</p>
     * <p>CreateTime:2017/8/18 13:35</p>
     * <p>@author cb</p>
     *
     * @param key 根据key+domain定位文件 在一个domain中key必须唯一
     * @return InputStream description
     * @version 1.0
     */
    InputStream getInputStream(String key);

    /**
     * <p>Description:获取MojiFile属性</p>
     * <p>Copyright:Copyright(c)2017</p>
     * <p>Company: 成都四方</p>
     * <p>CreateTime:2017/8/18 13:35</p>
     * <p>@author cb</p>
     *
     * @param key 根据key+domain定位文件 在一个domain中key必须唯一
     * @return MojiFileAttributes description
     * @version 1.0
     */
    MojiFileAttributes getMojiFileAttributes(String key);

    /**
     * <p>Description:获取MojiFile http url</p>
     * <p>Copyright:Copyright(c)2017</p>
     * <p>Company: 成都四方</p>
     * <p>CreateTime:2017/8/18 13:35</p>
     * <p>@author cb</p>
     *
     * @param key 根据key+domain定位文件 在一个domain中key必须唯一
     * @return MojiFileAttributes description
     * @version 1.0
     */
    List<URL> getHttpUrl(String key);

}
