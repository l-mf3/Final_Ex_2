package br.usjt.clima.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Semana {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String dia;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public Semana() {
		super();
	}
	public Semana(Long id, String dia) {
		super();
		this.id = id;
		this.dia = dia;
	}
}
