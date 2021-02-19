package br.com.desafio.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.dto.RegraDto;
import br.com.desafio.model.Procedimento;
import br.com.desafio.model.Regra;
import br.com.desafio.model.enumerator.PermitidoEnum;
import br.com.desafio.repository.ProcedimentoRepository;
import br.com.desafio.repository.RegraRepository;

@Service
public class ProcedimentoService {

	@Autowired
	private RegraRepository dRegra;

	@Autowired
	private ProcedimentoRepository dProcedimento;

	public Optional<Procedimento> buscaProcedimento(Integer procedimento) {

		return dProcedimento.findByNumProcedimento(procedimento);
	}

	public void cadastrar(RegraDto regraDto, Procedimento procedimento) {

		Regra regra = regraDto.toEntity();
		regra.setProcedimento(procedimento);

		dRegra.save(regra);
	}

	public String autorizaProcedimento(Integer procedimento, Integer idade, String sexo) throws Exception {

		Optional<Procedimento> proced = dProcedimento.findByNumProcedimento(procedimento);

		if (!proced.isPresent())
			return PermitidoEnum.NAO.name();

		Optional<Regra> regra = dRegra.findByProcedimentoAndIdadeAndSexo(proced.get(), idade, sexo);

		return regra.isPresent() && regra.get().getPermitido().equals(PermitidoEnum.SIM) ? PermitidoEnum.SIM.name()
				: PermitidoEnum.NAO.name();
	}

}
