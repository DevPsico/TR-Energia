package com.ericsontrenergia.ericsontrenergia.dtos;

import com.ericsontrenergia.ericsontrenergia.models.Usuario;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UsuarioDTO {

	private Integer id;
	@jakarta.validation.constraints.NotEmpty(message = "O campo Nome é obrigatório !")
	private String nome;
	@NotEmpty(message = "O campo CPF é obrigatório !")
	private String cpf;
	//@NotEmpty(message = "O campo Idade é obrigatório !")
	private Integer idade;
	@NotEmpty(message = "O campo Endereço é obrigatório !")
	private String endereco;
	@NotEmpty(message = "O campo Cor Favorita é obrigatório !")
	private String corFavorita;

	public UsuarioDTO() {
		super();
	}

	public UsuarioDTO(Integer id, String nome, String cpf, Integer idade, String endereco, String corFavorita) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.endereco = endereco;
		this.corFavorita = corFavorita;
	}

	public UsuarioDTO(Usuario usuario) {

		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.cpf = usuario.getCpf();
		this.idade = usuario.getIdade();
		this.endereco = usuario.getEndereco();
		this.corFavorita = usuario.getCorFavorita();
	}
}