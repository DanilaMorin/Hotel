package com.netcracker.security;

import com.netcracker.DAO.entity.Client;
import com.netcracker.exception.EntityNotFound;
import com.netcracker.exception.FatalError;
import com.netcracker.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;




@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	private ClientService userService;
	
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String ssoId)
			throws UsernameNotFoundException {
		Client user = null;
		try {
			user = userService.getClientById(ssoId);
		} catch (FatalError fatalError) {
			fatalError.printStackTrace();
		}
		catch (EntityNotFound entityNotFound) {
			entityNotFound.printStackTrace();
		}

		if(user==null){

			throw new UsernameNotFoundException("Username not found");
		}
			return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(),
				 true, true, true, true, getGrantedAuthorities(user));
	}

	
	private List<GrantedAuthority> getGrantedAuthorities(Client user){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();


		authorities.add(new SimpleGrantedAuthority("ROLE_"+"ADMIN"));
		return authorities;
	}
	
}
