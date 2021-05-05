package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.actors.Actor;
import com.codecool.dungeoncrawl.logic.itemsLogic.Door;

import java.util.ArrayList;

public class Cell implements Drawable {
    private CellType type;
    private Actor actor;
    private GameMap gameMap;
    private int x, y;
    private Door door;

    Cell(GameMap gameMap, int x, int y, CellType type) {
        this.gameMap = gameMap;
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public CellType getType() { return type;}

    public void setType(CellType type) {
        this.type = type;
    }

    public void setActor(Actor actor) { this.actor = actor;}

    public void setDoor(Door door) {this.door = door;}

    public Actor getActor() {
        return actor;
    }

    public Cell getNeighbor(int dx, int dy) {
        return gameMap.getCell(x + dx, y + dy);
    }

    public ArrayList<Cell> getNeighbors() {
        ArrayList<Cell> cellList = new ArrayList<>();
        Cell up = gameMap.getCell(x, y + 1);
        Cell down = gameMap.getCell(x, y - 1);
        Cell right = gameMap.getCell(x + 1, y);
        Cell left = gameMap.getCell(x - 1, y);
        cellList.add(up);
        cellList.add(down);
        cellList.add(right);
        cellList.add(left);
        return cellList;
    }

    public void setEmptyTile(){
        this.type = CellType.FLOOR;
    }


    @Override
    public String getTileName() {
        return type.getTileName();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


}
