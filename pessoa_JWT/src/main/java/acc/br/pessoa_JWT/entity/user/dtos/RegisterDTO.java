package acc.br.pessoa_JWT.entity.user.dtos;



import acc.br.pessoa_JWT.entity.enums.UserRoles;



public record RegisterDTO(String login, String password, UserRoles role) {



}

