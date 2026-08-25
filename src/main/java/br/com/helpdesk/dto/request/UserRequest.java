package br.com.helpdesk.dto.request;

import br.com.helpdesk.model.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

// incluido validation
public record UserRequest(
        @NotBlank(message = "O nome é obrigatório")
        @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
        String name,

        @NotBlank(message = "O código funcional é obrigatório")
        @Size(max = 30, message = "O código funcional deve ter no máximo 30 caracteres")
        String functionalCode,

        @NotBlank(message = "O telefone é obrigatório")
        @Size(max = 20, message = "O telefone deve ter no máximo 20 caracteres")
        String phone,

        @NotBlank(message = "O local é obrigatório")
        @Size(max = 100, message = "A localização deve ter no máximo 100 caracteres")
        String location,

        @NotNull(message = "O perfil do usuário é obrigatório")
        UserRole role
) {
}
