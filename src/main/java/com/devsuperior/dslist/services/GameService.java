package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

@Service //pro spring saber que ele tem que gerenciar
public class GameService {
    
    @Autowired // injeção de dependencia
    private GameRepository gameReposity;

    public List<GameMinDTO> findAll(){
        List<Game> result = gameReposity.findAll();
        return result.stream().map(x -> new GameMinDTO(x)).toList();

    }
}
