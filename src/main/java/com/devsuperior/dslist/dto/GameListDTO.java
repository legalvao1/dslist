package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.GameList;

public class GameListDTO {

    private Long id;
    private String name;

    public GameListDTO() {
    }

    public GameListDTO(GameList gamelist) {
        id = gamelist.getId();
        name = gamelist.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
