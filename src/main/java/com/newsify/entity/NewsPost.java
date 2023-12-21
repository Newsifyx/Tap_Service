package com.newsify.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name=NewsPostORM.TABLE)
public class NewsPost extends NewsPostORM{

	public NewsPost() {
		
	}
}
