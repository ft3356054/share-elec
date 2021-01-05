package com.sgcc.uap.share.customer.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgcc.uap.share.customer.repositories.GetOrderElectricianRepository;
import com.sgcc.uap.share.customer.services.IGetOrderElectricianService;
import com.sgcc.uap.share.domain.OrderElectrician;
import com.sgcc.uap.util.MapUtil;
import com.sgcc.uap.util.TimeStamp;





@Service
public class GetOrderElectricianService implements IGetOrderElectricianService{
	/** 
     * 日志
     */
	private final static Logger logger = (Logger) LoggerFactory.getLogger(GetOrderElectricianService.class);
	
	@Autowired
	private GetOrderElectricianRepository orderElectricianRepository;
	@Autowired
	private OrderFlowService orderFlowService;
	 
	@Override
	public List<OrderElectrician> findByOrderElectricianStatus(String orderElectricianStatus, String pastTime){
		List<OrderElectrician> list = orderElectricianRepository.findByOrderElectricianStatus(orderElectricianStatus,pastTime);
		return list;
	}

	@Override
	public OrderElectrician updateOrderElectricianStatus(OrderElectrician orderElectrician) {
		OrderElectrician result = orderElectricianRepository.save(orderElectrician);
		//新增流水
		Map<String,Object> mapOrderFlow =  MapUtil.flowAdd(orderElectrician.getOrDERId(), 2,  1 , "SYSTEM", TimeStamp.toString(new Date()), 1,  "派单，电工未接受");
		try {
			orderFlowService.saveOrderFlow(mapOrderFlow);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}

	
	
	

	
	
	
	
	
	

