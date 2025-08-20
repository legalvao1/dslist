package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.devsuperior.dslist.dto.GameListDTO;

import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.repositories.GameListRepository;

@Service //pro spring saber que ele tem que gerenciar
public class GameListService {
    
    @Autowired // injeção de dependencia
    private GameListRepository gameListReposity;
    
    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListReposity.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }

}
