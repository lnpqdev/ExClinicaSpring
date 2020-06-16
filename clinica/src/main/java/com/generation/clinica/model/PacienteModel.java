package com.generation.clinica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="tbPaciente")
public class PacienteModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long codPaciente;
	
	@Column(name="nome", nullable=false)
	@Size(min=2, max=80)
	private String nome;
	
	@Column(name="nome", nullable=false)
	@Size(min=2, max=80)
	private String endereço;
	
	@Column(name="nome", nullable=false)
	@Size(max=9)
	private String cep;
	
	@Column(name="nome", nullable=false)
	@Size(max=9)
	private String telefone;
	

	public long getCodPaciente() {
		return codPaciente;
	}

	public void setCodPaciente(long codPaciente) {
		this.codPaciente = codPaciente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereço() {
		return endereço;
	}

	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	

}
