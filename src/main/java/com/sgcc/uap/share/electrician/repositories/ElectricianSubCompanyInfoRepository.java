package com.sgcc.uap.share.electrician.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sgcc.uap.share.domain.ElectricianSubCompanyInfo;


/**
 * <b>概述</b>：<br>
 *	TODO
 * <p>
 * <b>功能</b>：<br>
 *	TODO
 *	
 * @author 18511
 */
public interface ElectricianSubCompanyInfoRepository extends JpaRepository<ElectricianSubCompanyInfo,String>,JpaSpecificationExecutor<ElectricianSubCompanyInfo> {

	
}
