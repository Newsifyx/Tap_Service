package com.newsify.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name=CityORM.TABLE)
public class City extends CityORM{

	public City() {
		
	}
}
