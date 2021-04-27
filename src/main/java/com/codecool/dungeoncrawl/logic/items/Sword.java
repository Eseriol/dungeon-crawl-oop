package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.map.Cell;

public class Sword extends Item {
    private final int damage;


    public Sword(Cell cell, String name, int damage) {
        super(cell, name);
        this.damage = damage;
    }


    @Override
    public boolean isPassable() {
        return true;
    }

    @Override
    public String getTileName() {
        return "sword";
    }
}