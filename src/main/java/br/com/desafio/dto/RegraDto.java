package br.com.desafio.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.desafio.model.Regra;
import br.com.desafio.model.enumerator.PermitidoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegraDto {
	
	@NotNull
	private Integer procedimento;
	
	@NotNull
	@Min(value = 1)
	private Integer idade;
	
	@NotBlank
	@Length(max = 1)
	private String sexo;
	
	private PermitidoEnum permitido;

	@JsonIgnore
	public Regra toEntity() {
		return new Regra(this.idade,this.sexo, this.permitido);
	}

}
