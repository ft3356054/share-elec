package com.sgcc.uap.share.electrician.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
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
public interface ElectricianInfoRepository extends JpaRepository<ElectricianInfo,String>,JpaSpecificationExecutor<ElectricianInfo> {

	@Query(value="select * from electrician_info where ELECTRICIAN_ID = ?",nativeQuery=true)
	List<ElectricianInfo> queryElectricianInfo(String electricianId);

	@Query(value="select * from electrician_info where ELECTRICIAN_PHONENUMBER=?",nativeQuery=true)
	ElectricianInfo findByElectricianPhonenumber(String telephone);

	
	@Query(value="select * from electrician_info where COMPANY_NAME =:companyName and ELECTRICIAN_STATUS=1",nativeQuery=true)
	List<ElectricianInfo> findBycompanyName(@Param("companyName")String companyName);
	
	@Query(value="select * from electrician_info where ELECTRICIAN_NAME like %:electricianName% ",nativeQuery=true)
	List<ElectricianInfo> LikeElectricianName(@Param("electricianName")String electricianName);

	//@Query(value="select * from electrician_info where ELECTRICIAN_PHONENUMBER = %electricianPhonenumber%",nativeQuery=true)
	List<ElectricianInfo> findByElectricianPhonenumberLike(@Param("electricianPhonenumber")String electricianPhonenumber);

	

	
}
