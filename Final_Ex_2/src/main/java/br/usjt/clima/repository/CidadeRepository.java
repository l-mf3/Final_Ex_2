package br.usjt.clima.repository;

import java.util.List;
import java.util.concurrent.Future;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Async;

import br.usjt.clima.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
	public Cidade findOneByLatitudeAndLongitude(Double latitude, Double longitude);
	public List<Cidade> findByNomeContainingIgnoreCase(String nome);
	
	@Async
	public Future<List<Cidade>> findByNome(String nome);
	
	@Query("select c from Cidade c where c.latitude = :latitude and c.longitude = :longitude")
	public Cidade buscarLatitudeLongitude(double latitude, double longitude);
	
	
	@Query("select c do Cidade c where c.nome like %?1")
	public List<Cidade> buscar(String nome);

}
