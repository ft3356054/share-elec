package com.sgcc.uap.share.customer.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgcc.uap.share.customer.repositories.GetOrderElectricianRepository;
import com.sgcc.uap.share.customer.services.IGetOrderElectricianService;
import com.sgcc.uap.share.domain.OrderElectrician;





@Service
public class GetOrderElectricianService implements IGetOrderElectricianService{
	/** 
     * 日志
     */
	private final static Logger logger = (Logger) LoggerFactory.getLogger(GetOrderElectricianService.class);
	
	@Autowired
	private GetOrderElectricianRepository orderElectricianRepository;
	 
	@Override
	public List<OrderElectrician> findByOrderElectricianType(String orderElectricianType, String pastTime){
		List<OrderElectrician> list = orderElectricianRepository.findByOrderElectricianType(orderElectricianType,pastTime);
		return list;
	}
}

	
	
	

	
	
	
	
	
	

