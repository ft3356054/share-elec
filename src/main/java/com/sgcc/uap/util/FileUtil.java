package com.sgcc.uap.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 文件相关工具类
 * @author llb
 *
 */
public class FileUtil {
	
	private static final Logger log = LoggerFactory.getLogger(FileUtil.class);
	
	/**
	 * 文件下载或在线打开
	 * @param response
	 * @param filePath 文件路径
	 * @param inline ture 在线打开 false 下载
	 */
	public static void downloadFile(HttpServletResponse response,String filePath,boolean inline){
		File file = new File(filePath);
		if (!file.isFile()){
			BaseLog.error(log,"要下载或打开的文件不存在");
		}
        BufferedInputStream br = null;
        OutputStream out = null;
		try {
			String name = file.getName();
            String fileName = new String(name.getBytes("GBK"),"ISO8859-1");
            br = new BufferedInputStream(new FileInputStream(file));
            Integer size = br.available();
            byte[] buf = new byte[2048];
            response.reset();
            if (inline){
            	response.setHeader("Content-Disposition", "inline; filename=" + fileName);
			} else {
				response.addHeader("Content-Disposition", "attachment;filename="  + fileName);
			}
            response.setContentType("application/octet-stream");
            response.addHeader("Content-Length", "" + size);
            out = response.getOutputStream();
            int len = 0;
            while ((len = br.read(buf)) != -1) {
                out.write(buf, 0, len);
            }
            br.close();
            out.close();
		} catch (Exception e){
			BaseLog.error(log, "文件下载失败:", e);
		} finally {
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                	BaseLog.error(log,"文件下载失败");
                }
            }
            if (out != null){
                try {
                    out.close();
                } catch (IOException e) {
                	BaseLog.error(log,"文件下载失败");
                }
            }
        }
	}
}
