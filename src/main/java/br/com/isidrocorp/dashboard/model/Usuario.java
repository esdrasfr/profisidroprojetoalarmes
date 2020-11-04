package br.com.isidrocorp.dashboard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/* As classes do pacote MODEL são as classes que criamos para armazenar/recuperar do Banco de Dados
 * Cada tabela tem uma classe correspondente que a anotamos para fazer o "De-PARA" (o mapeamento) de
 * seus identificadores para a nomenclatura da tabela
 */

@Entity                 // anotacão @Entity indica que tenho uma classe armazenável em Banco
@Table (name="tbl_usuario")  // anotação @Table explicita o nome da tabela que corresponde a classe
public class Usuario {
	
	@Id                   // indica que o atributo é chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) // indica que o valor do atributo é gerado pelo banco (Auto-increment)
	@Column(name="id")    // mapeio o nome da coluna
	private int id;
	
	@Column(name = "nome", length = 100, nullable = false)
	private String nome;
	
	@Column(name = "email", length = 100, nullable = false)
	private String email;
	
	@Column(name = "racf", length = 7, nullable = false)
	private String racf;
	
	@Column(name = "senha", length = 20, nullable = false)
	private String senha;
	
	@Column(name = "link_foto", length = 255)
	private String linkFoto;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRacf() {
		return racf;
	}

	public void setRacf(String racf) {
		this.racf = racf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLinkFoto() {
		return linkFoto;
	}

	public void setLinkFoto(String linkFoto) {
		this.linkFoto = linkFoto;
	}
}
