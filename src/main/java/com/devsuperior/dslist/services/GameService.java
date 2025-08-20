package com.devsuperior.dslist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameRepository;

@Service //pro spring saber que ele tem que gerenciar
public class GameService {
    
    @Autowired // injeção de dependencia
    private GameRepository gameReposity;
    
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> result = gameReposity.findAll();
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }

    @Transactional(readOnly = true) //não bloqueia o banco para escrita, deixando mais rápido
    //boa pratica para que o service fique transacional, 
    //garantindo que as operações no banco vão acontecer
    //obedecendo o principio acid (atomica, consistente, isolada e duravel)
    public GameDTO findById(Long id){
        Game result = gameReposity.findById(id).get();
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId){
        List<GameMinProjection> result = gameReposity.searchByList(listId);
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }
}
