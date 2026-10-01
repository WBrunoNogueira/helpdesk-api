package br.com.helpdesk.service;

import br.com.helpdesk.dto.request.UserRequest;
import br.com.helpdesk.dto.response.UserResponse;
import br.com.helpdesk.mapper.UserMapper;
import br.com.helpdesk.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(
            UserRepository userRepository,
            UserMapper userMapper
    ) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Transactional
    public UserResponse createUser(UserRequest userRequest) {
        var user = userMapper.toEntity(userRequest);
        var savedUser = userRepository.save(user);

        return userMapper.toResponse(savedUser);
    }

    @Transactional(readOnly = true)
    public List<UserResponse> findAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public UserResponse findUserById(Long id) {
        var user = userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found with id: " + id));

        return userMapper.toResponse(user);
    }

    @Transactional
    public UserResponse updateUser(
            Long id,
            UserRequest userRequest
    ) {
        var user = userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found with id: " + id));

        userMapper.updateEntity(userRequest, user);

        var updatedUser = userRepository.save(user);

        return userMapper.toResponse(updatedUser);
    }

    @Transactional
    public void deleteUser(Long id) {
        var user = userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found with id: " + id));

        userRepository.delete(user);
    }
}