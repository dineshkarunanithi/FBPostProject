package com.socialmediapost.fb.repository;

import org.springframework.data.repository.CrudRepository;

import com.socialmediapost.fb.dao.AppInfo;

public interface AppInfoRepository extends CrudRepository<AppInfo, String> {

	public AppInfo findByAppName(String appName);
	
}
