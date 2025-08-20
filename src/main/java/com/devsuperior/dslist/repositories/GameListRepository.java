package com.devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dslist.entities.GameList;
//O Jpa respositorie só permite uma chave primaria do tipo Long
public interface GameListRepository extends JpaRepository<GameList, Long>{
    
}
