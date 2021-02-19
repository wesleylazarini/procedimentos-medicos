package br.com.desafio.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.dto.RegraDto;
import br.com.desafio.model.Procedimento;
import br.com.desafio.services.ProcedimentoService;

@RestController
@RequestMapping(value = "/autorizador")
public class ProcedimentoController {

	@Autowired
	ProcedimentoService sProcedimento;

	@PostMapping(value = "/cadastro", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> cadastro(@Valid @RequestBody final RegraDto regraDto) {

		Optional<Procedimento> procedimento = sProcedimento.buscaProcedimento(regraDto.getProcedimento());

		if (!procedimento.isPresent())
			return new ResponseEntity<>("Procedimento invalido", HttpStatus.BAD_REQUEST);

		sProcedimento.cadastrar(regraDto, procedimento.get());

		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "/{procedimento}/{idade}/{sexo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> autorizador(@PathVariable(value = "procedimento") Integer procedimento,
			@PathVariable(value = "idade") Integer idade, @PathVariable(value = "sexo") String sexo) throws Exception {

		return ResponseEntity.ok(sProcedimento.autorizaProcedimento(procedimento, idade, sexo));
	}

}
