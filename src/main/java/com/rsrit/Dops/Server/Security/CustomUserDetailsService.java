package com.rsrit.Dops.Server.Security;

/**
 * @author gn.teja created on 02/23/2017
 *
 */

import java.util.Arrays;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rsrit.Dops.Server.Model.UserModel.DataOps_User;
import com.rsrit.Dops.Server.Repository.UserRepository;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {
	
	 private static final String ROLE_USER = "ROLE_USER";
	 
	 @Autowired
	  private UserRepository repository;
	 
	  public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
	        final DataOps_User user = repository.findByUserEmail(email);
	        
	        if (user == null) {
	            throw new UsernameNotFoundException("No user found with username: " + email);
	        }
	        return new org.springframework.security.core.userdetails.User(user.getUserEmail(), user.getPassword(), true, true, true, true, getAuthorities(ROLE_USER));
	    }
	
	private Collection<? extends GrantedAuthority> getAuthorities(String role) {
        return Arrays.asList(new SimpleGrantedAuthority(role));
    }

}
