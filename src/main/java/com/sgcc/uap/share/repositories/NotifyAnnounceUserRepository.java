package com.sgcc.uap.share.repositories;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
	
	public NotifyAnnounceUser findByAnnounceUserIdAndAnnounceId(String announceUserId,String announceId);

	public Long countByAnnounceUserIdAndState(String announceUserId,String state);
	
	@Transactional
	@Query(value = "INSERT INTO NOTIFY_ANNOUNCE_USER_HIS SELECT * FROM NOTIFY_ANNOUNCE_USER WHERE ANNOUNCE_ID IN :orderIds  ",
			nativeQuery = true)
	@Modifying
	public void insertToHis(@Param("orderIds")Collection<String> orderIds);
	
	@Query(value = "DELETE FROM NOTIFY_ANNOUNCE_USER WHERE ANNOUNCE_ID IN :orderIds  ",
			nativeQuery = true)
	@Modifying
	@Transactional
	public void deleteNowTable(@Param("orderIds")Collection<String> orderIds);
}
