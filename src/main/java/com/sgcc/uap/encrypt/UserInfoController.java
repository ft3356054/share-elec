package com.sgcc.uap.encrypt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONObject;
 
@RestController
@RequestMapping("/v1/api/")
public class UserInfoController {
 /*
  String url="http://localhost:8080/v1/api/test";
  eyJwbGFjZUlkIjoiMiIsIm1lZGlhQ29kZSI6Im90dGF1dG8iLCJjSWQiOiIxIn0=
  * */
    //测试
    @PostMapping(value = "test",produces = "application/json;charset=UTF-8")
    public String test(HttpServletRequest request,HttpServletResponse response) {
        JSONObject jsonObject = new JSONObject();
        JSONObject clientJson = getClientJson(request, response);
        System.out.println("【客户端收集到的数据为】clientJson={}"+clientJson);
        return clientJson.toString();
    }
    public JSONObject getClientJson(HttpServletRequest request,HttpServletResponse response) {
        JSONObject json = null;
        try {
            //提取json
            //response.setContentType("application/json; charset=utf-8");
            response.setContentType("text/json");
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            BufferedReader br = null;
            if (request.getContentType().contains("text") || request.getContentType().contains("json")) {
                br = new BufferedReader(new InputStreamReader((ServletInputStream) request.getInputStream(), "UTF-8"));
                StringBuilder sb = new StringBuilder();
                String temp;
                while ((temp = br.readLine()) != null) {
                    sb.append(temp);
                }
                //json = JSONObject.parseObject(sb.toString());
                json = JSONObject.fromObject(sb.toString());
            }
 
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("客户端请求数据异常->" + e.getMessage());
        }
        System.out.println(json.toString());
        return json;
    }
    
    public static void main(String[] args) throws UnsupportedEncodingException {
		String url="http://localhost:8080/v1/api/test";
		String json="{\"placeId\":\"2\",\"mediaCode\":\"ottauto\",\"cId\":\"1\"}";
		
		// 使用基本编码
        String base64encodedString = Base64.getEncoder().encodeToString(json.getBytes("utf-8"));
        System.out.println("Base64 编码字符串 (基本) :" + base64encodedString);
        // 解码
        byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);
        System.out.println("原始字符串: " + new String(base64decodedBytes, "utf-8"));
		//String responseBodyMw =new String(Base64.getDecoder().decode(json), "utf-8");
	}
 
}
