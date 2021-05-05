package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.itemsLogic.Door;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public enum CellType {
    EMPTY("empty"),
    FLOOR("floor"),
    WALL("wall"),
    SWORD("sword"),
    KEY("key"),
    DOOR("door"),
    SKELETON("skeleton");

    public static ArrayList<CellType> getItemsList() {
        ArrayList<CellType> list = new ArrayList<>();
        list.add(SWORD);
        list.add(KEY);
        return list;
    }

    public static ArrayList<CellType> monsterList() {
        ArrayList<CellType> list = new ArrayList<>();
        list.add(SKELETON);
        return list;
    }

    private final String tileName;

    CellType(String tileName) {
        this.tileName = tileName;
    }

    public String getTileName() {
        return tileName;
    }
}
