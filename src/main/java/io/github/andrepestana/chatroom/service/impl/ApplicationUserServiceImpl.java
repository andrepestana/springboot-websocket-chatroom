package io.github.andrepestana.chatroom.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.andrepestana.chatroom.exception.InvalidSubmittedDataException;
import io.github.andrepestana.chatroom.exception.ResourceAlreadyInUseException;
import io.github.andrepestana.chatroom.exception.ResourceNotFoundException;
import io.github.andrepestana.chatroom.model.ApplicationUser;
import io.github.andrepestana.chatroom.repository.ApplicationUserRepository;
import io.github.andrepestana.chatroom.service.ApplicationUserService;

@Service
public class ApplicationUserServiceImpl implements ApplicationUserService {

	@Autowired
	private ApplicationUserRepository applicationUserRepository;
	
	@Override
	public List<ApplicationUser> getAll() {
		return applicationUserRepository.findAll();
	}

	@Override
	public ApplicationUser getById(Long id) {
		ApplicationUser applicationUser = applicationUserRepository.findById(id);
		if(applicationUser == null) {
			throw new ResourceNotFoundException("Could not find any user with id: "+id);
		}
		return applicationUser;
	}

	@Override
	public void save(ApplicationUser applicationUser) {
		if(applicationUser.getUsername() == null) {
			throw new InvalidSubmittedDataException("The username is required");
		} else if(applicationUserRepository.findByUsername(applicationUser.getUsername()) != null) {
			throw new ResourceAlreadyInUseException("Username already in use");
		}
		applicationUserRepository.save(applicationUser);
	}

}
