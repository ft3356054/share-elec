package com.sgcc.uap.share.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sgcc.uap.share.domain.BaseIdentityDetail;


/**
 * <b>概述</b>：<br>
 *	TODO
 * <p>
 * <b>功能</b>：<br>
 *	TODO
 *	
 * @author 18511
 */
public interface BaseIdentityDetailRepository extends JpaRepository<BaseIdentityDetail,String>,JpaSpecificationExecutor<BaseIdentityDetail> {

	
}
