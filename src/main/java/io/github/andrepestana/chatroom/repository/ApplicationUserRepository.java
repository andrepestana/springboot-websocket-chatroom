package io.github.andrepestana.chatroom.repository;

import java.util.List;

import io.github.andrepestana.chatroom.model.ApplicationUser;

public interface ApplicationUserRepository {

	ApplicationUser findByUsername(String username);

	void save(ApplicationUser user) ;

	List<ApplicationUser> findAll();

	ApplicationUser findById(Long id);
}
