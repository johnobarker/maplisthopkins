package com.reversewaut.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.reversewait.domain.EventLog;
import com.reversewait.domain.EventType;
import com.reversewait.domain.ReverseWaitManagerEvent;
import com.reversewait.domain.User;
import com.reversewait.service.UserService;

public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	@Autowired
	private ApplicationEventPublisher publisher;

	@Autowired
	private UserService userService;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException  {
		User thisUser = userService.findByUserName(authentication.getName());
		EventLog el = new EventLog(EventType.EVENT_SECURITY, "logged in as " + thisUser.getUserName());
		el.setActor(thisUser.getUserName());
		publisher.publishEvent(new ReverseWaitManagerEvent(this, el));
		super.onAuthenticationSuccess(request, response, authentication);
	}
}
