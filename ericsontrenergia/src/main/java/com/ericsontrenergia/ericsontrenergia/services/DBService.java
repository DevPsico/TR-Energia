package com.ericsontrenergia.ericsontrenergia.services;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ericsontrenergia.ericsontrenergia.models.Usuario;
import com.ericsontrenergia.ericsontrenergia.respositorys.UsuarioRepository;

@Service
public class DBService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public void instanciaDB() {

		
		Usuario user1 = new Usuario(null, "Usuario 1", "40223067008", 40, "Rua a", "Azul");
		Usuario user2 = new Usuario(null, "Usuario 2", "38078775091", 40, "Rua b", "Amarela");
		Usuario user3 = new Usuario(null, "Usuario 3", "37819663057", 40, "Rua c", "Rosa");
		Usuario user4 = new Usuario(null, "Usuario 4", "81101354046", 40, "Rua d", "Verde");
		Usuario user5 = new Usuario(null, "Usuario 5", "99964516070", 40, "Rua e", "Vermelho");

		this.usuarioRepository.saveAll(Arrays.asList(user1, user2, user3, user4, user5));
		
	}
}