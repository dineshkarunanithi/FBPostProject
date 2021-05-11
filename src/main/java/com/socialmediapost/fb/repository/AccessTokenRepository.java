package com.socialmediapost.fb.repository;

import org.springframework.data.repository.CrudRepository;

import com.socialmediapost.fb.dao.AccessTokens;

public interface AccessTokenRepository extends CrudRepository<AccessTokens, String> {

	public AccessTokens findByUserId(String userId);
	
}
