package co.ntier.training.simplemvc.svc;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import co.ntier.training.simplemvc.model.SimpleUser;

public interface UserService extends UserDetailsService{

	SimpleUser create(String name, String email, String password);

	List<SimpleUser> findAll();

	UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException;

}