package io.github.andrepestana.chatroom.service;

import java.util.List;

import io.github.andrepestana.chatroom.model.ApplicationUser;

public interface ApplicationUserService {

	List<ApplicationUser> getAll();

	ApplicationUser getById(Long id);

	void save(ApplicationUser applicationUser);

}
