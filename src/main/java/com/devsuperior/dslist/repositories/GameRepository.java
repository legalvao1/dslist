package com.devsuperior.dslist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;
//O Jpa respository só permite uma chave primaria do tipo Long
public interface GameRepository extends JpaRepository<Game, Long>{
    // consulta sql não jpql(linguagem consulta da JPA), então precisa adicionar o nativeQuery pra entender que é sql
    @Query(nativeQuery = true, value = """
		SELECT tb_game.id, tb_game.title, tb_game.game_year AS `year`, tb_game.img_url AS imgUrl,
		tb_game.short_description AS shortDescription, tb_belonging.position
		FROM tb_game
		INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
		WHERE tb_belonging.list_id = :listId
		ORDER BY tb_belonging.position
			""")
    //qndo usa sql resultado da consulta tem que ser uma interface(no spring é chamado de projection)
    List<GameMinProjection> searchByList(Long listId);
}
