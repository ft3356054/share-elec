package com.sgcc.uap.share.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sgcc.uap.share.domain.AuthorityUser;


/**
 * <b>概述</b>：<br>
 *	TODO
 * <p>
 * <b>功能</b>：<br>
 *	TODO
 *	
 * @author 18511
 */
public interface AuthorityUserRepository extends JpaRepository<AuthorityUser,String>,JpaSpecificationExecutor<AuthorityUser> {

	public AuthorityUser findByUserAccountAndUserPsw(String userAccount, String userPsw);
	
	public AuthorityUser findByUserAccount(String userAccount);
}
