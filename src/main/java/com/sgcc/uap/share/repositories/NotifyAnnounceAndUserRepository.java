package com.sgcc.uap.share.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sgcc.uap.share.customer.bo.NotifyAnnounceAndUser;
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
public interface NotifyAnnounceAndUserRepository extends JpaRepository<NotifyAnnounceAndUser,String>,JpaSpecificationExecutor<NotifyAnnounce> {
	@Query(value = "SELECT na.*,nau.ANNOUNCE_USER_ID,nau.STATE,nau.READ_TIME FROM notify_announce_user nau "
			+ " LEFT JOIN NOTIFY_ANNOUNCE na ON nau.ANNOUNCE_ID = na.ANNOUNCE_ID "
			+ " WHERE nau.ANNOUNCE_USER_ID = :ids  ",
			nativeQuery = true)
	public List<NotifyAnnounceAndUser> findByAnnounceUserId(@Param("ids")String ids);
	
}
