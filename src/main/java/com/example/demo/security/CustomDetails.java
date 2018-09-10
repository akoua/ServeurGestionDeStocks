package com.example.demo.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class CustomDetails implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUsername(username);
		//on les crée nous même
		boolean accountNonExpired = true; 
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		
		UserDetails userDetail = new org.springframework.security.core.userdetails.User(
				username, 
				user.getPassword(), 
				user.isEnable(), 
				accountNonExpired, 
				credentialsNonExpired, 
				accountNonLocked, 
				getAuthorities(user.getRoles()));
		
		return userDetail;
	}
	
	private Collection<GrantedAuthority> getAuthorities(List<Role> roles) {
		Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		 roles.forEach(r ->{
			 grantedAuthorities.add(new SimpleGrantedAuthority(r.getLibelle()));
		 });
		
		 return grantedAuthorities;
	}

}
