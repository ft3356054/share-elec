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
	
	@Query(value = "SELECT na.ANNOUNCE_ID,na.SERDER_ID,na.TITLE,na.CONTENT,na.NOTIFY_TYPE,nau.ORDER_ID,na.REMARK,"
			+ " nau.ANNOUNCE_USER_ID,nau.STATE,nau.READ_TIME,nau.CREATE_TIME FROM notify_announce_user nau "
			+ " LEFT JOIN NOTIFY_ANNOUNCE na ON nau.ANNOUNCE_ID = na.ANNOUNCE_ID "
			+ " WHERE nau.ANNOUNCE_USER_ID = :userId  "
			+ " AND IF(:status !='2',nau.STATE = :status,1=1) "
			+ " ORDER BY nau.CREATE_TIME DESC "
			+ " LIMIT :pageIndex,:pageSize  ",
			nativeQuery = true)
	public List<NotifyAnnounceAndUser> findByAnnounceUserIdDesc(@Param("pageIndex")Integer pageIndex,@Param("pageSize")Integer pageSize,
			@Param("userId")String userId,@Param("status")String status);
	
	
	
}
