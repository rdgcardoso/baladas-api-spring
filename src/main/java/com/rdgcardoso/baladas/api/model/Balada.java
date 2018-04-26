package com.rdgcardoso.baladas.api.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Balada {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Nome não pode ser nulo")
	@NotEmpty(message = "Nome não pode ser vazio")
	private String nome;
	
	@NotNull(message = "CEP não pode ser nulo")
	@NotEmpty(message = "CEP não pode ser vazio")
	private String cep;
	
	@NotNull(message = "UF não pode ser nulo")
	@NotEmpty(message = "UF não pode ser vazio")
    private String uf;
	
	@NotNull(message = "Cidade não pode ser nulo")
	@NotEmpty(message = "Cidade não pode ser vazio")
    private String cidade;
	
    private String bairro;
	
    private String logradouro;
    
    private String numero;
    
    private String complemento;	
	
	private String descricao;
	private double avaliacao;	
	private String site;	
	private double preco_medio;
	private String telefone;
	private String foto;
	private boolean ativo;
	
	@ManyToMany
	private List<GeneroMusical> genero_musical;
	
	public Balada() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(double avaliacao) {
		this.avaliacao = avaliacao;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public double getPreco_medio() {
		return preco_medio;
	}

	public void setPreco_medio(double preco_medio) {
		this.preco_medio = preco_medio;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public List<GeneroMusical> getGenero_musical() {
		return genero_musical;
	}

	public void setGenero_musical(List<GeneroMusical> genero_musical) {
		this.genero_musical = genero_musical;
	}		
	
	
}