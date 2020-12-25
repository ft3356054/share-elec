package com.sgcc.uap.util;
//2020年12月24日

import java.util.Map;
import java.util.Map.Entry;

import com.sgcc.uap.share.domain.ElectricianInfo;
import com.sgcc.uap.share.domain.ElectricianSubCompanyInfo;

public class MapGetValueUtil {
	
	/**
	 * 返回集合中的第一个值
	 */
	
	public static ElectricianSubCompanyInfo getFirstOrNull(Map<Double, ElectricianSubCompanyInfo> map) {
		ElectricianSubCompanyInfo obj = null;
        for (Entry<Double, ElectricianSubCompanyInfo> entry : map.entrySet()) {
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
