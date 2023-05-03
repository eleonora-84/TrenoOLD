package dto;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

//bean di treno

@Component
@Entity
@Table(name = "treno")
public class TrenoDTO {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String sigla;
	
	@Column
	private double peso;
	
	@ManyToOne
	private UtenteDTO utente;
	// private Utente utente;
	// rispecchia tabella del database
	
	
	public TrenoDTO(String sigla, double peso, UtenteDTO utente) {
		super();
		this.sigla = sigla;
		this.peso = peso;
		this.utente = utente;
	}
	public TrenoDTO() {

	}
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public UtenteDTO getUtente() {
		return utente;
	}
	public void setUtente(UtenteDTO utente) {
		this.utente = utente;
	}
	@Override
	public String toString() {
		return "TrenoDTO [id=" + id + ", sigla=" + sigla + ", peso=" + peso + "]";
	}
}
