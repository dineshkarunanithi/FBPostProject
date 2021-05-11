package com.socialmediapost.fb.repository;

import org.springframework.data.repository.CrudRepository;

import com.socialmediapost.fb.dao.UserPages;

public interface UserPageRepository extends CrudRepository<UserPages, String> {

	public UserPages findByUserId(String userId);
}
