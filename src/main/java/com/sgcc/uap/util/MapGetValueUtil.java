package com.sgcc.uap.util;
//2020年12月24日

import java.util.Map;
import java.util.Map.Entry;

import com.sgcc.uap.share.domain.ElectricianCompanyInfo;
import com.sgcc.uap.share.domain.ElectricianInfo;


public class MapGetValueUtil {
	
	/**
	 * 返回集合中的第一个值
	 */
	
	public static ElectricianCompanyInfo getFirstOrNull(Map<Double, ElectricianCompanyInfo> map) {
		ElectricianCompanyInfo obj = null;
        for (Entry<Double, ElectricianCompanyInfo> entry : map.entrySet()) {
            obj = entry.getValue();
            if (obj != null) {
                break;
            }
        }
        return  obj;
    }
	
	
	public static ElectricianInfo getFirstElectricianInfo(Map<Double, ElectricianInfo> map) {
		ElectricianInfo obj = null;
        for (Entry<Double, ElectricianInfo> entry : map.entrySet()) {
            obj = entry.getValue();
            if (obj != null) {
                break;
            }
        }
        return  obj;
    }

}
