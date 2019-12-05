package br.usjt.clima.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import br.usjt.clima.model.Cidade;
import br.usjt.clima.repository.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepo;
	
	public Cidade salvar(Cidade cidade) {
		return cidadeRepo.save(cidade);
	}
	
	public List<Cidade> getAllCidade(){
		List<Cidade> listaCidades = cidadeRepo.findAll();
		return listaCidades;
	}
	
	

}
