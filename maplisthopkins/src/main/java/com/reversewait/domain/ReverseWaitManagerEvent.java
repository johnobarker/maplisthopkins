package com.reversewait.domain;

import java.util.Date;

import org.springframework.context.ApplicationEvent;

public class ReverseWaitManagerEvent extends ApplicationEvent{

	private EventLog eventLog;
	private static final long serialVersionUID = 1L;

	public ReverseWaitManagerEvent(Object source, EventLog eventLog) {
		super(source);
		Date eventDate = new Date(this.getTimestamp());
		eventLog.setLogDate(eventDate);
		this.eventLog = eventLog;
	}

	public EventLog getEventLog() {
		return eventLog;
	}

	public void setEventLog(EventLog eventLog) {
		this.eventLog = eventLog;
	}

}
