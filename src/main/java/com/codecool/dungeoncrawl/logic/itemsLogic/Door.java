package com.codecool.dungeoncrawl.logic.itemsLogic;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.Drawable;

public class Door implements Drawable {
    private Cell cell;
    private boolean isDoorOpen = false;

    public Door(Cell cell){
        this.cell = cell;
        cell.setDoor(this);
    }


    @Override
    public String getTileName() {
        if (isDoorOpen) {
            return "doorOpen";
        } else {
            return "door";
        }
    }

    public Cell getCell() {return  cell;}

    public void openDoor() {isDoorOpen = true;}
}
