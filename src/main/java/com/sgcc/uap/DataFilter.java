package com.sgcc.uap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sgcc.uap.encrypt.WrapperedRequest;
import com.sgcc.uap.encrypt.WrapperedResponse;

//@Component
//@WebFilter(urlPatterns = { "/*" }, filterName = "DataFilter")
public class DataFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String requestBody = getRequestBody((HttpServletRequest) request);
		// 解密请求报文
		//String requestBodyMw = new String(Base64.getDecoder().decode(requestBody), "utf-8");
		// 解码
        byte[] base64decodedBytes = Base64.getDecoder().decode(requestBody);
        String requestBodyMw = new String(base64decodedBytes, "utf-8");
		
		System.out.println("解密请求数据：" + requestBodyMw);
		WrapperedRequest wrapRequest = new WrapperedRequest((HttpServletRequest) request, requestBodyMw);
		WrapperedResponse wrapResponse = new WrapperedResponse((HttpServletResponse) response);
		chain.doFilter(wrapRequest, wrapResponse); //调用controller
		byte[] data = wrapResponse.getResponseData();
		System.out.println("原始返回数据： " + new String(data, "utf-8"));
		// 加密返回报文
		String responseBodyMw = Base64.getEncoder().encodeToString(data);
		System.out.println("加密返回数据： " + responseBodyMw);
		writeResponse(response, responseBodyMw);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	private String getRequestBody(HttpServletRequest req) {
		try {
			BufferedReader reader = req.getReader();
			StringBuffer sb = new StringBuffer();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			String json = sb.toString();
			return json;
		} catch (IOException e) {
			System.out.println("请求体读取失败" + e.getMessage());
		}
		return "";
	}

	private void writeResponse(ServletResponse response, String responseString) throws IOException {
		PrintWriter out = response.getWriter();
		out.print(responseString);
		out.flush();
		out.close();
	}
}