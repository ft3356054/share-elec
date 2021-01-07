package com.sgcc.uap.share.customer.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgcc.uap.share.customer.repositories.GetElectricianInfoRepository;
import com.sgcc.uap.share.customer.services.IGetElectricianInfoService;


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

}
