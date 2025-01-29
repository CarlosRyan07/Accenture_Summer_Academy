package acc.br.pessoa_JWT.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import acc.br.pessoa_JWT.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}

