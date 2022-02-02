package org.generation.blogPessoal.repository;


import java.util.Optional;

import org.generation.blogPessoal.model.Usuario;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository repository;
	
//	@BeforeAll
//	void start(){
//		
//		repository.save(new Usuario(0L, "Juliana Azevedo", "juliana@gmail.com", "123456789"));
//		
//		repository.save(new Usuario(0L, "Ana Santos", "anasantos@gmail.com", "123456789"));
//		
//		repository.save(new Usuario(0L, "Sabrina Oliveira", "sabrina@gmail.com", "123456789"));
//		
//		repository.save(new Usuario(0L, "Thais Silva", "thais@gmail.com", "123456789"));
//	}
//	@Test
//	@DisplayName("Retorna 1 usuario")
//	public void deveRetornarUmUsuario() {
//		
//		Optional<Usuario> usuario = repository.findByUsuario("joao@email.com.br");
//}
//	
}
	
}
