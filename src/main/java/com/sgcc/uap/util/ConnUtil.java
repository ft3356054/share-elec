package com.sgcc.uap.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * <p>Title:ConnMQUtil </p>
 * <p>Description: 通过HTTP请求访问服务器的方法</p>
 * @author llb 
 */
public class ConnUtil {
	
	private static final Logger log = LoggerFactory.getLogger(ConnUtil.class);
	
	/**
	 * 
	 * @param jsonParam
	 * @param url 通过配置文件读取
	 * @return
	 */
	public static String callPostApiUrl(String jsonParam,String url) {
		String resJson = null ;
		try {
			// 创建client和post对象
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpPost post = new HttpPost(url);
			post.addHeader("content-type", "application/json");
			post.addHeader("Accept", "application/json");
			// json字符串以实体的实行放到post中
			StringEntity entity = new StringEntity(jsonParam, "UTF-8");
			post.setEntity(entity);
			// 获得response对象
			HttpResponse res = httpClient.execute(post);
			// 获得字符串形式的结果
			resJson = EntityUtils.toString(res.getEntity());
		} catch (Exception e) {
			BaseLog.error(log, "通过post请求访问服务器失败:", e);
		}
		return resJson;
	}
	
	
	public static String callGetApiUrl(String url) {
		String resJson = null ;
		try {
			// 创建client和post对象
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpGet get = new HttpGet(url);
			get.addHeader("content-type", "application/json");
			get.addHeader("Accept", "application/json");
			// 获得response对象
			HttpResponse res = httpClient.execute(get);
			// 获得字符串形式的结果
			resJson = EntityUtils.toString(res.getEntity());
		} catch (Exception e) {
			BaseLog.error(log, "通过get请求访问服务器失败:", e);
		}
		return resJson;
	}
	
	
}
