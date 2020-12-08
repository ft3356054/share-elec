package com.sgcc.uap.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

	/**
	* 1.json string 转换为 map
	* 2.json string 转换为 对象
	* @author zhangtengda
	*
	*/
	public class JsonUtils {
		public static void main(String[] args) {
		String jsonStr = "{\"status\":\"0\",\"data\":{\"name\":\"tom\",\"age\":18}}";
	
		// ================================
		// 1.如果是拿出来最外层的 map
		Map<Object, Object> result = jsonToMap(jsonStr);
		System.out.println(result.get("status"));
		System.out.println(result.get("data"));
	
		// 2.如果进步一拿到内层的 map
		Map<Object, Object> data = jsonToMap(result.get("data"));
		System.out.println(data.get("name"));
		System.out.println(data.get("age"));
		// ================================
	
		Long beginTime = System.currentTimeMillis();
		// 3.转换为对象
		String personStr = "{\"id\":12,\"name\":\"mary\"}";
		/*Person person = jsonToBean(personStr, Person.class);
		System.out.println(person);*/
	
		System.out.println("耗时：" +( System.currentTimeMillis() - beginTime));
	
		}

	/**
	* json string 转换为 map 对象
	* @param jsonObj
	* @return
	*/
	public static Map<Object, Object> jsonToMap(Object jsonObj) {
		JSONObject jsonObject = JSONObject.fromObject(jsonObj);
		Map<Object, Object> map = (Map)jsonObject;
		return map;
	}
	
	    
    /**
     * 将json对象转换为HashMap
     * @param json
     * @return
     */
    public static Map<String, Object> parseJSON2Map(JSONObject json) {
        Map<String, Object> map = new HashMap<String, Object>();
        // 最外层解析
        for (Object k : json.keySet()) {
            Object v = json.get(k);
            // 如果内层还是json数组的话，继续解析
            if (v instanceof JSONArray) {
                List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
                Iterator<JSONObject> it = ((JSONArray) v).iterator();
                while (it.hasNext()) {
                    JSONObject json2 = it.next();
                    list.add(parseJSON2Map(json2));
                }
                map.put(k.toString(), list);
            } else if (v instanceof JSONObject) {
                // 如果内层是json对象的话，继续解析
                map.put(k.toString(), parseJSON2Map((JSONObject) v));
            } else {
		// 如果内层是普通对象的话，直接放入map中
                map.put(k.toString(), v);
            }
        }
        return map;
    }
	 
    /**
     * 将json字符串转换为Map
     * @param jsonStr
     * @return
     */
    public static Map<String, Object> parseJSONstr2Map(String jsonStr) {
        JSONObject json = JSONObject.fromObject(jsonStr);
        Map<String, Object> map = parseJSON2Map(json);
        return map;
    }
	

    /**json string 转换为 对象
	* @param jsonObj
	* @param type
	* @return
	*/
	public static <T> T jsonToBean(Object jsonObj, Class<T> type) {
		JSONObject jsonObject = JSONObject.fromObject(jsonObj);
		T obj =(T)JSONObject.toBean(jsonObject, type);
		return obj;
	}
	
	/**json string 转换为 对象
	* @param jsonObj
	* @param type
	* @return
	*/
	public static String mapToJson(Map<String, String>  map) {
		JSONObject json = JSONObject.fromObject(map);
		return json.toString();
	}
	
	

}
