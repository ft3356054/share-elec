package com.sgcc.uap.share.electrician.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

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

	List<ElectricianSubCompanyInfo> findByCompanyNameLike(String string);

	/**
	 * 查询营业中的电力子公司
	 * @param areaId
	 * @return
	 */
	@Query(value="select * from electrician_sub_company_info where COMPANY_AREA_ID=? and BUSINESS_STATUS=0",nativeQuery=true)
	List<ElectricianSubCompanyInfo> findByCompanyAreaId(String areaId);

	//@Query(value="select * from electrician_sub_company_info where COMPANY_NAME like '%?%'",nativeQuery=true)
	//List<ElectricianSubCompanyInfo> findByCompanyNameLike(String companyName);

	
}
