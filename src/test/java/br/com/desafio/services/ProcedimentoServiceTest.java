package br.com.desafio.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.desafio.build.ProcedimentoBuild;
import br.com.desafio.build.RegraDtoBuild;
import br.com.desafio.dto.RegraDto;
import br.com.desafio.model.Procedimento;
import br.com.desafio.model.Regra;
import br.com.desafio.repository.ProcedimentoRepository;
import br.com.desafio.repository.RegraRepository;

@SpringBootTest
public class ProcedimentoServiceTest {

	@InjectMocks
	private ProcedimentoService sProcedimento = new ProcedimentoService();

	@Mock
	private ProcedimentoRepository dProcedimento;
	
	@Mock
	private RegraRepository dRegra;

	@Test
	public void cadastroRegraAutorizacao() {

		RegraDto regraDto = RegraDtoBuild.criaNovaRegra();

		Procedimento procedimento = ProcedimentoBuild.criaProcedimento();
		
		Regra regra = regraDto.toEntity();
		regra.setProcedimento(procedimento);

		when(dRegra.save(any(Regra.class))).thenReturn(regra);

		sProcedimento.cadastrar(regraDto, procedimento);

		verify(dRegra, times(1)).save(regra);
	}
}
