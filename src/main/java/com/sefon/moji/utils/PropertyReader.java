package com.sefon.moji.utils;

import org.apache.log4j.Logger;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Hashtable;
import java.util.Properties;

/**
 * <p>
 * Title: PropertyReader.java
 * </p>
 * <p>
 * Description: 公共读取properties配置文件方法
 * </p>
 * <p>
 * Copyright:Copyright(c)2015
 * </p>
 * <p>
 * Company: 成都四方
 * </p>
 * <p>
 * CreateTime:Dec 16, 2015 10:18:24 PM
 * </p>
 * 
 * @author xx
 * @version 1.0
 **/
public class PropertyReader
{

	private static Logger _log = Logger.getLogger(PropertyReader.class);

	private static Hashtable<String, Properties> pptContainer = new Hashtable<String, Properties>();

	/**
	 * 
	 * 方法用途和描述: 获得属性
	 * 
	 * @param key
	 *            属性键
	 * @return 属性值
	 * @author xx  
	 * @since 1.0
	 */
	public final static String getValueByJDBCPath(String key) {
		String propertyFilePath = Thread.currentThread().getContextClassLoader().getResource("").getPath()+"jdbc.properties";
//		String path = propertyFilePath.replaceFirst("/", "");
		Properties ppts = getProperties(propertyFilePath);
		return ppts == null ? null : ppts.getProperty(key);
	}
	
	/**
	 * 
	 * 方法用途和描述: 获得属性
	 * 
	 * @param key
	 *            属性键
	 * @return 属性值
	 * @author xx  
	 * @since 1.0
	 */
	public final static String getValue(String key) {
		String propertyFilePath = System.getProperty("user.dir")+ File.separator+"moji.properties";
//		String path = propertyFilePath.replaceFirst("/", "");
		Properties ppts = getProperties(propertyFilePath);
		return ppts == null ? null : ppts.getProperty(key);
	}
	/**
	 * 判断从配置文件读出的路径是否包含/ \
	 * @param path
	 * @return
	 */
	public final static String dealPath(String path) {
		//满足其中一个都不会在path后面加/
		if(!(path.endsWith("/")||path.endsWith("\\"))){
			path+="/";
		}
		path = path.replace("\\", "/");
		return path;
	}
	/**
	 * 方法用途和描述: 获得属性
	 * 
	 * @param propertyFilePath
	 *            属性文件(包括类路径)
	 * @param key
	 *            属性键
	 * @return 属性值
	 * @author xx  
	 * @since 1.0
	 */
	public final static String getValue(String propertyFilePath, String key) {
		Properties ppts = getProperties(propertyFilePath);
		return ppts == null ? null : ppts.getProperty(key);
	}

	/**
	 * 
	 * 方法用途和描述: 获得属性文件中Key所对应的值
	 * 
	 * @param propertyFilePath
	 *            属性文件路径(包括类路径或文件系统中文件路径)
	 * @param key
	 *            属性的键
	 * @param isAbsolutePath
	 *            是否为绝对路径:true|false〔即是本地文件系统路径，比如：C:/test.propreties〕<br>
	 * <br>
	 *            <b>注：</b>不能通过类路径来获取到属性文件，而只知道属性文件的文件系统路径，
	 *            即文件系统地址则用此方法来获取其中的Key所对应的Value
	 * @return key的属性值
	 * @author xx  
	 * @since 1.0
	 */
	public final static String getValue(String propertyFilePath, String key,
			boolean isAbsolutePath) {
		if (isAbsolutePath) {
			Properties ppts = getPropertiesByFs(propertyFilePath);
			return ppts == null ? null : ppts.getProperty(key);
		}
		return getValue(propertyFilePath, key);
	}

	/**
	 * 
	 * 方法用途和描述: 获得属性文件的属性
	 * 
	 * @param propertyFilePath
	 *            属性文件(包括类路径)
	 * @return 属性
	 * @author xx  
	 * @since 1.0
	 */
	public final static Properties getProperties(String propertyFilePath) {
		if (propertyFilePath == null) {
			_log.error("propertyFilePath is null!");
			return null;
		}
		Properties ppts = pptContainer.get(propertyFilePath);
		if (ppts == null) {
			ppts = loadPropertyFile(propertyFilePath);
			if (ppts != null) {
				pptContainer.put(propertyFilePath, ppts);
			}
		}
		return ppts;
	}

	/**
	 * 
	 * 方法用途和描述: 获得属性文件的属性
	 * 
	 * @param propertyFilePath
	 *            属性文件路径(包括类路径及文件系统路径)
	 * @return 属性文件对象 Properties
	 * @author xx  
	 * @since 1.0
	 */
	public final static Properties getPropertiesByFs(String propertyFilePath) {
		if (propertyFilePath == null) {
			_log.error("propertyFilePath is null!");
			return null;
		}
		Properties ppts = pptContainer.get(propertyFilePath);
		if (ppts == null) {
			ppts = loadPropertyFileByFileSystem(propertyFilePath);
			if (ppts != null) {
				pptContainer.put(propertyFilePath, ppts);
			}
		}
		return ppts;
	}

	/**
	 * 
	 * 方法用途和描述: 加载属性
	 * 
	 * @param propertyFilePath
	 *            属性文件(包括类路径)
	 * @return 属性
	 * @author xx  
	 * @since 1.0
	 */
	private static Properties loadPropertyFile(String propertyFilePath) {
		java.io.InputStream is = PropertyReader.class
				.getResourceAsStream(propertyFilePath);
		if (is == null) {
			return loadPropertyFileByFileSystem(propertyFilePath);
		}
		Properties ppts = new Properties();
		try {
			ppts.load(is);
			return ppts;
		} catch (Exception e) {
			_log.debug("加载属性文件出错:" + propertyFilePath, e);
			return null;
		}
	}

	/**
	 * 
	 * 方法用途和描述: 从文件系统加载属性文件
	 * 
	 * @param propertyFilePath
	 *            属性文件(文件系统的文件路径)
	 * @return 属性
	 * @author xx  
	 * @since 1.0
	 */
	private static Properties loadPropertyFileByFileSystem(
			final String propertyFilePath) {
		try {
			Properties ppts = new Properties();
			ppts.load(new java.io.FileInputStream(propertyFilePath));
			return ppts;
		} catch (java.io.FileNotFoundException e) {
			_log.error("FileInputStream(\"" + propertyFilePath
					+ "\")! FileNotFoundException: " + e);
			return null;
		} catch (java.io.IOException e) {
			_log.error("Properties.load(InputStream)! IOException: " + e);
			return null;
		}
	}

	public static void main(String[] args) {
		try {
			String address = InetAddress.getLocalHost().getHostAddress();
			System.out.println(address);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String path = "/base.properties";
		String v = PropertyReader.getValue(path, "base.eds.ip");
		System.out.println(v);
		//用于eds调度的ip地址
		String edsIp = PropertyReader.getValue(path, "base.eds.ip");
		//用于eds调度的端口
		String edsPort = PropertyReader.getValue(path, "base.eds.port");
		String url ="http://"+edsIp+":"+edsPort+"/EDS/JSON/Login";
		System.out.println(url);
		_log.info("value0 = " + v);

		Hashtable<String, String> ht = new Hashtable<String, String>();
		ht.put("name", "xx");
		String v_ = PropertyReader.getValue(path, "name");
		_log.info("value1 = " + v_);
		String v2_ = PropertyReader.getValue(path, "name");
		_log.info("value2 = " + v2_);
	}
}
