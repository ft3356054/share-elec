package com.sgcc.uap.share.electrician.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sgcc.uap.share.domain.ElecPosition;
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
public interface ElecPositionRepository extends JpaRepository<ElecPosition,String>,JpaSpecificationExecutor<ElecPosition> {
	public List<ElecPosition> findByAreaId(String areaId);

	public ElecPosition findByElectricianId(String electricianId);

	public List<ElectricianInfo> findByElectricianName(String electricianName);
	
}
