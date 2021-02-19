package br.com.desafio.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.desafio.model.enumerator.PermitidoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "regras")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Regra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name="procedimento", referencedColumnName = "id", nullable = false)  
	private Procedimento procedimento;
	
	private Integer idade;
	
	private String sexo;
	
	@Enumerated(EnumType.STRING)
	private PermitidoEnum permitido;
	
	public Regra(Integer idade, String sexo, PermitidoEnum permitido) {
		this.idade = idade;
		this.sexo = sexo;
		this.permitido = permitido;
	}
}
