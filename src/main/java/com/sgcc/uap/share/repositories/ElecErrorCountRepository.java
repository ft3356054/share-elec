package com.sgcc.uap.share.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sgcc.uap.share.domain.ElecErrorCount;


/**
 * <b>概述</b>：<br>
 *	TODO
 * <p>
 * <b>功能</b>：<br>
 *	TODO
 *	
 * @author 18511
 */
public interface ElecErrorCountRepository extends JpaRepository<ElecErrorCount,String>,JpaSpecificationExecutor<ElecErrorCount> {

	public List<ElecErrorCount> findElecErrorCountByElectricianIdIn(List<String> electricianIdList);
	
	
	@Modifying
	@Query(value = "UPDATE Elec_Error_Count t SET t.FORBID_DAY =(:forbidDay+FORBID_DAY) "
			+ " WHERE t.ELECTRICIAN_ID IN :electricianIdListInDb "
	,nativeQuery = true)
	Integer updateElecErrorCounts1(@Param("electricianIdListInDb")List<String> electricianIdListInDb,@Param("forbidDay")int i);
	
	@Modifying
	@Query(value = "UPDATE Elec_Error_Count t SET t.FORBID_DAY =(:forbidDay+FORBID_DAY),t.BEGIN_TIME =:beginTime "
			+ " WHERE t.ELECTRICIAN_ID IN :electricianIdListInDb "
	,nativeQuery = true)
	Integer updateElecErrorCounts2(@Param("electricianIdListInDb")List<String> electricianIdListInDb,@Param("forbidDay")int forbidDay,@Param("beginTime")String beginTime);
	
	
	
	
	
}
