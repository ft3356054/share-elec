package com.sgcc.uap.share.customer.services.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgcc.uap.rest.utils.CrudUtils;
import com.sgcc.uap.share.customer.repositories.GetElectricianInfoRepository;
import com.sgcc.uap.share.customer.services.IGetElectricianInfoService;
import com.sgcc.uap.share.domain.ElectricianInfo;


/**
 * <b>概述</b>：<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author 18511
 */
@Service
public class GetElectricianInfoService implements IGetElectricianInfoService{
	@Autowired
	private GetElectricianInfoRepository getElectricianInfoRepository;
	
	@Override
	public boolean getElectricianInfoNumberByElectricianId(String electricianId) {
		boolean result = false;
		Integer number = getElectricianInfoRepository.countByElectricianId(electricianId);
		if(number>0){
			result = true;
		}
		return result;
	}

	@Override
	public ElectricianInfo getElectricianInfoByElectricianId(String electricianId) {
		ElectricianInfo electricianInfo = getElectricianInfoRepository.findOne(electricianId);
		return electricianInfo;
	}
	
	@Override
	public ElectricianInfo saveElectricianInfo(Map<String,Object> map) throws Exception{
		ElectricianInfo electricianInfo = new ElectricianInfo();
		if (map.containsKey("electricianId")) {
			String electricianId = (String) map.get("electricianId");
			electricianInfo = getElectricianInfoRepository.findOne(electricianId);
			CrudUtils.mapToObject(map, electricianInfo,  "electricianId");
		}else{
			CrudUtils.transMap2Bean(map, electricianInfo);
		}
		return getElectricianInfoRepository.save(electricianInfo);
	}
}
