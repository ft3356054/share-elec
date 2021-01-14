package com.sgcc.uap.share.electrician.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sgcc.uap.share.domain.ElectricianCompanyInfo;


/**
 * <b>概述</b>：<br>
 *	TODO
 * <p>
 * <b>功能</b>：<br>
 *	TODO
 *	
 * @author 18511
 */
public interface ElectricianCompanyInfoRepository extends JpaRepository<ElectricianCompanyInfo,String>,JpaSpecificationExecutor<ElectricianCompanyInfo> {

	@Query(value = "SELECT * FROM Electrician_Company_Info WHERE company_Name like %:companyName%  "
			+ " and company_Level =:companyLevel and regiseter_Time between :regiseterTimeBegin and :regiseterTimeEnd "
			+ " limit :pageIndex,:pageSize",
			nativeQuery = true)
	List<ElectricianCompanyInfo> queryMore(@Param("pageIndex")int pageIndex,@Param("pageSize")int pageSize,
			@Param("companyName")String companyName,@Param("companyLevel")String companyLevel,
			@Param("regiseterTimeBegin")String regiseterTimeBegin,@Param("regiseterTimeEnd")String regiseterTimeEnd);

	@Query(value="select * from Electrician_Company_Info where COMPANY_AREA_ID=?")
	List<ElectricianCompanyInfo> findByCompanyAreaId(String areaId);
	
}
