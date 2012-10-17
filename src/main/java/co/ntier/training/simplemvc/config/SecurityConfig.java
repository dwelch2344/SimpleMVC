package co.ntier.training.simplemvc.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

@Configuration
@ImportResource("/WEB-INF/config/security.xml")
public class SecurityConfig {

        @Bean(name="org.springframework.security.authenticationManager")
        public ProviderManager providerManager(){
                List<AuthenticationProvider> providers = new ArrayList<AuthenticationProvider>();
                providers.add( new UsernamePasswordAuthenticationProvider("default", "password", "ROLE_DEFAULT"));
                return new ProviderManager( providers );
        }
 
        
        public static class UsernamePasswordAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
            
            private final String user, password, role;
            
            public UsernamePasswordAuthenticationProvider(String user, String password, String role) {
                    super();
                    this.user = user;
                    this.password = password;
                    this.role = role;
            }

            @Override
            protected UserDetails retrieveUser(String username,
                            UsernamePasswordAuthenticationToken auth)
                            throws AuthenticationException {
                    
                    String password = (String) auth.getCredentials();
                    if( this.user.equalsIgnoreCase(username) && this.password.equals(password)){
                            return new User( this.user, this.password, Arrays.asList(new SimpleGrantedAuthority( this.role )) );
                    }
                    
                    throw new BadCredentialsException("Invalid account details");
                    
            }
            
            @Override
            protected void additionalAuthenticationChecks(UserDetails userDetails,
                            UsernamePasswordAuthenticationToken authentication)
                            throws AuthenticationException {
                    
            }

    }
}