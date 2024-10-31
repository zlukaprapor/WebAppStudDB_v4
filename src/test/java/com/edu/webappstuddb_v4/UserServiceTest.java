package com.edu.webappstuddb_v4;

import com.edu.webappstuddb_v4.models.User;
import com.edu.webappstuddb_v4.models.emums.Role;
import com.edu.webappstuddb_v4.repositories.UserRepository;
import com.edu.webappstuddb_v4.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateUser_UserAlreadyExists() {
        User user = new User();
        user.setEmail("test@example.com");

        when(userRepository.findByEmail(user.getEmail())).thenReturn(user);

        boolean result = userService.createUser(user);

        assertFalse(result, "Користувач вже існує");
        verify(userRepository, never()).save(user);
    }

    @Test
    void testCreateUser_NewUser() {
        User user = new User();
        user.setEmail("new@example.com");
        user.setPassword("password");

        when(userRepository.findByEmail(user.getEmail())).thenReturn(null);
        when(passwordEncoder.encode(user.getPassword())).thenReturn("encodedPassword");

        boolean result = userService.createUser(user);

        assertTrue(result, "Користувач повинен бути створений");
        assertEquals("encodedPassword", user.getPassword());
        assertTrue(user.isActive());
        assertTrue(user.getRoles().contains(Role.ROLE_USER));
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testBanUser_UserNotFound() {
        Long userId = 1L;

        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        userService.banUser(userId);

        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void testBanUser_UserExists() {
        User user = new User();
        user.setId(1L);
        user.setEmail("test@example.com");
        user.setActive(true);

        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));

        userService.banUser(user.getId());

        assertFalse(user.isActive(), "Користувач має бути деактивований");
        verify(userRepository, times(1)).save(user);
    }
}

