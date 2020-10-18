package io.github.andrepestana.chatroom.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.user.SimpUser;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.andrepestana.chatroom.model.ApplicationUser;
import io.github.andrepestana.chatroom.service.ApplicationUserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
		
	@Autowired
	private ApplicationUserService applicationUserService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired private SimpUserRegistry simpUserRegistry;

	@GetMapping("")
	public List<ApplicationUser> getUser() throws Exception {
		return applicationUserService.getAll();
	}
	
	@GetMapping("/{id}")
	public ApplicationUser getUser(@PathVariable Long id) throws Exception {
		return applicationUserService.getById(id);
	}

	//TODO move it to another controller to follow API best practices
    @PostMapping("/sign-up")
    public void signUp(@RequestBody ApplicationUser applicationUser) {
        applicationUser.setPassword(bCryptPasswordEncoder.encode(applicationUser.getPassword()));
        applicationUserService.save(applicationUser);
    }
    
    //TODO get user in the chatroom
    public Set<SimpUser> getUsers() { 
        return simpUserRegistry.getUsers();
    }
}

