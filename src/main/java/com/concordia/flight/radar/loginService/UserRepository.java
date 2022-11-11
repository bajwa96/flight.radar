package com.concordia.flight.radar.loginService;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.concordia.flight.radar.pojo.User;

public interface UserRepository extends CrudRepository<User, Long> {

	@Query("FROM User u WHERE u.username = :username and u.isDeleted=0")
	public User getUserByUsername(@Param("username") String username);
}
