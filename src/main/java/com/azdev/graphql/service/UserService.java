package com.azdev.graphql.service;

import com.azdev.graphql.dto.UserRequest;
import com.azdev.graphql.dto.UserResponse;
import com.azdev.graphql.exception.UserNotFoundException;
import com.azdev.graphql.model.User;
import com.azdev.graphql.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(UserRequest userRequest) {
        return userRepository.save(User.builder()
                .email(userRequest.getEmail())
                .role(userRequest.getRole())
                .username(userRequest.getUsername())
                .build());
    }

    public UserResponse getUserById(UUID id) {
        User user= userRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException("user not found"));
        return UserResponse.builder()
                .email(user.getEmail())
                .username(user.getUsername())
                .role(user.getRole())
                .build();
    }


}
