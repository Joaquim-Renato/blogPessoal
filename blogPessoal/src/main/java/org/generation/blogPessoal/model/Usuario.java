package org.generation.blogPessoal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table (name = "tb_usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id;
	
	@NotNull (message = "O atributo Nome é Obrigatório!") 
	@Size (min = 3, max = 100, message = "O atributo nome deve conter no mínimo 03 e no máximo 100 caracteres")
	private String nome;
	
	@NotNull (message = "O atributo Usuario é Obrigatório!")
	@Size (min = 11, max = 100, message = "O atributo usuario deve conter no mínimo 11 e no máximo 100 caracteres")
	private String usuario;
	
	@NotNull (message = "O atributo Senha é Obrigatório!") 
	@Size (min = 8, max = 25, message = "O atributo senha deve conter no mínimo 08 e no máximo 100 caracteres")
	private String senha;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
