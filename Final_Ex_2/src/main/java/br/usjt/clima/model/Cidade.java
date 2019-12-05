package br.usjt.clima.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private Double latitude;
	private Double longitude;
	
	@OneToMany(mappedBy = "cidade", cascade = CascadeType.ALL)
	private List<Clima> climas;

	public Long getId() {
		return id;
	}
	@JsonIgnore
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
    public void setNome(String nome) {
		this.nome = nome;
	}
    public Double getLatitude() {
		return latitude;
	}
    public void setLatitude(String latitude) {
		this.latitude = Double.parseDouble(latitude);
	}
    public Double getLongitude() {
		return longitude;
	}
    public void setLongitude(String longitude) {
		this.longitude = Double.parseDouble(longitude);
	}
    public List<Clima> getClimas() {
		return climas;
	}
    public void setClimas(List<Clima> climas) {
		this.climas = climas;
	}
    public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
