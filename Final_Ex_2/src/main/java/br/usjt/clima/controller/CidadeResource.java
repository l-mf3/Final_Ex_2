package br.usjt.clima.controller;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.usjt.clima.model.Cidade;
import br.usjt.clima.repository.CidadeRepository;
import br.usjt.clima.service.CidadeService;

@RestController
@RequestMapping("/cidades")
public class CidadeResource {
	@Autowired
	private CidadeRepository cidadeRepo;
	
	@Autowired
	private CidadeService cidadeService;
	
	@GetMapping("/lista")
	public List<Cidade> todas() {
		return cidadeRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Cidade buscarPeloId(@PathVariable Long id) {
		return cidadeRepo.getOne(id);
	}
	// TODO: Listar todas as cidades cujo nome começa com uma letra específica
	@GetMapping(value = {"/{latitude}/{longitude}"})
	public List<Cidade> busacarPeloNome(@PathVariable String nome) {
		return cidadeRepo.buscar(nome);
	}
	
	
	// TODO: Obter uma cidade por sua latitude e longitude
	@GetMapping(value = {"/{latitude}/{longitude}"})
	public Cidade findOneByLatitudeAndLongitude(@PathVariable Double latitude, Double longitude) {
		return cidadeRepo.buscarLatitudeLongitude(latitude, longitude);
	}
	
	@GetMapping(value="/cadastrar")
	public  Cidade cadastrar (@RequestBody Cidade cidade) {
		return cidadeService.salvar(cidade);
	}
	
	

	@PostMapping("/salvar")
	public ResponseEntity<Cidade> salvar(@RequestBody Cidade cidade, HttpServletResponse response) {
		Cidade c = cidadeRepo.save(cidade);
		URI uri = ServletUriComponentsBuilder.fromCurrentServletMapping().path("/{id}")
				.buildAndExpand(c.getId())
				.toUri();
		return ResponseEntity.created(uri).body(c);
	}
	
}
