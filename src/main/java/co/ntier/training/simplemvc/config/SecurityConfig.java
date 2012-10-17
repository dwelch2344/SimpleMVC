package co.ntier.training.simplemvc.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;

@Configuration
@ImportResource("/WEB-INF/config/security.xml")
public class SecurityConfig {

	// ***** Stub Code that you should replace! ***********************************
	
	private static List<? extends GrantedAuthority> defaultAuthorities = Arrays.asList( new SimpleGrantedAuthority("ROLE_USER") );
	private static User user = new User("default", BCrypt.hashpw("password", BCrypt.gensalt()), defaultAuthorities);
	
	private UserDetailsService userDetailsService = new UserDetailsService() {
		@Override
		public UserDetails loadUserByUsername(String username)
				throws UsernameNotFoundException {
			if (user.getUsername().equalsIgnoreCase( username )) {
				return user;
			}
			throw new UsernameNotFoundException("Could not find " + username);
		}
	};
	
	// ************ End Stub code ***************************************
	
	@Bean(name = "org.springframework.security.authenticationManager")
	public ProviderManager providerManager() {
		List<AuthenticationProvider> providers = new ArrayList<AuthenticationProvider>();
		providers.add(provider());
		return new ProviderManager(providers);
	}

	private DaoAuthenticationProvider provider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(new BcryptPasswordEncoder());
		return provider;
	}
	
	private class BcryptPasswordEncoder implements PasswordEncoder {

		@Override
		public boolean isPasswordValid(String encPass, String rawPass,
				Object saltObject) {
			return BCrypt.checkpw(rawPass, encPass);
		}

		@Override
		public String encodePassword(String rawPass, Object salt) {
			return rawPass;
		}
	}

}