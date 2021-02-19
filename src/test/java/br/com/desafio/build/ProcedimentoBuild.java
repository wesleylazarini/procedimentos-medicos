package br.com.desafio.build;

import java.util.ArrayList;
import java.util.List;

import br.com.desafio.model.Procedimento;

public class ProcedimentoBuild {

	public static List<Procedimento> getListaProcedimentos(){

		List<Procedimento> lista = new ArrayList<Procedimento>();
		lista.add(new Procedimento(1L, 1234));
		lista.add(new Procedimento(2L, 4567));
		lista.add(new Procedimento(3L, 6789));
				
		return lista;
	}

	public static Procedimento criaProcedimento() {
		return new Procedimento(1L, 1234);
	}
}
