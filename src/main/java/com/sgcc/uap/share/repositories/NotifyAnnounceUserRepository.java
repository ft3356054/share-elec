package com.sgcc.uap.share.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sgcc.uap.share.domain.NotifyAnnounceUser;


/**
 * <b>概述</b>：<br>
 *	TODO
 * <p>
 * <b>功能</b>：<br>
 *	TODO
 *	
 * @author 18511
 */
public interface NotifyAnnounceUserRepository extends JpaRepository<NotifyAnnounceUser,String>,JpaSpecificationExecutor<NotifyAnnounceUser> {

	public List<NotifyAnnounceUser> findByAnnounceUserId(String announceUserId);
	
}
