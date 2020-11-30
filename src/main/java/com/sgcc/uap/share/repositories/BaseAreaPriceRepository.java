package com.sgcc.uap.share.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sgcc.uap.share.domain.BaseAreaPrice;


/**
 * <b>概述</b>：<br>
 *	TODO
 * <p>
 * <b>功能</b>：<br>
 *	TODO
 *	
 * @author 18511
 */
public interface BaseAreaPriceRepository extends JpaRepository<BaseAreaPrice,String>,JpaSpecificationExecutor<BaseAreaPrice> {
	//查询树子节点
	public List<BaseAreaPrice> findByProvinceId(String provinceId);
	
}
