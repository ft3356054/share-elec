package com.sgcc.uap.share.customer.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sgcc.uap.share.domain.OrderAuditElectrician;


/**
 * <b>概述</b>：<br>
 *	TODO
 * <p>
 * <b>功能</b>：<br>
 *	TODO
 *	
 * @author 18511
 */
public interface GetOrderAuditElectricianRepository extends JpaRepository<OrderAuditElectrician,String>,JpaSpecificationExecutor<OrderAuditElectrician> {

	public int countByElectricianIdAndOrderStatusIn(String electricianId,Collection<String> orderStatus);
}
