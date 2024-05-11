package com.coderhack.coderhack.controller;

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
import com.coderhack.coderhack.services.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    public void testGetAllUsers() {
        List<User> userList = Arrays.asList(
                new User("1", "user1", 50, new HashSet<>()),
                new User("2", "user2", 30, new HashSet<>())
        );
        Mockito.when(userService.getAllUsers()).thenReturn(userList);

        List<User> result = userController.getAllUsers();

        assertEquals(userList.size(), result.size());
        assertEquals(userList.get(0), result.get(0));
        assertEquals(userList.get(1), result.get(1));
    }

    // Add more test cases for other methods like getUserById, registerUser, updateScore, and deleteUser
}