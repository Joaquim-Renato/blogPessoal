package org.generation.blogPessoal.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.generation.blogPessoal.model.Usuario;
import org.generation.blogPessoal.service.UsuarioService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UsuarioControllerTest {

	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Test
	@Order(1)
	@DisplayName("Cadastrar um usuário")
	public void deveCriarUmUsuario() {
		
		
		HttpEntity<Usuario> requisicao = new HttpEntity<Usuario>(new Usuario(0L, 
				"Juliana Azevedo", "juliana@gmail.com", "123456789", "sem foto"));
		
		ResponseEntity<Usuario> resposta = testRestTemplate
				.exchange("/usuario/cadastrar", HttpMethod.POST, requisicao, Usuario.class);
		
		assertEquals(HttpStatus.CREATED, resposta.getStatusCode());
		assertEquals(requisicao.getBody().getNome(), resposta.getBody().getNome());
		assertEquals(requisicao.getBody().getUsuario(), resposta.getBody().getUsuario());
	}
	
	@Test
	@Order(2)
	@DisplayName("Não deve permitir duplicação do Usuário")
	public void naoDeveDuplicarUsuario() {
		
		usuarioService.cadastrarUsuario(new Usuario(0L, 
				 "Ana Santos", "anasantos@gmail.com", "123456789", "sem foto"));
		
		HttpEntity<Usuario> requisicao = new HttpEntity<Usuario>(new Usuario(0L, 
				 "Ana Santos", "anasantos@gmail.com", "123456789", "sem foto"));
		
		ResponseEntity<Usuario> resposta = testRestTemplate
				.exchange("/usuario/cadastrar", HttpMethod.POST, requisicao, Usuario.class);
		
		assertEquals(HttpStatus.BAD_REQUEST, resposta.getStatusCode());
	}
	
	@Test
	@Order(3)
	@DisplayName("Atualizar um Usuário")
	public void deveAtualizarUmUsuario() {
		
		Optional<Usuario> usuarioCadastrado = usuarioService.cadastrarUsuario(new Usuario(0L, 
				"Juliana Azevedo", "juliana@gmail.com","123456789", "sem foto"));
		
		Usuario usuarioUpdate = new Usuario(usuarioCadastrado.get().getId(), 
				"Juliana Azevedo Ramos", "julianaramos@gmail.com","123456789", "sem foto");
		
		HttpEntity<Usuario> requisicao = new HttpEntity<Usuario>(usuarioUpdate);
		
		ResponseEntity<Usuario> resposta = testRestTemplate
				.withBasicAuth("root", "root")
				.exchange("/usuario/atualizar", HttpMethod.PUT, requisicao, Usuario.class);
		
		assertEquals(HttpStatus.OK, resposta.getStatusCode());
		assertEquals(requisicao.getBody().getNome(), resposta.getBody().getNome());
		assertEquals(requisicao.getBody().getUsuario(), resposta.getBody().getUsuario());
	}
	
	@Test
	@Order(4)
	@DisplayName("Listar todos os Usuários")
	public void deveMostrarTodosUsuarios() {
		
		usuarioService.cadastrarUsuario(new Usuario(0L, 
				"Sabrina Oliveira", "sabrina@gmail.com", "123456789", "sem foto"));
		
		usuarioService.cadastrarUsuario(new Usuario(0L, 
				"Thais Silva", "thais@gmail.com", "123456789","sem foto"));
		
		ResponseEntity<String> resposta = testRestTemplate
				.withBasicAuth("root", "root")
				.exchange("/usuarios/all", HttpMethod.GET, null, String.class);
		
		assertEquals(HttpStatus.OK, resposta.getStatusCode());
	}
	
	
}
