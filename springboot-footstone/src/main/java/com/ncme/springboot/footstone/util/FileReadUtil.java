package com.ncme.springboot.footstone.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;


/**
 * 属性文件工具类
 *
 */
public class FileReadUtil {
	
	private static Logger log = Logger.getLogger(FileReadUtil.class);
	
	
	
	/**
	 * 获取某个jar包下面文件夹的文件集合
	 * @return
	 */
	public Resource[] getFileList(String fileAddr){
		Resource[] workflowResources  = null;
		try {
			final PathMatchingResourcePatternResolver pmrpr = new PathMatchingResourcePatternResolver(FileReadUtil.class.getClassLoader());
			workflowResources = pmrpr.getResources("classpath*:/"+fileAddr);
			if (workflowResources == null || workflowResources.length == 0) {
				workflowResources = pmrpr.getResources("classpath*:resources/"+fileAddr);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return workflowResources;
	}
	
	
	
	/**
	 * 获取文件夹中所有文件名
	 * @param path
	 * @return
	 */
	public String[] getFileName(String fileName){
        File file = new File(fileName);
        String[] fileNames = file.list();
        return fileNames;
    }
	
	/**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public String readFileByLines(InputStream inputStream) {
//    	InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);  
    	ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
    	try {
	        byte[] data = new byte[1024];  
	        int count = -1;  
	        while((count = inputStream.read(data,0,1024)) != -1)  
	            outStream.write(data, 0, count);  
	          
	        data = null;  
	        inputStream.close();
	        outStream.close();
	        return new String(outStream.toByteArray(),"utf-8"); 
    	} catch (IOException e) {
    		e.printStackTrace();
    	}  
    	return "";
    }
	
	/**
	 * 读取属性文件的内容
	 * @return
	 */
	public  Properties getProperties(String proName){  
		Properties props = null;
	    try {
	    	InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(proName);
	    	props = new Properties();
	    	props.load(inputStream);
	    	log.info("加载配置文件属性实体类初始化成功！");
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			
		} 
	    return props;
	}  
}
