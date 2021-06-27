package com.devsuperior.dspesquisa.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dspesquisa.dto.GameDTO;
import com.devsuperior.dspesquisa.entities.Game;
import com.devsuperior.dspesquisa.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository repository;
	
	//Converter uma lista de Game em uma lista de GameDTO com o recurso LAMBDA
	@Transactional(readOnly = true) //garante que toda transação será finalizada no service
	public List<GameDTO> findAll(){
		List<Game> list = repository.findAll();
		return list.stream().map( x -> new GameDTO(x)).collect(Collectors.toList());
	}
	
	
	

	

}
