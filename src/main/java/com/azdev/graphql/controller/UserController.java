package com.azdev.graphql.controller;

import com.azdev.graphql.dto.UserRequest;
import com.azdev.graphql.dto.UserResponse;
import com.azdev.graphql.model.User;
import com.azdev.graphql.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @QueryMapping
    List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @MutationMapping
    User createUser(@Argument UserRequest userRequest){
        return userService.createUser(userRequest);
    }

    @QueryMapping
    UserResponse getUserById(@Argument UUID id){
        return userService.getUserById(id);
    }
}
