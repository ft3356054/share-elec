package com.sgcc.uap.share.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sgcc.uap.share.domain.BaseIdentityPrice;


/**
 * <b>概述</b>：<br>
 *	TODO
 * <p>
 * <b>功能</b>：<br>
 *	TODO
 *	
 * @author 18511
 */
public interface BaseIdentityPriceRepository extends JpaRepository<BaseIdentityPrice,String>,JpaSpecificationExecutor<BaseIdentityPrice> {

	
}
