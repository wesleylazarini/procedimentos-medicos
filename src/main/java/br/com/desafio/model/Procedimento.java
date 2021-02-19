package br.com.desafio.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Procedimento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "numero_procedimento")
	private Integer numProcedimento;
	
	@OneToMany(targetEntity=Regra.class, mappedBy="procedimento",cascade=CascadeType.ALL, fetch = FetchType.LAZY)    
	private List<Regra> regras = new ArrayList<>();
	
	public Procedimento(Long id, Integer procedimento) {
		this.id = id;
		this.numProcedimento = procedimento;
	}
	
}
