package br.com.helpdesk.service;

import br.com.helpdesk.dto.request.UserRequest;
import br.com.helpdesk.dto.response.UserResponse;
import br.com.helpdesk.mapper.UserMapper;
import br.com.helpdesk.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    //create
    @Transactional
    public UserResponse createUser(UserRequest userRequest) {
        var user = userMapper.toEntity(userRequest);
        var savedUser = userRepository.save(user);
        return userMapper.toResponse(savedUser);
    }

    //findall
    public Iterable<UserResponse> findAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toResponse)
                .toList();
    }

    //findbyid
    public UserResponse findUserById(Long id) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return userMapper.toResponse(user);
    }

    //update
    @Transactional
    public UserResponse updateUser(Long id, UserRequest userRequest) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        user.setName(userRequest.name());
        user.setFunctionalCode(userRequest.functionalCode());
        user.setPhone(userRequest.phone());
        user.setLocation(userRequest.location());
        user.setRole(userRequest.role());
        var updatedUser = userRepository.save(user);
        return userMapper.toResponse(updatedUser);
    }

    //delete
    @Transactional
    public void deleteUser(Long id) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        userRepository.delete(user);
    }
}
