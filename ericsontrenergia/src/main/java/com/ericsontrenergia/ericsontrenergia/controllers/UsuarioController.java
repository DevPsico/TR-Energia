package com.ericsontrenergia.ericsontrenergia.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ericsontrenergia.ericsontrenergia.dtos.UsuarioDTO;
import com.ericsontrenergia.ericsontrenergia.models.Usuario;
import com.ericsontrenergia.ericsontrenergia.services.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/{id}")
	@Operation(summary = "Buscar usuário por um Id específico", description = "Retorna um usuário com base no ID fornecido.")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Usuário encontrado"),
			@ApiResponse(responseCode = "404", description = "Usuário não encontrado") 
	})
	public ResponseEntity<UsuarioDTO> findById(@PathVariable Integer id) {

		Usuario usuario = usuarioService.findById(id);

		return ResponseEntity.ok().body(new UsuarioDTO(usuario));
	}

	@GetMapping
	@Operation(summary = "Buscar todos os usuários", description = "Retorna uma lista de todos os usuários cadastrados.")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Lista de usuários retornada"),
			@ApiResponse(responseCode = "404", description = "Nenhum usuário encontrado") 
			})
	public ResponseEntity<List<UsuarioDTO>> findAll() {

		List<Usuario> listUsuario = usuarioService.findAll();

		List<UsuarioDTO> listUsuarioDTO = listUsuario.stream().map(UsuarioDTO::new).collect(Collectors.toList());

		return ResponseEntity.ok().body(listUsuarioDTO);

	}

	@PostMapping
	@Operation(summary = "Criar um novo usuário", description = "Cadastra um novo usuário com os dados fornecidos.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Usuário criado com sucesso"),
			@ApiResponse(responseCode = "400", description = "Dados inválidos") 
			})
	public ResponseEntity<UsuarioDTO> create(@Valid @RequestBody UsuarioDTO usuarioDTO) {

		usuarioDTO.setId(null);
		Usuario usuario = usuarioService.save(usuarioDTO);

		return ResponseEntity.ok().body(new UsuarioDTO(usuario));

	}

	@PutMapping("/{id}")
	@Operation(summary = "Atualizar um usuário existente", 
    description = "Atualiza os dados de um usuário existente com o ID fornecido.")
	@ApiResponses(value = {	
			@ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso"),
			@ApiResponse(responseCode = "404", description = "Usuário não encontrado"),
			@ApiResponse(responseCode = "400", description = "Dados inválidos")
			})
	public ResponseEntity<UsuarioDTO> update(@PathVariable Integer id, @Valid @RequestBody UsuarioDTO usuarioDTO) {

		Usuario usuario = usuarioService.update(id, usuarioDTO);

		return ResponseEntity.ok().body(new UsuarioDTO(usuario));

	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Deletar um usuário", 
     description = "Remove um usuário com base no ID fornecido.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204", description = "Usuário deletado com sucesso"),
			@ApiResponse(responseCode = "404", description = "Usuário não encontrado")
			})
	public ResponseEntity<UsuarioDTO> delete(@PathVariable Integer id) {

		usuarioService.delete(id);

		return ResponseEntity.noContent().build();
	}

	@GetMapping("/cpf/{cpf}")
	@Operation(summary = "Buscar usuário por CPF", 
    description = "Retorna um usuário com base no CPF fornecido.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Usuário encontrado"),
			@ApiResponse(responseCode = "404", description = "Usuário não encontrado")
			})
	public ResponseEntity<UsuarioDTO> findByCpf(@PathVariable String cpf) {

		Usuario usuario = usuarioService.findByCpf(cpf);

		return ResponseEntity.ok().body(new UsuarioDTO(usuario));
	}
}