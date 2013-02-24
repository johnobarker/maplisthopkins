package com.reversewaut.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.reversewait.domain.EventLog;
import com.reversewait.domain.EventType;
import com.reversewait.domain.ReverseWaitManagerEvent;
import com.reversewait.domain.User;
import com.reversewait.repository.UserRepository;


@Component
public class RecipeUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;

	@Autowired
	private ApplicationEventPublisher publisher;

	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(userName);
		if (user == null) {
			String msg = "No user with username '" + userName + "' found!";
			EventLog el = new EventLog(EventType.EVENT_SECURITY, "Login Failure, reason: " + msg);
			el.setActor("Administrator - auto generated");
			publisher.publishEvent(new ReverseWaitManagerEvent(this, el));
            throw new UsernameNotFoundException(msg);
		}
		
		return new RecipeUserDetails(user);
	}
}
