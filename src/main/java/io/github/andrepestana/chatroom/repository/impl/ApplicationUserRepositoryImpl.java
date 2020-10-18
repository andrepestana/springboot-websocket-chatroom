package io.github.andrepestana.chatroom.repository.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import io.github.andrepestana.chatroom.model.ApplicationUser;
import io.github.andrepestana.chatroom.repository.ApplicationUserRepository;

/*
 * Fake persistence
 */
@Component("userRepository")
public class ApplicationUserRepositoryImpl implements ApplicationUserRepository {
	
	private Set<ApplicationUser> applicationUsers = new HashSet<ApplicationUser>(); //{{ add(new ApplicationUser(0L, "admin", "$2y$12$3.EH1aA4Byk26ty785hYQe2sxGZfHqpMTnSMMpkUnfzt5h2PpVahK"));}} ;
	private Long idSeq = 1L;
	
	@Override
	public ApplicationUser findByUsername(String username) {
		return applicationUsers.stream().filter(au -> au.getUsername().equals(username)).findFirst().orElse(null);
	}

	@Override
	public ApplicationUser findById(Long id) {
		return applicationUsers.stream().filter(au -> au.getId().equals(id)).findFirst().orElse(null);
	}
	
	@Override
	public void save(ApplicationUser user) {
		if(user.getId() != null) {
			ApplicationUser au = findById(user.getId());
			if(au != null) {
				au = user;
			} else {
				user.setId(idSeq);
				idSeq++;
				applicationUsers.add(user);
			}
			
		} else {
			user.setId(idSeq);
			idSeq++;
			applicationUsers.add(user);
		}
	}

	@Override
	public List<ApplicationUser> findAll() {
		List<ApplicationUser> applicationUsersWithoutSensitiveData = applicationUsers.stream().collect(Collectors.toList());
		applicationUsersWithoutSensitiveData.stream().forEach(u -> new ApplicationUser(u.getId(), u.getUsername(), null));
		return applicationUsersWithoutSensitiveData;
	}
	
	
}
