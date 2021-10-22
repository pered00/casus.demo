package casus.casus.demo.security;

import java.util.Optional;

import casus.casus.demo.model.User;
import casus.casus.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {
	
	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = repository.findByUserName(username);
		if (user.isPresent()) {
			return user.get();
		}
		
		throw new UsernameNotFoundException("Wrong credentials!");
	}

}
