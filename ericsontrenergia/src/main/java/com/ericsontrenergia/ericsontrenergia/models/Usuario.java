package com.ericsontrenergia.ericsontrenergia.models;

import org.hibernate.validator.constraints.br.CPF;

import com.ericsontrenergia.ericsontrenergia.dtos.UsuarioDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	@CPF(message = "CPF inválido")
	private String cpf;
	private Integer idade;
	private String endereco;
	private String corFavorita;

	public Usuario() {
		super();
	}

	public Usuario(Integer id, String nome, String cpf, Integer idade, String endereco, String corFavorita) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.endereco = endereco;
		this.corFavorita = corFavorita;
	}

	public Usuario(UsuarioDTO usuarioDTO) {

		this.id = usuarioDTO.getId();
		this.nome = usuarioDTO.getNome();
		this.cpf = usuarioDTO.getCpf();
		this.idade = usuarioDTO.getIdade();
		this.endereco = usuarioDTO.getEndereco();
		this.corFavorita = usuarioDTO.getCorFavorita();
	}
}