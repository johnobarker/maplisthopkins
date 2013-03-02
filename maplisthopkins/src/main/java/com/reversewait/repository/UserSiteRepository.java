package com.reversewait.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;

import com.reversewait.domain.UserSite;


@RepositoryDefinition(domainClass = UserSite.class, idClass = String.class)
public interface UserSiteRepository {
	UserSite save(UserSite userSite);
	
	@Query(fields = "{'contactPassword': 0}")	
	UserSite findBySiteName(String siteName);
	
	@Query(fields = "{'contactPassword': 0}")	
	UserSite findOne(String primaryKey);
	
	@Query(fields = "{'contactPassword': 0}")	
	List<UserSite> findAll();
	
	@Query(value = "{'userId': ?0}", fields = "{'contactPassword': 0}")	
	List<UserSite> findByUserId(String userId);

	// filter out the password field
	@Query(value = "{}", fields = "{'contactPassword': 0 }")
	List<UserSite> getAll();
	
	Long count();
	
	@Query(value = "{'userId': ?0}")
	Long count(String userId);

	void delete(UserSite userSite);

	boolean exists(String id);	
}
