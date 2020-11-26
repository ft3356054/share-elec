package com.sgcc.uap.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 对list的工具类
 * @author llb
 *
 */
public class ListUtil {
	/**
	 * 比较两个list，list1-list2
	 * @param list1
	 * @param list2
	 * @return 返回list1中存在，list2中不存在的值
	 */
	public static List<String> listCompare(List<String> list1,List<String> list2) {
		List<String> diff = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>(list1.size()+list2.size());
		for(String object : list1){
			map.put(object, 1);
		}
		for(String object : list2){
			map.put(object, 2);
		}
		for(Map.Entry<String, Integer> mapEntity:map.entrySet()){
			if(mapEntity.getValue()==1){
				diff.add(mapEntity.getKey());
			}
		}
		return diff;
	}
	/**
	 * 求两个list中共同的元素by青山
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static List<String> listCommon(List<String> list1,List<String> list2) {
		Collection<String> exists=new ArrayList<String>(list1);
		exists.removeAll(list2);
		list1.remove(exists);
		return list1;
	}
	
	/**
	 * 返回list集合共同的元素by马世国
	 */
	public static List<String> listSame(List<String> list1, List<String> list2) {
		List<String> listSame = new ArrayList<String>();
		for (String str : list1) {
			for (String strFinal : list2) {
				if (str.equals(strFinal)) {
					listSame.add(str);
				}
			}
		}
		return listSame;
	}
	
	/**
	 * 将数组对象转换成List集合
	 * @param params
	 * @return
	 */
	public static List<String> arrayTransList(String params[]){
		List<String> list = new ArrayList<String>();
		if(params != null){
			for(String param : params){
				list.add(param);
			}
		}
		return list;
	}
//	public static void main(String[] args) {
//		List<String> l1 = new ArrayList<>();
//		List<String> l2 = new ArrayList<>();
//		l1.add("哈哈哈1");
//		l1.add("哈哈哈2");
//		l1.add("哈哈哈3");
//		l2.add("哈哈哈2");
//		l2.add("哈哈哈1");
//		for(String s:listCommon(l2, l1)){
//			System.out.println(s);
//		}
//	}
}
