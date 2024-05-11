package com.coderhack.coderhack.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.coderhack.coderhack.entity.User;
import com.coderhack.coderhack.repository.UserRepository;
import com.coderhack.coderhack.services.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testGetAllUsers() {
        List<User> userList = Arrays.asList(
                new User("1", "user1", 50, new HashSet<>()),
                new User("2", "user2", 30, new HashSet<>())
        );
        Mockito.when(userRepository.findAll()).thenReturn(userList);

        List<User> result = userService.getAllUsers();

        assertEquals(userList.size(), result.size());
        assertEquals(userList.get(0), result.get(0));
        assertEquals(userList.get(1), result.get(1));
    }

    // Add more test cases for other methods like getUserById, registerUser, updateScore, and deleteUser
}
