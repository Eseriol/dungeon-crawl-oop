package com.codecool.dungeoncrawl.model;

import java.util.List;

public class GameSaveModel {
    private final GameStateModel gameStateModel;
    private final ActorModel player;
    private final List<ActorModel> monsters;
    private final InventoryModel inventoryModel;


    public GameSaveModel(GameStateModel gameStateModel, ActorModel player, List<ActorModel> monsters, InventoryModel inventoryModel) {
        this.gameStateModel = gameStateModel;
        this.player = player;
        this.monsters = monsters;
        this.inventoryModel = inventoryModel;
    }

    public GameStateModel getGameStateModel() {
        return gameStateModel;
    }

    public ActorModel getPlayer() {
        return player;
    }

    public List<ActorModel> getMonsters() {
        return monsters;
    }

    public InventoryModel getInventoryModel() {
        return inventoryModel;
    }
}


