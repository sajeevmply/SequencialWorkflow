package com.sajeev.wf.constant;

public enum RequestType {
	
	LOGIN ("Login"),
	
	LOGOUT ("Logout"),
	
	SEARCH ("Search");
	
	private final String name;
	
	private RequestType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
