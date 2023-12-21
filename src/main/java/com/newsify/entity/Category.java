package com.newsify.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name=CategoryORM.TABLE)
public class Category extends CategoryORM{
	
	public Category() {
		
	}

}
