package com.reversewaut.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.reversewait.domain.EventLog;
import com.reversewait.domain.EventType;
import com.reversewait.domain.ReverseWaitManagerEvent;
import com.reversewait.domain.User;
import com.reversewait.service.UserService;


public class AuthenticationLogoutSucessHandler extends AbstractAuthenticationTargetUrlRequestHandler implements LogoutSuccessHandler {
	@Autowired
	private ApplicationEventPublisher publisher;

	@Autowired
	private UserService userService;

	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		if (userService != null && authentication != null) {
			User thisUser = userService.findByUserName(authentication.getName());
			EventLog el = new EventLog(EventType.EVENT_SECURITY, "logged out as " + thisUser.getUserName());
			el.setActor(thisUser.getUserName());
			publisher.publishEvent(new ReverseWaitManagerEvent(this, el));
		}
		super.handle(request, response, authentication);
	}
}