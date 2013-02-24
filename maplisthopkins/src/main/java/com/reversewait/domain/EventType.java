package com.reversewait.domain;

public enum EventType {
	EVENT_SECURITY ("Security"),
	EVENT_USER_ADMINISTATION ("User Admin"),
	EVENT_USER_CREATED("User created"),
	EVENT_USER_MODIFIED("User modified"),
	EVENT_USER_DELETED("User deleted"),
	EVENT_USER_SITE_ADMINISTRATION("User Site Admin"),
	EVENT_USER_SITE_CREATED("User created"),
	EVENT_USER_SITE_MODIFIED("User modified"),
	EVENT_USER_SITE_DELETED("User deleted");

	private final String type;
	
	private EventType(String type)		{this.type = type;}
	
	public String getType()				{return this.type;}
}
