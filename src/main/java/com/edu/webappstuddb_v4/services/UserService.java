package com.edu.webappstuddb_v4.services;

import com.edu.webappstuddb_v4.models.User;
import com.edu.webappstuddb_v4.models.emums.Role;
import com.edu.webappstuddb_v4.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
private final PasswordEncoder passwordEncoder;
    public boolean createUser(User user){
        String email = user.getEmail();
        if(userRepository.findByEmail(email)!= null) return false;
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(Role.ROLE_USER);
        log.info("Saving new User with email: {}", email);
        return true;
    }
}
