package com.ericsontrenergia.ericsontrenergia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericsontrenergia.ericsontrenergia.dtos.UsuarioDTO;
import com.ericsontrenergia.ericsontrenergia.exceptions.ObjectNotFoundException;
import com.ericsontrenergia.ericsontrenergia.models.Usuario;
import com.ericsontrenergia.ericsontrenergia.respositorys.UsuarioRepository;

import jakarta.validation.Valid;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario findById(Integer id) {

		Optional<Usuario> usuario = usuarioRepository.findById(id);

		return usuario.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado !!!!"));
	}

	public List<Usuario> findAll() {

		List<Usuario> listUsuario = usuarioRepository.findAll();

		if (listUsuario.isEmpty()) {
			throw new ObjectNotFoundException("Nenhum usuário cadastrado !!!");
		}

		return listUsuario;
	}

	public Usuario save(@Valid UsuarioDTO usuarioDTO) {
		// TODO Auto-generated method stub

		validarCpf(usuarioDTO.getCpf());
		usuarioDTO.setId(null);

		return usuarioRepository.save(new Usuario(usuarioDTO));

	}

	public Usuario update(Integer id, UsuarioDTO usuarioDTO) {
		// TODO Auto-generated method stub
		Usuario usuario = findById(id);

		usuarioDTO.setId(usuario.getId());

		validarCpf(usuarioDTO.getCpf());
		
		return usuarioRepository.save(new Usuario(usuarioDTO));

	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub

		findById(id);

		usuarioRepository.deleteById(id);

	}

	public Usuario findByCpf(String cpf) {

		Optional<Usuario> usuario = usuarioRepository.findByCpf(cpf);

		return usuario.orElseThrow(() -> new ObjectNotFoundException("Usuário com o CPF " + cpf + " não encontrado"));
	}

	private void validarCpf(String cpf) {

		if (usuarioRepository.findByCpf(cpf).isPresent()) {
			throw new IllegalArgumentException("Cpf já cadastrado !");
		}
	}

}