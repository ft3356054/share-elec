package com.sgcc.uap.share.electrician.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

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
public interface ElectricianInfoRepository extends JpaRepository<ElectricianInfo,String>,JpaSpecificationExecutor<ElectricianInfo> {

	@Query(value="select * from electrician_info where ELECTRICIAN_ID = ?",nativeQuery=true)
	List<ElectricianInfo> queryElectricianInfo(String electricianId);

	@Query(value="select * from electrician_info where ELECTRICIAN_PHONENUMBER=?",nativeQuery=true)
	ElectricianInfo findByElectricianPhonenumber(String telephone);

	
}
