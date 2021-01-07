package com.sgcc.uap.share.customer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sgcc.uap.share.domain.OrderElectrician;


/**
 * <b>概述</b>：<br>
 *	TODO
 * <p>
 * <b>功能</b>：<br>
 *	TODO
 *	
 * @author 18511
 */
public interface GetElectricianInfoRepository extends JpaRepository<OrderElectrician,String>,JpaSpecificationExecutor<OrderElectrician> {
	
	public Integer countByElectricianId(String electricianId);
	
	
}
