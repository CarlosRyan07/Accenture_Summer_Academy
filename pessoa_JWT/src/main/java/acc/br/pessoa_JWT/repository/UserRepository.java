package acc.br.pessoa_JWT.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import acc.br.pessoa_JWT.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	//consulta usuario pelo login
	UserDetails findByLogin(String login);
	
}
