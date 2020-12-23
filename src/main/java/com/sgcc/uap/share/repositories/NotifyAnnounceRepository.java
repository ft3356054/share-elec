package com.sgcc.uap.share.repositories;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
	
	@Query(value = "SELECT * FROM NOTIFY_ANNOUNCE T  "
			+ " WHERE DATE_SUB(CURDATE(), INTERVAL :day DAY) >= T.CREATE_TIME  ",
			nativeQuery = true)
	public List<NotifyAnnounce> findFinishNotify(@Param("day")String day);
	
	@Transactional
	@Query(value = "INSERT INTO NOTIFY_ANNOUNCE_HIS SELECT * FROM NOTIFY_ANNOUNCE WHERE ANNOUNCE_ID IN :orderIds  ",
			nativeQuery = true)
	@Modifying
	public void insertToHis(@Param("orderIds")Collection<String> orderIds);
	
	@Query(value = "DELETE FROM NOTIFY_ANNOUNCE WHERE ANNOUNCE_ID IN :orderIds  ",
			nativeQuery = true)
	@Modifying
	@Transactional
	public void deleteNowTable(@Param("orderIds")Collection<String> orderIds);
	
	
	
}
