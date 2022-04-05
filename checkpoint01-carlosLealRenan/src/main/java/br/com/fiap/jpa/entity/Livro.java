package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_livro")
@SequenceGenerator(name = "livro", sequenceName = "SQ_TB_LIVRO", allocationSize = 1)
public class Livro implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1221667803343225285L;
	
	public Livro() {
		this.ativo = true;
		this.dataCadastro = LocalDateTime.now();
		this.dataAtualizacao = LocalDateTime.now();
	}
	
	public Livro(String titulo, String autor, Integer isbn, Integer edicao, LocalDate dataPublicacao) {
		this();
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.edicao = edicao;
		this.dataPublicacao = dataPublicacao;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "livro")
	private Long id;
	
	@Column(name = "ds_titulo", length = 80, nullable = false)
	private String titulo;
	
	@Column(name = "nm_autor", length = 80, nullable = false)
	private String autor;
	
	@Column(name = "nr_isbn", nullable = false, unique = true)
	private Integer isbn;
	
	@Column(name = "nr_edicao", nullable = false)
	private Integer edicao;
	
	@Column(name = "dt_publicacao")
	private LocalDate dataPublicacao;
	
	@Column(name = "st_ativo")
	private boolean ativo;
	
	@Column(name = "dt_cadastro")
	private LocalDateTime dataCadastro;
	
	@Column(name = "dt_atualizacao")
	private LocalDateTime dataAtualizacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getIsbn() {
		return isbn;
	}

	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}

	public Integer getEdicao() {
		return edicao;
	}

	public void setEdicao(Integer edicao) {
		this.edicao = edicao;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		
		return "\nTítulo: " + this.getTitulo() 
			+ "\nAutor: " + this.getAutor()
			+ "\nISBN: " + this.getIsbn() 
			+ "\nEdição: " + this.getEdicao()
			+ "\nData de Publicação: " + this.getDataPublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
}
