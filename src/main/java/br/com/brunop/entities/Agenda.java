package br.com.brunop.entities;

import java.util.HashMap;
import java.util.Map;

public class Agenda {
	private Map<String, String> agendamento;
	private boolean ativo;
	
	public Agenda() {
		this.agendamento = new HashMap<String, String>();
		this.ativo = true;
	}
	
	public boolean marcarShow(String data, String Banda) {
		if(data.length()>5 || data.length()<5)
			return false;
		
		if (!this.agendamento.containsKey(data)) {
			this.agendamento.put(data, Banda);
			return true;
		}
		return false;
	}
	
	public boolean desmarcarShow(String data, String banda) {
		if(data.length()>5)
			return false;
		
		if (this.agendamento.containsKey(data)) {
			if(this.agendamento.get(data) == banda) {
				this.agendamento.remove(data);
				return true;
			}
		}
		return false;
	}
	
	public int contarShows() {
		return this.agendamento.size();
	}
	

	//Getters e Setters
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.agendamento = new HashMap<String, String>();
		this.ativo = ativo;
	}

	public Map<String, String> getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(Map<String, String> agendamento) {
		this.agendamento = agendamento;
	}
}
