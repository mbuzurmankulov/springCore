package com.epam.spring.core;

import java.io.Serializable;

import lombok.Data;

@Data
public class Client implements Serializable{
	private String id;
	private String fullName;
	
	public Client(String id, String fullName) {
		this.id = id;
		this.fullName = fullName;
	}
}
