package com.user.jwt.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.user.jwt.Entity.User;
import com.user.jwt.Repository.UserRepo;

@Service
public class CustomUserDetailService implements UserDetailsService {
    // LOADING USER FROM DATABASE BY USERNAME
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = this.userRepo.findByEmail(email).orElseThrow();
        return user;
    }
}