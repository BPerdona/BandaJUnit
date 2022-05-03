package br.com.brunop.entities;


public class Musico {
	private String nome;
	private int idade;
	private String instrumento;
	private int nota;
	private String descricao;
	
	public Musico(String nome, int idade, String instrumento, int nota) {
		this.nome = nome;
		this.idade = idade;
		this.instrumento = instrumento;
		this.nota = nota;
	}
	
	public Musico(String nome, int idade, String instrumento, int nota, String descricao) {
		this.nome = nome;
		this.idade = idade;
		this.instrumento = instrumento;
		this.nota = nota;
		this.descricao = descricao;
	}
	
	public void setNota(int nota) {
		if(nota>10 || nota<0) {
			this.nota = 0;
			return;
		}
		this.nota = nota;
		return;
	}

	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	public String getInstrumento() {
		return instrumento;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public void setInstrumento(String instrumento) {
		this.instrumento = instrumento;
	}

	public int getNota() {
		return nota;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}