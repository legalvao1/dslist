package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.devsuperior.dslist.dto.GameListDTO;

import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameListRepository;
import com.devsuperior.dslist.repositories.GameRepository;

@Service //pro spring saber que ele tem que gerenciar
public class GameListService {
    
    @Autowired // injeção de dependencia
    private GameListRepository gameListReposity;

    @Autowired
    private GameRepository gameReposity;
    
    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListReposity.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }

    @Transactional // IMPORTANTE para garantir que todas as transações(alterações no banco) ocorram.
    // executa todas, salva em memória e envia de uma vez para o banco
    // Ou tudo dá certo ou da rollback em tudo e não salva nada.
    public void move(Long listId, int sourceIndex, int destIndex)
    {
        List<GameMinProjection> list = gameReposity.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destIndex, obj);

        int min = sourceIndex < destIndex ? sourceIndex : destIndex;
        int max = sourceIndex < destIndex ? destIndex : sourceIndex;

        for (int i = min; i <= max; i++)
        {
            gameListReposity.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
