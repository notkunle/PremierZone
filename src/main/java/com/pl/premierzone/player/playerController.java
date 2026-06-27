package com.pl.premierzone.player;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
@RequestMapping(path = "api/v1/player")
public class playerController {
    private final PlayerService playerService;

    @Autowired
    public playerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getPlayers(
            @RequestParam(required = false) String team,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String position,
            @RequestParam(required = false) String nation
    ){
        if(team != null && name != null && position != null && nation != null){
            return playerService.getPlayersByTeamAndPosition(team, position);
        } else if(team != null){
                return playerService.getPlayersFromTeam(team);
        } else if (name != null){
            return playerService.getPlayersByName(name);
        } else if (position != null){
            return playerService.getPlayersByPosition(position);
        } else if (nation != null){
            return playerService.getPlayersByNation(nation);
        }

        return null;
    }
}
