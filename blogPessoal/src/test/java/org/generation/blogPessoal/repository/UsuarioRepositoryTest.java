package org.generation.blogPessoal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import org.generation.blogPessoal.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@BeforeAll
	void start(){
		
		usuarioRepository.save(new Usuario(0L, "Juliana Azevedo", "juliana@gmail.com", "123456789", "sem foto"));
		
		usuarioRepository.save(new Usuario(0L, "Ana Santos", "anasantos@gmail.com", "123456789", "sem foto"));
	
		usuarioRepository.save(new Usuario(0L, "Sabrina Oliveira", "sabrina@gmail.com", "123456789", "sem foto"));
		
		usuarioRepository.save(new Usuario(0L, "Thais Silva", "thais@gmail.com", "123456789","sem foto"));
	}
	
	
	@Test
	@DisplayName("Retorna 1 usuario")
	public void deveRetornarUmUsuario() {
		
		Optional<Usuario> usuario = usuarioRepository.findByUsuario("anasantos@gmail.com");
		assertTrue(usuario.get().getUsuario().equals("anasantos@gmail.com"));
}
	@Test
	@DisplayName("Retorna 3 usuários")
	public void deveRetornarTresUsuario() {
		
		List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Silva");
		assertEquals(3, listaDeUsuarios.size());
		assertTrue(listaDeUsuarios.get(0).getNome().equals("anasantos@gmail.com"));
		assertTrue(listaDeUsuarios.get(1).getNome().equals("sabrina@gmail.com"));
		assertTrue(listaDeUsuarios.get(2).getNome().equals("Thais Silva"));
	}
}
	

