package com.reversewaut.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.ExceptionMappingAuthenticationFailureHandler;

import com.reversewait.domain.EventLog;
import com.reversewait.domain.EventType;
import com.reversewait.domain.ReverseWaitManagerEvent;


public class AuthenticationFailureHandler extends ExceptionMappingAuthenticationFailureHandler {
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
		EventLog el = new EventLog(EventType.EVENT_SECURITY, "Login Failure, reason: " + exception.getMessage());
		el.setActor("Administrator - auto generated");
		publisher.publishEvent(new ReverseWaitManagerEvent(this, el));
		this.setDefaultFailureUrl("/rmLogin?login_error=" + exception.getMessage());
		super.onAuthenticationFailure(request, response, exception);					
	}
}
