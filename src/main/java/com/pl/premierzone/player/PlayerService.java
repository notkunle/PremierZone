package com.pl.premierzone.player;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component

public class PlayerService {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    public List<Player> getPlayersFromTeam(String teamName) {
        return playerRepository.findAll().stream().filter(player -> teamName.equals(player.getTeam())).collect(Collectors.toList());
    }

    public List<Player> getPlayersByName(String searchText) {
        return playerRepository.findAll().stream().filter(player -> player.getName().toLowerCase().contains(searchText.toLowerCase())).collect(Collectors.toList());
    }

    public List<Player> getPlayersByPosition(String searchText) {
        return playerRepository.findAll().stream().filter(player -> player.getPos().toLowerCase().contains(searchText.toLowerCase())).collect(Collectors.toList());
    }



}
