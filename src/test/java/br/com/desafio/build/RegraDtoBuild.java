package br.com.desafio.build;

import br.com.desafio.dto.RegraDto;
import br.com.desafio.model.enumerator.PermitidoEnum;

public class RegraDtoBuild {
	
	public static RegraDto criaNovaRegra() {
		return new RegraDto(1234, 10, "M", PermitidoEnum.SIM);
	}
}
