package com.socialmediapost.fb.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_page_management")
public class UserPages {

	@Id
	@Column(name="user_id")
	private String userId;
	
	@Column(name="page_id")
	private String pageId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
	}

	@Override
	public String toString() {
		return "UserPages [userId=" + userId + ", pageId=" + pageId + "]";
	}
	
	
	
}
