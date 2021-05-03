package com.codecool.dungeoncrawl.model;

import com.codecool.dungeoncrawl.logic.actors.Player;

public class PlayerModel extends BaseModel {
    private String currentMap;
    private String playerName;
    private int hp;
    private int x;
    private int y;
    private int defense;
    private int attack;


    public PlayerModel(Player player) {
        this.currentMap = player.getCell().getGameMap().getMapName();
        this.playerName = player.getName();
        this.x = player.getX();
        this.y = player.getY();
        this.defense = player.getDefense();
        this.attack = player.getAttack();
        this.hp = player.getHealth();
    }


    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDefense() {
        return defense;
    }

    public int getAttack() {
        return attack;
    }

    public String getCurrentMap() {
        return currentMap;
    }
}
