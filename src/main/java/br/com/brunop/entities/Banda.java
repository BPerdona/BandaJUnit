package br.com.brunop.entities;

import java.util.ArrayList;

public class Banda {
	private ArrayList<Musico> musicos;
	private Agenda agenda;
	private String nomeBanda;
	private String estilo;
	private int notaMinima;
	
	public Banda( String nomeBanda, String estilo, int notaMinima) {
		this.musicos = new ArrayList<Musico>();
		this.agenda = new Agenda();
		this.nomeBanda = nomeBanda;
		this.estilo = estilo;
		this.notaMinima = notaMinima;
	}
	
	public boolean adicionarMembro(Musico musico) {
		if (musico == null) {
			return false;
		}
		if (this.musicos.contains(musico)) {
			return false;
		}
		if (musico.getNota() < this.notaMinima) {
			return false;
		}else{
			this.musicos.add(musico);
			return true;
		}
	}
	
	public boolean removerMembro(String nome){
		if(nome == null) {
			throw new NullPointerException();
		}
		if(nome.isBlank()) {
			return false;
		}
		for(int i = 0; i<this.musicos.size(); i++) {
			if(musicos.get(i).getNome() == nome) {
				musicos.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public float notaMedia() {
		if(musicos.size()==0) {
			return 0;
		}
		int soma = 0;
		for (Musico musico : this.musicos) {
			soma += musico.getNota();
		}
		float total = (soma/this.musicos.size());
		return total;
	}
	
	public boolean agendaLivre(String dia) {
		return !this.agenda.getAgendamento().containsKey(dia);
	}
	
	public boolean marcarShow(String data) {
		if(data.length()>5) {
			return false;
		}
		if (this.agendaLivre(data)) {
			if(this.agenda.marcarShow(data, this.nomeBanda)) {
				return true;
			}
		}
		return false;
	}
	
	public int contarShow() {
		return this.agenda.getAgendamento().size();
	}
	
	//Getters e Setters
	public ArrayList<Musico> getMusicos() {
		return musicos;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public String getNomeBanda() {
		return nomeBanda;
	}

	public String getEstilo() {
		return estilo;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public void setNomeBanda(String nomeBanda) {
		this.nomeBanda = nomeBanda;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}
}
