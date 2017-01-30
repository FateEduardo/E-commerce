package com.softtek.academy.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.softtek.academy.domain.User;


public class LoginServiceImpl implements UserDetailsService {

	@Autowired
	UserService userService;
	

    
	@Override
	public UserDetails loadUserByUsername(String ssoId) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		User user =userService.findOne(ssoId);
		if(user==null){
			//System.out.println(username);
			throw new UsernameNotFoundException("Username not found");
		}
		 boolean accountNonExpired = true;
		    boolean credentialsNonExpired = true;
		    boolean accountNonLocked = true;

		    return new org.springframework.security.core.userdetails.User(
		    		user.getUsername(),
		    		user.getPassword().toLowerCase(),
		    		user.getStatus(),
		            accountNonExpired,
		            credentialsNonExpired,
		            accountNonLocked,
		            getGrantedAuthorities(user));
	}
	
	private List<GrantedAuthority> getGrantedAuthorities(User user){
		final String role=roleValid(user.getRole().getId());
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority(role));
        return authorities;
    }
	private String roleValid(String role){
		if(role.equals("ROLE_ADMIN")){
			return "ROLE_ADMIN";
		}
		return "OTHER_ROLE";
	}

}
