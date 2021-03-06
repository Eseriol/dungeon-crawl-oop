package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;
import com.codecool.dungeoncrawl.logic.Drawable;

public abstract class Actor implements Drawable {
    private Skeleton skeleton;
    private Cell cell;
    private int health = 10;
    private int damage = 5;


    public int getDamage() {
        return damage;
    }

    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if (nextCell.getType() == CellType.WALL || nextCell.getType() == CellType.SKELETON) { // mozna pozniej uzyc contains z listy przeciwnikow
            System.out.println("can't move!");
        } else if (nextCell.getType() == CellType.DOOR){
            System.out.println("I have to find a key first...");
        }
        else {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }
    }

    public int getHealth() {
        return health;
    }

    public Cell getCell() {
        return cell;
    }

    public int getX() {
        return cell.getX();
    }

    public int getY() {
        return cell.getY();
    }
}
