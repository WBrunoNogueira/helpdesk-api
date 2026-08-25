package br.com.helpdesk.mapper;

import br.com.helpdesk.dto.request.UserRequest;
import br.com.helpdesk.dto.response.UserResponse;
import br.com.helpdesk.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserRequest request) {
        return new User(
                request.name(),
                request.functionalCode(),
                request.phone(),
                request.location(),
                request.role()
        );
    }

    public UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getFunctionalCode(),
                user.getPhone(),
                user.getLocation(),
                user.getRole()
        );
    }
}