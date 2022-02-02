package org.generation.blogPessoal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	@Email (message = "O atributo usuario deve coter um email válido!")
	private String usuario;
	
	@NotBlank (message = "O atributo Senha é Obrigatório!") 
	@Size (min = 8, message = "O atributo senha deve conter no mínimo 08 caracteres")
	private String senha;

	private String foto;
	
	
	public Usuario(long id,
			@NotNull(message = "O atributo Nome é Obrigatório!") @Size(min = 3, max = 100, message = "O atributo nome deve conter no mínimo 03 e no máximo 100 caracteres") String nome,
			@NotNull(message = "O atributo Usuario é Obrigatório!") @Email(message = "O atributo usuario deve coter um email válido!") String usuario,
			@NotBlank(message = "O atributo Senha é Obrigatório!") @Size(min = 8, message = "O atributo senha deve conter no mínimo 08 caracteres") String senha,
			String foto, List<Postagem> postagem) {
		this.id = id;
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
		this.foto = foto;
		this.postagem = postagem;
		
		
	}

	public Usuario() {
	}

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<Postagem> postagem;
	


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

		public String getFoto() {
			return foto;
		}
		public void setFoto(String foto) {
			this.foto = foto;
		
		}
			public List<Postagem> getPostagem() {
				return postagem;
			}

			public void setPostagem(List<Postagem> postagem) {
				this.postagem = postagem;
			}

		
	}
		
	
