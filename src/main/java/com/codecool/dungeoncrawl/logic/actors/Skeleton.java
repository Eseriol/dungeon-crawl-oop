package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;

public class Skeleton extends Actor {
    public int shealth = 10;
    public Skeleton(Cell cell) {
        super(cell);
    }

    public void gotHit(int dmg){
        this.shealth = this.shealth - dmg;
    }

    @Override
    public String getTileName() {
        return "skeleton";
    }

    public int getShealth() {
        return this.shealth;
    }
}
