package com.gmdiias.controle.clientes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.gmdiias.basic.BasicEntity;
import com.gmdiias.controle.compra.Estado;
import com.gmdiias.controle.shared.enums.Situacao;

@Entity
@Table(name = "cliente", uniqueConstraints = @UniqueConstraint(columnNames = { "cpf", "email" }))
public class Cliente extends BasicEntity {
	private static final long serialVersionUID = 1L;

	@NotBlank
	private String nome;
	@Column(name = "cpf")
	private String cpf;
	private Date dataNascimento;
	@Email
	@Column(name = "email")
	private String email;
	@ManyToOne
	@NotNull
	private Estado estado;
	
	@Enumerated
	private Situacao situacao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	@Override
	public void mergeEntity(Object received) {
		Cliente entity = (Cliente) received;
		this.nome = entity.nome;
		this.cpf = entity.cpf;
		this.dataNascimento = entity.dataNascimento;
		this.email = entity.email;
		this.estado = entity.estado;
		this.situacao = entity.situacao;
	}

}
