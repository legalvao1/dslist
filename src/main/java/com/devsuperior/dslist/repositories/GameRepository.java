package com.devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dslist.entities.Game;
//O Jpa respositorie só permite uma chave primaria do tipo Long
public interface GameRepository extends JpaRepository<Game, Long>{
    
}
