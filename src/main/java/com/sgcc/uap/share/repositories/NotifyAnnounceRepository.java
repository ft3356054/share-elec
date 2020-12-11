package com.sgcc.uap.share.repositories;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sgcc.uap.share.domain.NotifyAnnounce;


/**
 * <b>概述</b>：<br>
 *	TODO
 * <p>
 * <b>功能</b>：<br>
 *	TODO
 *	
 * @author 18511
 */
public interface NotifyAnnounceRepository extends JpaRepository<NotifyAnnounce,String>,JpaSpecificationExecutor<NotifyAnnounce> {
	public List<NotifyAnnounce> findByAnnounceIdIn(Collection<String> id);
	
}
