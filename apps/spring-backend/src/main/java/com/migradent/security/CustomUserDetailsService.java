package com.migradent.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    // In-memory user store (for MVP; replace with database query later)
    private static final Map<String, UserDetail> users = new HashMap<>();

    static {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        users.put("admin", new UserDetail("admin", encoder.encode("admin123"), "ADMIN"));
        users.put("clinician", new UserDetail("clinician", encoder.encode("clinician123"), "USER"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetail userDetail = users.get(username);
        if (userDetail == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        return new CustomUserDetails(userDetail.username, userDetail.password, userDetail.role);
    }

    private static class UserDetail {
        String username;
        String password;
        String role;

        UserDetail(String username, String password, String role) {
            this.username = username;
            this.password = password;
            this.role = role;
        }
    }
}
