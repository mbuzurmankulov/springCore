package com.epam.spring.core.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class Client implements Serializable{
	private String id;
	private String fullName;
	private String greeting;
	
	public Client(String id, String fullName) {
		this.id = id;
		this.fullName = fullName;
	}
}
