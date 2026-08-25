package br.com.helpdesk.dto.response;

import br.com.helpdesk.model.enums.UserRole;
public record UserResponse(
    Long id,
    String name,
    String functionalCode,
    String phone,
    String location,
    UserRole role
) {
}
