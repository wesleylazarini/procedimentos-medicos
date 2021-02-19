package br.com.desafio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.model.Procedimento;
import br.com.desafio.model.Regra;

@Repository
public interface RegraRepository extends JpaRepository<Regra, Long>{

	Optional<Regra> findByProcedimentoAndIdadeAndSexo(Procedimento procedimento, Integer idade, String sexo);

}
