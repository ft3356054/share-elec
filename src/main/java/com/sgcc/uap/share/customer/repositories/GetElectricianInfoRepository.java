package com.sgcc.uap.share.customer.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sgcc.uap.share.domain.ElectricianInfo;


/**
 * <b>概述</b>：<br>
 *	TODO
 * <p>
 * <b>功能</b>：<br>
 *	TODO
 *	
 * @author 18511
 */
public interface GetElectricianInfoRepository extends JpaRepository<ElectricianInfo,String>,JpaSpecificationExecutor<ElectricianInfo> {
	
	public Integer countByElectricianId(String electricianId);
	
	@Modifying
	@Query(value = "UPDATE Electrician_Info t SET t.ELECTRICIAN_STATUS ='4' "
			+ " WHERE t.ELECTRICIAN_STATUS != '5' and ELECTRICIAN_ID in :electricianInfoIds "
	,nativeQuery = true)
	Integer updateElectricianInfo(@Param("electricianInfoIds")List<String> electricianInfoIds);
	
	public ElectricianInfo findElectricianInfoByOpenId(String openId);
	
	
	
}
